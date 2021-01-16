package com.example.gosafe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class ProfileFragment extends Fragment {
    Button logoutButton;
    SharedPreferences sharedPreferences;
    private String PREFRENCENAME = "GOSAFE";
    SharedPreferences.Editor editor;
    TextView userEmailText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        logoutButton = view.findViewById(R.id.logoutButton);
        userEmailText = view.findViewById(R.id.userEmail);
        sharedPreferences = this.getContext().getSharedPreferences(PREFRENCENAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        String userEmail = sharedPreferences.getString("userEmail", "Justin Trudeau");
        userEmailText.setText(userEmail);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getActivity(), "Logged out Successfully!!!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();
            }
        });
        return view;
    }
}