package kg.junesqo.newsapp.di;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import kg.junesqo.newsapp.data.remote.NewsApi;
import kg.junesqo.newsapp.data.repositories.NewsRepositoriesImpl;
import kg.junesqo.newsapp.domain.repositories.NewsRepository;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn({SingletonComponent.class})
public class AppModule {

    @Provides
    public static OkHttpClient provideBaseOkHttpClient(){
        return new OkHttpClient.Builder()
                .addInterceptor(
                        new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)
                ).build();
    }

//    @Provides
//    public static OkHttpClient provideAuthOkHttpClient(){
//        return new OkHttpClient.Builder()
//                .addInterceptor(
//                        new HttpLoggingInterceptor()
//                                .setLevel(HttpLoggingInterceptor.Level.BODY)
//                ).build();
//    }

    @Provides
    public static Retrofit provideRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    public static NewsApi provideApi(Retrofit retrofit) {
        return retrofit.create(NewsApi.class);
    }

    @Provides
    public static NewsRepository provideNewsRepository(NewsApi api) {
        return new NewsRepositoriesImpl(api);
    }
}
