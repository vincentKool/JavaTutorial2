package tutorial.services.youtube.api;

public class YoutubeVideo {

    YoutubeVideoId id;
    YoutubeVideoSnippet snippet;

    public YoutubeVideoId getId() {
        return id;
    }

    public void setId(YoutubeVideoId id) {
        this.id = id;
    }

    public YoutubeVideoSnippet getSnippet() {
        return snippet;
    }

    public void setSnippet(YoutubeVideoSnippet snippet) {
        this.snippet = snippet;
    }

}