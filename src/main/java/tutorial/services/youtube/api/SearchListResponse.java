package tutorial.services.youtube.api;

import java.util.List;

public class SearchListResponse {

    private List<YoutubeVideo> items;

    public List<YoutubeVideo> getItems() {
        return items;
    }

    public void setItems(List<YoutubeVideo> items) {
        this.items = items;
    }

}