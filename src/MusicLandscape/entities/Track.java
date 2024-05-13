package MusicLandscape.entities;

// Class representing a musical track
public class Track {
    // Fields of the class
    private String title;
    private int duration;  // Duration in seconds
    private Artist writer = new Artist();  // The artist who wrote the track
    private Artist performer = new Artist();  // The artist who performs the track
    private int year;  // Release year of the track

    // Default constructor
    public Track() {
    }

    // Getter for the year of the track
    public int getYear() {
        return this.year;
    }

    // Setter for the year; returns false if year is valid, true otherwise
    public boolean setYear(int year) {
        if (year > 1899 && year < 3000) {
            this.year = year;
            return false;
        } else {
            return true;
        }
    }

    // Getter for the duration of the track
    public int getDuration() {
        return this.duration;
    }

    // Setter for the duration; ensures duration is non-negative
    public void setDuration(int duration) {
        if (duration >= 0) {
            this.duration = duration;
        } else {
            this.duration = 0;
        }
    }

    // Getter for the track title, defaults to "unknown title" if not set or empty
    public String getTitle() {
        return this.title != null && !this.title.trim().isEmpty() ? this.title : (this.title = "unknown title");
    }

    // Setter for the track title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for the writer (Artist object)
    public Artist getWriter() {
        return this.writer;
    }

    // Setter for the writer, prevents setting a null writer
    public void setWriter(Artist writer) {
        if (writer != null) {
            this.writer = writer;
        }
    }

    // Getter for the performer (Artist object)
    public Artist getPerformer() {
        return this.performer;
    }

    // Setter for the performer, prevents setting a null performer
    public void setPerformer(Artist performer) {
        if (performer != null) {
            this.performer = performer;
        }
    }

    // Checks if the writer is known (not null and has a name)
    public boolean writerIsKnown() {
        return this.writer != null && this.writer.getName() != null;
    }

    // Generates a string representation of the track with concise information
    public String getString() {
        String trackInfo = "";
        String shortenPerformer;
        if (this.title != null && !this.title.isEmpty()) {
            shortenPerformer = this.title.substring(0, Math.min(this.title.length(), 10));
            if ("song".equals(shortenPerformer.toLowerCase())) {
                trackInfo = trackInfo + "      song by";
            } else {
                trackInfo = trackInfo + shortenPerformer + " by ";
            }
        } else {
            trackInfo = trackInfo + "   unknown by ";
        }

        if (this.writer != null) {
            if (this.writer.getName() == null) {
                trackInfo = trackInfo + "    unknown ";
            } else {
                shortenPerformer = this.writer.getName().substring(0, Math.min(this.writer.getName().length(), 10));
                if (shortenPerformer.equals("writer")) {
                    trackInfo = trackInfo + "    " + shortenPerformer + " ";
                } else {
                    trackInfo = trackInfo + shortenPerformer + " ";
                }
            }
        } else {
            trackInfo = trackInfo + "   unknown ";
        }

        if (this.performer != null) {
            if (this.performer.getName() == null) {
                trackInfo = trackInfo + "performed by    unknown";
            } else {
                shortenPerformer = this.performer.getName().substring(0, Math.min(this.performer.getName().length(), 10));
                if (shortenPerformer.equals("performer")) {
                    trackInfo = trackInfo + "performed by  " + shortenPerformer;
                } else {
                    trackInfo = trackInfo + "performed by " + shortenPerformer;
                }
            }
        } else {
            trackInfo = trackInfo + "performed by    unknown";
        }

        // Calculate and format the duration as MM:SS
        int minutes = this.duration / 60;
        int seconds = this.duration % 60;
        String durationString = String.format(" (%02d:%02d)", minutes, seconds);
        trackInfo = trackInfo + durationString;
        return trackInfo;
    }
}
