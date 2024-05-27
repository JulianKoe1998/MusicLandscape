package MusicLandscape.entities;

// Class representing a musical track
public class Track {
    // Private member variables
    private String title; // Title of the track
    private int duration; // Duration of the track in seconds
    private Artist writer; // Writer of the track
    private Artist performer; // Performer of the track
    private int year; // Year the track was released

    // Default constructor
    public Track() {
        // Initialize member variables with default values
        this.title = null;
        this.duration = 0;
        this.writer = new Artist("Default writer");
        this.performer = new Artist("Default performer");
        this.year = 1900;
    }

    // Copy constructor for deep copy
    public Track(Track t) {
        // Copy values from the provided track
        this.title = t.title;
        this.duration = t.duration;
        this.writer = new Artist(t.writer);
        this.performer = new Artist(t.performer);
        this.year = t.year;
    }

    // Constructor with a specified title
    public Track(String title) {
        // Initialize member variables with specified title and default values
        this.title = title;
        this.duration = 0;
        this.writer = new Artist("Default writer");
        this.performer = new Artist("Default performer");
        this.year = 1900;
    }

    // Getter and setter methods for member variables
    public int getYear() {
        return year;
    }

    public boolean setYear(int year) {
        // Check if the year is valid and set it if it is
        if (year > 1899 && year < 3000) {
            this.year = year;
            return true;
        } else {
            return false;
        }
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        // Set the duration if it is non-negative
        if (duration >= 0) {
            this.duration = duration;
        } else {
            this.duration = 0;
        }
    }

    public String getTitle() {
        // Return the title or "unknown title" if it is null or empty
        return (title == null || title.trim().isEmpty()) ? "unknown title" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getWriter() {
        return writer;
    }

    public void setWriter(Artist writer) {
        if (writer != null) {
            this.writer = writer;
        }
    }

    public Artist getPerformer() {
        return performer;
    }

    public void setPerformer(Artist performer) {
        if (performer != null) {
            this.performer = performer;
        }
    }

    // Method to check if the writer is known
    public boolean writerIsKnown() {
        // Check if the writer is not null and has a non-null name
        return writer != null && writer.getName() != null;
    }

    // Method to get a formatted string representation of the track
    public String getString() {
        StringBuilder trackInfo = new StringBuilder();

        // Append title or "unknown" if title is null
        if (title != null && !title.isEmpty()) {
            String shortenedTitle = title.substring(0, Math.min(title.length(), 10));
            trackInfo.append(shortenedTitle).append(" by ");
        } else {
            trackInfo.append("unknown by ");
        }

        // Append writer "unknown" if writer is null
        if (writer != null) {
            String shortenWriter = writer.getName().substring(0, Math.min(writer.getName().length(), 10));
            trackInfo.append(shortenWriter).append(" ");
        } else {
            trackInfo.append("unknown ");
        }

        // Append performer "unknown" if performer is null
        if (performer != null) {
            String shortenPerformer = performer.getName().substring(0, Math.min(performer.getName().length(), 10));
            trackInfo.append("performed by ").append(shortenPerformer);
        } else {
            trackInfo.append("performed by unknown");
        }

        // Format duration as minutes and seconds
        int minutes = duration / 60;
        int seconds = duration % 60;
        String durationString = String.format(" (%02d:%02d)", minutes, seconds);

        // Append duration
        trackInfo.append(durationString);

        return trackInfo.toString(); // Trim leading/trailing whitespace
    }

    // Override toString method to provide a string representation of the track
    @Override
    public String toString() {
        return getString();
    }
}
