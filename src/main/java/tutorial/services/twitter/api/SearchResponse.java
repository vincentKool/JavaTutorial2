package tutorial.services.twitter.api;

import java.util.List;

public class SearchResponse {

    private List<TwitterTweet> statuses;

    public List<TwitterTweet> getItems() {
        return statuses;
    }

    public void setItems(List<TwitterTweet> items) {
        this.statuses = statuses;
    }

}