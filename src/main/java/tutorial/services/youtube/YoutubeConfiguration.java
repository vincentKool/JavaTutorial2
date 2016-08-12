package tutorial.services.youtube;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tutorial.ApplicationConfiguration;

import java.io.IOException;

@Configuration
public class YoutubeConfiguration {

    @Autowired
    ApplicationConfiguration applicationConfiguration;

    @Bean
    public YoutubeService youtubeService() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor
                (new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();

                        HttpUrl url = request.url()
                                .newBuilder()
                                .addQueryParameter("key", applicationConfiguration
                                        .getYoutubeApiKey())
                                .build();

                        request = request.newBuilder().url(url).build();

                        return chain.proceed(request);
                    }
                }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(YoutubeApi.YOUTUBE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        YoutubeApi youtubeApi = retrofit.create(YoutubeApi.class);

        return new YoutubeService(youtubeApi);
    }

}
