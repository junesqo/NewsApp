package kg.junesqo.newsapp.data.repositories;

import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import kg.junesqo.newsapp.common.Resource;
import kg.junesqo.newsapp.data.model.MainResponse;
import kg.junesqo.newsapp.data.remote.NewsApi;
import kg.junesqo.newsapp.domain.repositories.NewsRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepositoriesImpl implements NewsRepository {

    private final String API_KEY = "bfe58d5883544f1d8d0b1447c0d98243";
    private MutableLiveData<Resource<MainResponse>> liveData = new MutableLiveData<>();
    private NewsApi api;

    @Inject
    public NewsRepositoriesImpl(NewsApi api) {
        this.api = api;
    }

    @Override
    public MutableLiveData<Resource<MainResponse>> getTopNews() {
        liveData.setValue(Resource.loading());
        api.getTopNews(API_KEY, "ru").enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    liveData.setValue(Resource.success(response.body()));
                } else {
                    liveData.setValue(Resource.error(response.message(), null));
                }
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                liveData.setValue(Resource.error(t.getLocalizedMessage(), null));
            }
        });
        return liveData;
    }

    @Override
    public MutableLiveData<Resource<MainResponse>> getBusinessNews() {
        liveData.setValue(Resource.loading());
        api.getBusinessNews(API_KEY,"ru")
                .enqueue(new Callback<MainResponse>() {
                    @Override
                    public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                        if(response.isSuccessful() && response.body()!=null){
                            liveData.setValue(Resource.success(response.body()));
                        }else{
                            liveData.setValue(Resource.error(response.message(),null));
                        }
                    }

                    @Override
                    public void onFailure(Call<MainResponse> call, Throwable t) {
                        liveData.setValue(Resource.error(t.getLocalizedMessage(),null));

                    }
                });
        return liveData;
    }

    @Override
    public MutableLiveData<Resource<MainResponse>> getEntertainmentNews() {
        liveData.setValue(Resource.loading());
        api.getEntertainmentNews(API_KEY,"ru")
                .enqueue(new Callback<MainResponse>() {
                    @Override
                    public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                        if(response.isSuccessful() && response.body()!=null){
                            liveData.setValue(Resource.success(response.body()));
                        }else{
                            liveData.setValue(Resource.error(response.message(),null));
                        }
                    }

                    @Override
                    public void onFailure(Call<MainResponse> call, Throwable t) {
                        liveData.setValue(Resource.error(t.getLocalizedMessage(),null));

                    }
                });
        return liveData;
    }

    @Override
    public MutableLiveData<Resource<MainResponse>> getGeneralNews() {
        liveData.setValue(Resource.loading());
        api.getGeneralNews(API_KEY,"ru")
                .enqueue(new Callback<MainResponse>() {
                    @Override
                    public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                        if(response.isSuccessful() && response.body()!=null){
                            liveData.setValue(Resource.success(response.body()));
                        }else{
                            liveData.setValue(Resource.error(response.message(),null));
                        }
                    }

                    @Override
                    public void onFailure(Call<MainResponse> call, Throwable t) {
                        liveData.setValue(Resource.error(t.getLocalizedMessage(),null));

                    }
                });
        return liveData;
    }

    @Override
    public MutableLiveData<Resource<MainResponse>> getHealthNews() {
        liveData.setValue(Resource.loading());
        api.getHealthNews(API_KEY,"ru")
                .enqueue(new Callback<MainResponse>() {
                    @Override
                    public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                        if(response.isSuccessful() && response.body()!=null){
                            liveData.setValue(Resource.success(response.body()));
                        }else{
                            liveData.setValue(Resource.error(response.message(),null));
                        }
                    }

                    @Override
                    public void onFailure(Call<MainResponse> call, Throwable t) {
                        liveData.setValue(Resource.error(t.getLocalizedMessage(),null));

                    }
                });
        return liveData;
    }

    @Override
    public MutableLiveData<Resource<MainResponse>> getScienceNews() {
        liveData.setValue(Resource.loading());
        api.getScienceNews(API_KEY,"ru")
                .enqueue(new Callback<MainResponse>() {
                    @Override
                    public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                        if(response.isSuccessful() && response.body()!=null){
                            liveData.setValue(Resource.success(response.body()));
                        }else{
                            liveData.setValue(Resource.error(response.message(),null));
                        }
                    }

                    @Override
                    public void onFailure(Call<MainResponse> call, Throwable t) {
                        liveData.setValue(Resource.error(t.getLocalizedMessage(),null));

                    }
                });
        return liveData;
    }

    @Override
    public MutableLiveData<Resource<MainResponse>> getSportNews() {
        liveData.setValue(Resource.loading());
        api.getSportNews(API_KEY,"ru")
                .enqueue(new Callback<MainResponse>() {
                    @Override
                    public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                        if(response.isSuccessful() && response.body()!=null){
                            liveData.setValue(Resource.success(response.body()));
                        }else{
                            liveData.setValue(Resource.error(response.message(),null));
                        }
                    }

                    @Override
                    public void onFailure(Call<MainResponse> call, Throwable t) {
                        liveData.setValue(Resource.error(t.getLocalizedMessage(),null));

                    }
                });
        return liveData;
    }

    @Override
    public MutableLiveData<Resource<MainResponse>> getTechnologyNews() {
        liveData.setValue(Resource.loading());
        api.getTechnologyNews(API_KEY,"ru")
                .enqueue(new Callback<MainResponse>() {
                    @Override
                    public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                        if(response.isSuccessful() && response.body()!=null){
                            liveData.setValue(Resource.success(response.body()));
                        }else{
                            liveData.setValue(Resource.error(response.message(),null));
                        }
                    }

                    @Override
                    public void onFailure(Call<MainResponse> call, Throwable t) {
                        liveData.setValue(Resource.error(t.getLocalizedMessage(),null));

                    }
                });
        return liveData;
    }
}
