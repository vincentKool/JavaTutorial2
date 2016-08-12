package tutorial.services.twitter;

import retrofit2.Response;
import tutorial.services.twitter.api.SearchResponse;
import tutorial.services.twitter.api.TwitterTweet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class TwitterService {

    TwitterApi twitterApi;

    public TwitterService (TwitterApi twitterApi) {this.twitterApi = twitterApi; }

    public List<TwitterTweet> searchTweets(String query){
        try {
            Response<SearchResponse> response = twitterApi.searchTweets(query).execute();

            return response.body().getItems();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
