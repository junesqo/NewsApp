package kg.junesqo.newsapp.domain.repositories;

import androidx.lifecycle.MutableLiveData;

import kg.junesqo.newsapp.common.Resource;
import kg.junesqo.newsapp.data.model.MainResponse;

public interface NewsRepository {
    MutableLiveData<Resource<MainResponse>> getTopNews();
}
