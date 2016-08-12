package tutorial.services.youtube;

import retrofit2.Response;
import tutorial.services.youtube.api.SearchListResponse;
import tutorial.services.youtube.api.YoutubeVideo;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class YoutubeService {

    YoutubeApi youtubeApi;

    public YoutubeService(YoutubeApi youtubeApi) {
        this.youtubeApi = youtubeApi;
    }

    public List<YoutubeVideo> searchVideos(String query) {
        try {
            Response<SearchListResponse> response = youtubeApi.searchList
                    (query).execute();

            return response.body().getItems();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

}
