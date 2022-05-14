package kg.junesqo.newsapp.data.remote;

import kg.junesqo.newsapp.data.model.MainResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("top-headlines")
    Call<MainResponse> getTopNews(
            @Query("apiKey") String apiKey,
            @Query("country") String country
    );
}
