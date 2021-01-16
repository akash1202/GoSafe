package com.example.gosafe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.gosafe.model.Hospital;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MedicinesFragment extends Fragment {
    ImageView medicineThumbnail1, medicineThumbnail2, medicineThumbnail3, medicineThumbnail4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medeicines, container, false);
        medicineThumbnail1 = view.findViewById(R.id.medicineThumbNail1);
        medicineThumbnail2 = view.findViewById(R.id.medicineThumbNail2);
        medicineThumbnail3 = view.findViewById(R.id.medicineThumbNail3);
        medicineThumbnail4 = view.findViewById(R.id.medicineThumbNail4);
        Glide.with(this).load(getString(R.string.medicine1image))
                .centerCrop()
                .placeholder(R.drawable.logo)
                .into(medicineThumbnail1);
        Glide.with(this).load(getString(R.string.medicine2image))
                .circleCrop()
                .placeholder(R.drawable.logo)
                .into(medicineThumbnail2);
        Glide.with(this).load(getString(R.string.medicine3image))
                .circleCrop()
                .placeholder(R.drawable.logo)
                .into(medicineThumbnail3);
        Glide.with(this).load(getString(R.string.medicine4image))
                .circleCrop()
                .placeholder(R.drawable.logo)
                .into(medicineThumbnail4);
        return view;
    }
}
