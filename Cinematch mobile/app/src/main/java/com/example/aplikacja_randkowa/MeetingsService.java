package com.example.aplikacja_randkowa;

import org.osmdroid.util.GeoPoint;

import java.util.ArrayList;
import java.util.List;

public class MeetingsService {
    List<Meeting> meetings = new ArrayList<>();

    public void addMeeting(String contactName, GeoPoint meetingLocation) {
        Meeting meeting = new Meeting();
        meeting.setContactName(contactName);
        meeting.setMeetingLocation(meetingLocation);
        meetings.add(meeting);
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }
}
