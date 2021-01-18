package ca.cegepgim.gosafe;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ca.cegepgim.gosafe.R;

import ca.cegepgim.gosafe.model.Hospital;

import java.util.ArrayList;
import java.util.Locale;

public class HospitalsAdapter extends RecyclerView.Adapter<HospitalsAdapter.ViewHolder> {

    Context context;
    ArrayList<Hospital> hospitals;

    public HospitalsAdapter(Context context, ArrayList<Hospital> hospitals) {
        this.context = context;
        this.hospitals = hospitals;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hospital, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final int pos = position;
        final Double latitude = hospitals.get(pos).getLatitude();
        final Double longitude = hospitals.get(pos).getLongitude();
        final String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);
        holder.hospitalName.setText(hospitals.get(position).getName());
        holder.hospitalPhone.setText(hospitals.get(position).getPhone());
        holder.hospitalCity.setText(hospitals.get(position).getCity());
        holder.hospitalStreet.setText(hospitals.get(position).getStreet());
        if (hospitals.get(position).getLink() != null) {
            holder.hospitalLink.setVisibility(View.VISIBLE);
            holder.hospitalLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(hospitals.get(position).getLink()));
                    context.startActivity(intent);
                }
            });
        }
        Log.d("location:", position + "/" + hospitals.size() + " " + hospitals.get(position).getLatitude() + "" + hospitals.get(position).getLongitude());
        if (longitude != null && latitude != null) {
            holder.hospitalLocation.setVisibility(View.VISIBLE);
            holder.hospitalLocation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String uriGoogleMap = "http://maps.google.com/maps?saddr=" + latitude + "," + longitude;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return hospitals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView hospitalName, hospitalPhone, hospitalCity, hospitalStreet;
        ImageButton hospitalLink, hospitalLocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hospitalName = itemView.findViewById(R.id.hospitalName);
            hospitalLink = itemView.findViewById(R.id.hospitalLink);
            hospitalPhone = itemView.findViewById(R.id.hospitalPhone);
            hospitalCity = itemView.findViewById(R.id.hospitalCity);
            hospitalStreet = itemView.findViewById(R.id.hospitalStreet);
            hospitalLocation = itemView.findViewById(R.id.hospitalLocation);
        }
    }
}
