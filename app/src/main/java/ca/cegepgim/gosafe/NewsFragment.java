package ca.cegepgim.gosafe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ca.cegepgim.gosafe.R;

import ca.cegepgim.gosafe.model.News;

import java.util.ArrayList;

public class NewsFragment extends Fragment {

    ArrayList<News> sliderItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        VerticalViewPager verticalViewPager = view.findViewById(R.id.verticalViewPager);
        //https://www.cbc.ca/news/canada/vaccine-rollout-provinces-1.5831787
        sliderItems.add(new News("https://www.who.int/images/default-source/health-topics/coronavirus/gettyimages-1203376093.tmb-.png?Culture=en&sfvrsn=6e0c1bc7_13", "Provinces discuss rollout plans, preach patience ahead of COVID-19 vaccine arrival", getString(R.string.news1), getString(R.string.newslink1)));
        //https://www.ctvnews.ca/health/coronavirus/canada-has-twice-as-many-active-covid-19-cases-as-it-did-on-nov-1-1.5209320
        sliderItems.add(new News("https://www.ctvnews.ca/polopoly_fs/1.5209323.1606671401!/httpImage/image.jpg_gen/derivatives/landscape_960/image.jpg", "Canada has twice as many active COVID-19 cases as it did on Nov.1 ", getString(R.string.news2), getString(R.string.newslink2)));
        //https://www.bbc.com/news/world-us-canada-54405736
        sliderItems.add(new News("https://ichef.bbci.co.uk/news/976/cpsprodpb/11F56/production/_114785537_gettyimages-51424453.jpg", "Coronavirus: The place in North America with no cases", getString(R.string.news3), getString(R.string.newslink3)));
        verticalViewPager.setAdapter(new ViewPagerAdapter(view.getContext(), sliderItems));
    }


    public void loadNews() {

    }

}
