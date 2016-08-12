package tutorial.services.youtube;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tutorial.services.youtube.api.SearchListResponse;

public interface YoutubeApi {

    String YOUTUBE_API_URL = "https://www.googleapis.com/youtube/v3/";

    @GET("search?part=snippet&type=video")
    Call<SearchListResponse> searchList(@Query("q") String q);

}
