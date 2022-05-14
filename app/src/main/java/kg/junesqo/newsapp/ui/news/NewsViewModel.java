package kg.junesqo.newsapp.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import kg.junesqo.newsapp.common.Resource;
import kg.junesqo.newsapp.data.model.MainResponse;
import kg.junesqo.newsapp.data.repositories.NewsRepositoriesImpl;
import kg.junesqo.newsapp.domain.repositories.NewsRepository;

@HiltViewModel
public class NewsViewModel extends ViewModel {

    private NewsRepositoriesImpl repositories;
    public LiveData<Resource<MainResponse>> liveData;

    @Inject
    public NewsViewModel(NewsRepositoriesImpl repositories) {
        this.repositories = repositories;
    }

    public void getTopNews(){
        liveData = repositories.getTopNews();
    }

    public void getBusinessNews() {
        liveData = repositories.getBusinessNews();
    }

    public void getEntertainmentNews() {
        liveData = repositories.getEntertainmentNews();
    }

    public void getHealthNews() {
        liveData = repositories.getHealthNews();
    }

    public void getGeneralNews() {
        liveData = repositories.getGeneralNews();
    }

    public void getScienceNews() {
        liveData = repositories.getScienceNews();
    }

    public void getSportNews() {
        liveData = repositories.getSportNews();
    }

    public void getTechnologyNews() {
        liveData = repositories.getTechnologyNews();
    }

}
