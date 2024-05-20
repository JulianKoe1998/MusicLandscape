package MusicLandscape.entities;

// Import Date class + Venue
import MusicLandscape.Date;
import MusicLandscape.Venue;

// Define the class
public class Event {
    // Declare private member variables
    private Artist artist;
    private int attendees;
    private Date date;
    private String description;
    private Venue venue;

    // Default constructor
    public Event(){
        this.artist = new Artist(); // Initialize artist with default constructor
        this.description = ""; // Set description to empty string
    }

    // Getter and setter for artist
    public Artist getArtist() {
        return artist;
    }
    public void setArtist(Artist artist) {
        if(artist != null) { // Check if artist is not null
            this.artist = artist; // Set artist
        }
    }

    // Getter and setter for venue
    public Venue getVenue(){
        return venue;
    }
    public void setVenue(Venue venue) {
        this.venue = venue; // Set venue
    }

    // Getter and setter for date
    public Date getDate() {
        if(date == null){
            return null; // Return null if date is null
        } else {
            return new Date(date); // Return a copy of the date
        }
    }
    public void setDate(Date date) {
        if(date != null) { // Check if date is not null
            this.date = new Date(date); // Set date with a copy of the provided date
        } else {
            this.date = null; // Set date to null
        }
    }

    // Getter and setter for attendees
    public int getAttendees() {
        return attendees;
    }
    public void setAttendees(int attendees) {
        if(attendees >= 0) { // Check if attendees is non-negative
            this.attendees = attendees; // Set attendees
        }
    }

    // Getter and setter for description
    public String getDescription() {
        return description; // Return description
    }
    public void setDescription(String description) {
        if(description != null){ // Check if description is not null
            this.description = description; // Set description
        } else {
            this.description = ""; // Set description to empty string
        }
    }
}
