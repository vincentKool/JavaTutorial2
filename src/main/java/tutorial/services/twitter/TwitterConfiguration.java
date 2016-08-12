package tutorial.services.twitter;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tutorial.ApplicationConfiguration;

import java.io.IOException;

@Configuration
public class TwitterConfiguration {

    @Autowired
    ApplicationConfiguration applicationConfiguration;

    @Bean
    public TwitterService twitterService() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                Headers headers = request.headers()
                        .newBuilder()
                        .add("Authorization", "Bearer "+ applicationConfiguration.getTwitterBearer())
                        .build();

                request = request.newBuilder().headers(headers).build();
                return chain.proceed(request);
            }
        }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TwitterApi.TWITTER_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        TwitterApi twitterApi = retrofit.create(TwitterApi.class);

        return new TwitterService(twitterApi);
    }

}
