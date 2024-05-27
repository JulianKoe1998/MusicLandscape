package MusicLandscape.entities;

// Class representing an artist
public class Artist {
    // Private member variable to store the name of the artist
    private String name;

    // Constructor with a default name "unknown"
    public Artist() {
        this.name = "unknown";
    }

    // Copy constructor
    public Artist(Artist a) {
        // Copy the name from the provided artist
        this.name = a.name;
    }

    // Constructor with a specified name
    public Artist(String name) {
        // Set the name of the artist
        this.name = name;
    }

    // Method to set the name of the artist
    public void setName(String name) {
        // Check if the provided name is null or empty
        if (name == null || name.trim().isEmpty()) {
            // If null or empty, set the name to "unknown"
            this.name = "unknown";
        } else {
            // Otherwise, set the name to the provided name
            this.name = name;
        }
    }

    // Method to get the name of the artist
    public String getName() {
        return name;
    }

    // Override the toString() method to return the name of the artist
    @Override
    public String toString() {
        // Check if the name is null or empty
        if (name == null || name.trim().isEmpty()) {
            // If null or empty, return "unknown"
            return "unknown";
        } else {
            // Otherwise, return the name
            return name;
        }
    }
}
