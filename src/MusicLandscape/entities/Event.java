package MusicLandscape.entities;

// Class representing an event
public class Event {
    // Private member variables
    private Artist artist; // The artist performing at the event
    private int attendees; // Number of attendees at the event
    private Date date; // MusicLandscape.entities.Date of the event
    private String description; // Description of the event
    private Venue venue; // MusicLandscape.entities.Venue of the event

    // Default constructor
    public Event() {
        // Initialize artist with a default unknown artist and an empty description
        this.artist = new Artist();
        this.description = "";
    }

    // Copy constructor
    public Event(Event e) {
        // Create copies of all fields from the provided event
        this.artist = new Artist(e.getArtist());
        this.attendees = e.getAttendees();
        this.date = new Date(e.getDate());
        this.description = e.getDescription();
        this.venue = new Venue(e.getVenue());
    }

    // Getter and setter methods
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        if (artist != null) {
            this.artist = artist;
        }
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Date getDate() {
        if (date == null) {
            return null;
        } else {
            return new Date(date);
        }
    }

    public void setDate(Date date) {
        if (date != null) {
            this.date = new Date(date);
        } else {
            this.date = null;
        }
    }

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        if (attendees >= 0) {
            this.attendees = attendees;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null) {
            this.description = description;
        } else {
            this.description = "";
        }
    }

    // Override toString method to provide a string representation of the event
    @Override
    public String toString() {
        // Get string representations of fields or default to "unknown" if null or empty
        String artistStr = (artist != null && artist.toString() != null && !artist.toString().isEmpty()) ? artist.toString() : "unknown";
        String venueStr = (venue != null && venue.getName() != null && !venue.getName().isEmpty()) ? venue.getName() : "unknown";
        String dateStr = (date != null) ? date.toString() : "unknown"; // Assuming MusicLandscape.entities.Date class has a proper toString method
        String descriptionStr = (description != null && !description.isEmpty()) ? description : "unknown";
        String attendeesStr = (attendees > 0) ? String.valueOf(attendees) : "unknown";

        // Assuming impact is calculated in some way, otherwise set it to "unknown"
        String impactStr = String.valueOf(impact());

        // Format the string representation of the event
        return String.format("%s @ %s on %s%n%s%n(%s attending (%s))",
                artistStr, venueStr, dateStr, descriptionStr, attendeesStr, impactStr);
    }

    // Method to calculate the impact of the event
    public int impact() {
        return (attendees * 2); // Assuming a simple impact calculation
    }
}
