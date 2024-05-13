package MusicLandscape.entities;

/**
 * Represents an Artist with a name.
 */
public class Artist {
    // Attribute to hold the name of the artist
    private String name;

    /**
     * Default constructor.
     * Initializes the artist with no name.
     */
    public Artist() {
        this.name = null;
    }

    /**
     * Constructor with artist name.
     * @param name The name of the artist.
     */
    public Artist(String name) {
        this.name = name;
    }

    /**
     * Sets the name of the artist.
     * If the provided name is null or empty, the name is set to null.
     * @param name The new name of the artist.
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;  // Set name if it is not null or empty
        } else {
            this.name = null;  // Reset name to null if input is invalid
        }
    }

    /**
     * Gets the name of the artist.
     * @return The name of the artist or null if no name has been set.
     */
    public String getName() {
        return this.name;
    }
}
