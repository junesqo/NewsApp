package kg.junesqo.newsapp.domain.repositories;

import androidx.lifecycle.MutableLiveData;

import kg.junesqo.newsapp.common.Resource;
import kg.junesqo.newsapp.data.model.MainResponse;

public interface NewsRepository {
    MutableLiveData<Resource<MainResponse>> getTopNews();
    MutableLiveData<Resource<MainResponse>> getBusinessNews();
    MutableLiveData<Resource<MainResponse>> getEntertainmentNews();
    MutableLiveData<Resource<MainResponse>> getGeneralNews();
    MutableLiveData<Resource<MainResponse>> getHealthNews();
    MutableLiveData<Resource<MainResponse>> getScienceNews();
    MutableLiveData<Resource<MainResponse>> getSportNews();
    MutableLiveData<Resource<MainResponse>> getTechnologyNews();
}
