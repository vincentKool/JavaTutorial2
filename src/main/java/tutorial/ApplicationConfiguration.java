package tutorial;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfiguration {

    @Value("${application.youtube.api_key}")
    private String youtubeApiKey;

    public String getYoutubeApiKey() {
        return youtubeApiKey;
    }

    @Value("${application.twitter.bearer_token}")
    private String twitterBearer;

    public String getTwitterBearer() {
        return twitterBearer;
    }


}
