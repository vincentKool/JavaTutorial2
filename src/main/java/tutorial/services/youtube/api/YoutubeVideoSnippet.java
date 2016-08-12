package tutorial.services.youtube.api;

import java.util.Date;

public class YoutubeVideoSnippet {

    String title;
    String description;
    Date publishedAt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishedAt() {return publishedAt; }

    public void setPublishedAt(Date publishedAt) { this.publishedAt = publishedAt; }
}
