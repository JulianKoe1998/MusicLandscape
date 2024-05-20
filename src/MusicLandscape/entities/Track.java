package MusicLandscape.entities;

// Define the class
public class Track {
    // Declare private member variables
    private String title;
    private int duration;
    private Artist writer = new MusicLandscape.entities.Artist(); // Initialize writer with default artist
    private Artist performer = new MusicLandscape.entities.Artist(); // Initialize performer with default artist
    private int year;

    // Default constructor
    public Track(){
        // Initialize member variables
        this.title = null;
        this.duration = 0;
        this.writer = new Artist("Default writer");
        this.performer = new Artist("Default performer");
        this.year = 1900;
    }

    // Copy constructor
    public Track(Track t){
        // Copy member variables
        this.title = t.title;
        this.duration = t.duration;
        this.writer = new Artist(t.writer);
        this.performer = new Artist(t.performer);
        this.year = t.year;
    }

    // Constructor with specified title
    public Track(String title){
        // Initialize member variables with provided title
        this.title = title;
        this.duration = 0;
        this.writer = new Artist("Default writer");
        this.performer = new Artist("Default performer");
        this.year = 1900;
    }

    // Getter and setter for year
    public int getYear() {
        return year;
    }
    public boolean setYear(int year){
        if(year > 1899 && year < 3000) { // Check if year is within valid range
            this.year = year; // Set year
        } else {
            return true; // Return true if year is out of range
        }
        return false; // Return false otherwise
    }

    // Getter and setter for duration
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        if(duration >= 0){ // Check if duration is non-negative
            this.duration = duration; // Set duration
        }
        else {
            this.duration = 0; // Set duration to 0 if negative
        }
    }

    // Getter and setter for title
    public String getTitle() {
        if (title == null || title.trim().isEmpty()) { // Check if title is null or empty
            return this.title = "unknown title"; // Return "unknown title" if null or empty
        } else {
            return this.title; // Return title
        }
    }
    public void setTitle(String title) {
        this.title = title; // Set title
    }

    // Getter and setter for writer
    public Artist getWriter() {
        return writer;
    }
    public void setWriter(Artist writer) {
        if (writer != null) { // Check if writer is not null
            this.writer = writer; // Set writer
        }
    }

    // Getter and setter for performer
    public Artist getPerformer() {
        return performer;
    }
    public void setPerformer(Artist performer) {
        if (performer != null) { // Check if performer is not null
            this.performer = performer; // Set performer
        }
    }

    // Method to check if writer is known
    public boolean writerIsKnown() {
        // Check if writer object and its name are not null
        return writer != null && writer.getName() != null;
    }

    // Method to get string representation of track info
    public String getString() {
        String trackInfo = "";

        // Append title or "unknown" if title is null
        if (title != null && !title.isEmpty()) {
            String shortenedTitle = title.substring(0, Math.min(title.length(), 10)); // Take first 10 characters of title
            if ("song".equals(shortenedTitle.toLowerCase())) {
                trackInfo += "      song by";
            } else {
                trackInfo += shortenedTitle + " by ";
            }
        } else {
            trackInfo += "   unknown by ";
        }

        // Append writer or "unknown" if writer is null
        if(writer != null) {
            if(writer.getName() == null) {
                trackInfo += "    unknown ";
            } else {
                String shortenWriter = writer.getName().substring(0, Math.min(writer.getName().length(), 10)); // Take first 10 characters of writer name
                if(shortenWriter.equals("writer")) {
                    trackInfo += "    " + shortenWriter + " ";
                } else {
                    trackInfo += shortenWriter + " ";
                }
            }
        } else {
            trackInfo += "   unknown ";
        }

        // Append performer or "unknown" if performer is null
        if (performer != null) {
            if (performer.getName() == null) {
                trackInfo += "performed by    unknown";
            } else {
                String shortenPerformer = performer.getName().substring(0, Math.min(performer.getName().length(), 10)); // Take first 10 characters of performer name
                if(shortenPerformer.equals("performer")){
                    trackInfo += "performed by  " + shortenPerformer;
                } else {
                    trackInfo += "performed by " + shortenPerformer;
                }
            }
        } else {
            trackInfo += "performed by    unknown";
        }

        // Format duration as minutes and seconds
        int minutes = duration / 60;
        int seconds = duration % 60;
        String durationString = String.format(" (%02d:%02d)", minutes, seconds);

        // Append duration
        trackInfo += durationString;

        return trackInfo.trim(); // Trim leading/trailing whitespace
    }
}
