package com.example.aplikacja_randkowa;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import java.util.List;
import java.util.stream.Collectors;

public class MapActivity extends AppCompatActivity {

    private ContactMain contactMain = new ContactMain();
    private MeetingsService service = new MeetingsService();
    private MapView map;
    private List<String> contacts;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        contacts = contactMain.getMockContacts().stream().map(Contact::getName).collect(Collectors.toList());

        Configuration.getInstance().setUserAgentValue(getApplicationContext().getPackageName());

        map = findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);

        IMapController mapController = map.getController();
        mapController.setZoom(15.0);
        GeoPoint startPoint = new GeoPoint(51.935619, 15.506186);
        mapController.setCenter(startPoint);


        map.getOverlayManager().getTilesOverlay().setLoadingBackgroundColor(0x00000000);

        map.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    GeoPoint longClickPoint = (GeoPoint) map.getProjection().fromPixels((int) event.getX(), (int) event.getY());
                    showContactDialog(longClickPoint);
                }
                return true;
            }
        });
    }

    private void showContactDialog(GeoPoint point) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose a contact")
                .setItems(contacts.toArray(new String[0]), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String selectedContact = contacts.get(which);
                        addMarker(point, selectedContact);
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private void addMarker(GeoPoint point, String contactName) {
        Marker marker = new Marker(map);
        marker.setPosition(point);
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker.setTitle(contactName);
        service.addMeeting(contactName, point);
        map.getOverlays().add(marker);
        map.invalidate();
    }

    @Override
    public void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        map.onPause();
    }
}