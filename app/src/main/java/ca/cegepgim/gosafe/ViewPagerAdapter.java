package ca.cegepgim.gosafe;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import ca.cegepgim.gosafe.R;

import ca.cegepgim.gosafe.model.News;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {
    ArrayList<News> sliderItems;
    LayoutInflater layoutInflater;
    Context context;

    public ViewPagerAdapter(Context context, ArrayList<News> sliderItems) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.sliderItems = sliderItems;
    }

    @Override
    public int getCount() {
        return sliderItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.item_news, container, false);
        ImageView thumbNail = itemView.findViewById(R.id.thumbNail);
        TextView title = itemView.findViewById(R.id.newsTitle);
        TextView newsSummary = itemView.findViewById(R.id.newsSummary);
        TextView newsLink = itemView.findViewById(R.id.newsLink);
        newsLink.setMovementMethod(LinkMovementMethod.getInstance());
        final int pos = position;
        newsLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moreInfo = new Intent(Intent.ACTION_VIEW, Uri.parse(sliderItems.get(pos).getLink()));
                moreInfo.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(moreInfo);
            }
        });
        thumbNail.setImageResource(R.drawable.news);
        title.setText(sliderItems.get(position).getTitle());
        newsSummary.setText(sliderItems.get(position).getDescription());
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
        //super.destroyItem(container, position, object);
    }
}
