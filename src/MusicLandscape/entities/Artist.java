package MusicLandscape.entities;

public class Artist {
    private String name; // Declare private member variable

    // Default constructor with unknown name
    public Artist() {
        this.name = "unknown";
    }

    // Copy constructor
    public Artist(Artist a) {
        this.name = a.name;
    }

    // Constructor with specified name
    public Artist(String name) {
        this.name = name;
    }

    // Method to set the name, handles null or empty values
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "unknown";
        } else {
            this.name = name;
        }
    }

    // Method to get the name
    public String getName() {
        return name;
    }
}
