package MusicLandscape.entities;

// Class representing a TV show, a type of event
public class TVShow extends Event {
    // Private member variables
    private String name; // Name of the TV show
    private int viewers; // Number of viewers of the TV show

    // Default constructor
    public TVShow() {
        // Initialize name with "unknown" and viewers with 0
        this.name = "unknown";
        this.viewers = 0;
    }

    // Constructor that performs a deep copy of an Event
    public TVShow(Event e) {
        super(new Event(e)); // Call copy constructor of Event
        this.viewers = 0;
    }

    // Copy constructor
    public TVShow(TVShow tvs) {
        // Copy values from the provided TVShow
        this.name = tvs.name;
        this.viewers = tvs.viewers;
    }

    // Getter and setter methods for member variables
    public int getViewers() {
        return this.viewers;
    }

    public void setViewers(int v) {
        this.viewers = v;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Override toString method to provide a string representation of the TV show
    @Override
    public String toString() {
        return String.format("%s @ %s on %s\n%s\n(%d attending (%d))",
                getName(), name, getDate(), getDescription(), impact());
    }

    // Override impact method to calculate the impact of the TV show
    @Override
    public int impact() {
        return (viewers * getAttendees() * 2);
    }
}
