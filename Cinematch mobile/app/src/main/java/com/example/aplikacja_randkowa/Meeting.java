package com.example.aplikacja_randkowa;

import org.osmdroid.util.GeoPoint;

public class Meeting {
    private String contactName;
    private GeoPoint meetingLocation;

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }



    public GeoPoint getMeetingLocation() {
        return meetingLocation;
    }

    public void setMeetingLocation(GeoPoint meetingLocation) {
        this.meetingLocation = meetingLocation;
    }


}
