package kg.junesqo.newsapp.ui.news;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;
import kg.junesqo.newsapp.base.BaseFragment;
import kg.junesqo.newsapp.common.Resource;
import kg.junesqo.newsapp.data.model.MainResponse;
import kg.junesqo.newsapp.databinding.FragmentNewsBinding;
import kg.junesqo.newsapp.ui.categories.Tabs;
import kg.junesqo.newsapp.ui.categories.ViewPagerAdapter;

@AndroidEntryPoint
public class NewsFragment extends BaseFragment<FragmentNewsBinding> {

    private ViewPagerAdapter tabAdapter;
    private ArrayList<Tabs> fragments;

    private NewsViewModel viewModel;




    @Override
    protected FragmentNewsBinding bind() {
        return FragmentNewsBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupViews() {
        viewModel = new ViewModelProvider(requireActivity()).get(NewsViewModel.class);
    }

    @Override
    protected void callRequests() {
        viewModel.getTopNews();
    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected void setupObservers() {

        fragments = new ArrayList<>();
        fragments.add(new Tabs(new CategoryNews("Top"),"Top"));
        fragments.add(new Tabs(new CategoryNews("Business"),"Business"));
        fragments.add(new Tabs(new CategoryNews("Entertainment"),"Entertainment"));
        fragments.add(new Tabs(new CategoryNews("Health"),"Health"));
        fragments.add(new Tabs(new CategoryNews("General"),"General"));
        fragments.add(new Tabs(new CategoryNews("Science"),"Science"));
        fragments.add(new Tabs(new CategoryNews("Sports"),"Sports"));
        fragments.add(new Tabs(new CategoryNews("Technology"),"Technology"));

        tabAdapter = new ViewPagerAdapter(this);
        tabAdapter.setFragments(fragments);
        binding.viewPager.setAdapter(tabAdapter);
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(fragments.get(position).getNews());
            }
        }).attach();
    }
}
