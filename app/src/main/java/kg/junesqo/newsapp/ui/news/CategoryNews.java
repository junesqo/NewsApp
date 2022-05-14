package kg.junesqo.newsapp.ui.news;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import kg.junesqo.newsapp.base.BaseFragment;
import kg.junesqo.newsapp.common.Resource;
import kg.junesqo.newsapp.data.model.MainResponse;
import kg.junesqo.newsapp.databinding.FragmentCategoryNewsBinding;
import kg.junesqo.newsapp.databinding.FragmentNewsBinding;

public class CategoryNews extends BaseFragment<FragmentCategoryNewsBinding> {

    private String category;
    private NewsAdapter adapter;
    private NewsViewModel viewModel;

    public CategoryNews(String category) {
        this.category = category;
    }

    @Override
    protected FragmentCategoryNewsBinding bind() {
        return FragmentCategoryNewsBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupViews() {
        viewModel = new ViewModelProvider(requireActivity()).get(NewsViewModel.class);
        adapter = new NewsAdapter();
        binding.recycler.setAdapter(adapter);
    }

    @Override
    protected void callRequests() {
        switch (category) {
            case "Top": {
                viewModel.getTopNews();
                break;
            }
            case "Business": {
                viewModel.getBusinessNews();
                break;
            }
            case "Entertainment": {
                viewModel.getEntertainmentNews();
                break;
            }
            case "Health": {
                viewModel.getHealthNews();
                break;
            }
            case "General": {
                viewModel.getGeneralNews();
                break;
            }
            case "Science": {
                viewModel.getScienceNews();
                break;
            }
            case "Sports": {
                viewModel.getSportNews();
                break;
            }
            case "Technology": {
                viewModel.getTechnologyNews();
                break;
            }
        }
//        viewModel.getTopNews();
    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected void setupObservers() {
        viewModel.liveData.observe(getViewLifecycleOwner(), new Observer<Resource<MainResponse>>() {
            @Override
            public void onChanged(Resource<MainResponse> resource) {
                switch (resource.status) {
                    case LOADING: {
                        //TODO: Add progress
                        break;
                    }
                    case SUCCESS: {
                        adapter.setNewsList(resource.data.getArticles());
                        break;
                    }
                    case ERROR: {
                        Snackbar.make(
                                binding.getRoot(), resource.msg, BaseTransientBottomBar.LENGTH_LONG
                        ).show();
                        break;
                    }
                }
            }
        });
    }
}
