package MusicLandscape.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Class representing a concert, a type of event
public class Concert extends Event {
    // Private member variables
    private int nextIdx; // Index for the next track to be added
    private Track[] setList; // Array to store the setlist of tracks

    // Default constructor
    public Concert() {
        // Initialize setList array with a capacity of 10
        this.setList = new Track[10];
        // Initialize nextIdx to 0
        this.nextIdx = 0;
    }

    // Method to add a track to the setlist
    public boolean addTrack(Track t) {
        // Check if the track is null
        if (t == null) {
            return false; // Return false if the track is null
        }
        // Ensure capacity of the setlist array
        ensureCapacity(nextIdx + 1);
        // Add the track to the setlist and increment nextIdx
        setList[nextIdx++] = t;
        return true;
    }

    // Method to ensure capacity of the setlist array
    private void ensureCapacity(int length) {
        if (length > setList.length) {
            // Double the capacity of the setlist array if needed
            Track[] newSetList = new Track[setList.length * 2];
            System.arraycopy(setList, 0, newSetList, 0, setList.length);
            setList = newSetList;
        }
    }

    // Method to get a copy of the setlist
    public Track[] getSetList() {
        // Count non-null tracks in the setlist
        int cnt = 0;
        for (int i = 0; i < nextIdx; i++) {
            if (setList[i] != null) {
                cnt++;
            }
        }
        // Create a new array to store deep copies of non-null tracks
        Track[] copy = new Track[cnt];
        int copycnt = 0;
        for (int i = 0; i < nextIdx; i++) {
            if (setList[i] != null) {
                copy[copycnt++] = new Track(setList[i]); // Deep copy of each track
            }
        }
        return copy; // Return the copy of the setlist
    }

    // Method to set the setlist with deep copies of provided tracks
    public void setSetList(Track[] tracks) {
        if (tracks == null) {
            return; // Ignore the null argument
        }
        // Create a new list to store deep copies of non-null tracks
        List<Track> newSetlist = new ArrayList<>();
        for (Track track : tracks) {
            if (track != null) {
                newSetlist.add(new Track(track));
            }
        }
        this.setList = newSetlist.toArray(new Track[0]); // Convert list to array
    }

    // Method to reset the setlist
    public void resetSetList() {
        // Fill the setlist array with nulls and reset nextIdx to 0
        Arrays.fill(setList, null);
        nextIdx = 0;
    }

    // Method to get the number of tracks in the setlist
    public int nrTracks() {
        return nextIdx; // Return the number of tracks added
    }

    // Method to calculate the duration of the concert in seconds
    public int duration() {
        int total_duration = 0;
        if (setList != null) {
            // Calculate the total duration by summing durations of each track
            for (Track track : setList) {
                if (track != null) {
                    total_duration += track.getDuration(); // Track duration in seconds, 0 if unknown
                }
            }
        }
        return total_duration; // Return the total duration
    }

    // Override the impact method to calculate the impact of the concert
    @Override
    public int impact() {
        int durationMin = duration(); // Calculate the duration of the concert in minutes
        int durationFactor = (durationMin / 30) + 1; // Calculate the duration factor
        return getAttendees() * durationFactor; // Return the impact of the concert
    }

    // Override the toString method to provide a string representation of the concert
    @Override
    public String toString() {
        // Get the base string representation from the superclass
        String baseString = super.toString();
        int numTracks = setList.length; // Get the number of tracks in the setlist
        int totalDuration = duration(); // Get the total duration of the concert
        int hours = totalDuration / 3600; // Calculate hours from total duration
        int minutes = (totalDuration % 3600) / 60; // Calculate minutes from total duration
        // Format the duration string as HH:MM
        String durationString = String.format("%02d:%02d", hours, minutes);
        // Return the formatted string representation of the concert
        return String.format("%s\n%d tracks played, total duration %s", baseString, numTracks, durationString);
    }
}
