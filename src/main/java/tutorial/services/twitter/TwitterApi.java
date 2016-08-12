package tutorial.services.twitter;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tutorial.services.twitter.api.SearchResponse;

public interface TwitterApi {

    String TWITTER_API_URL = "https://api.twitter.com/1.1/";

    @GET("search/tweets.json?lang=nl")
    Call<SearchResponse> searchTweets(@Query("q") String q);

}
