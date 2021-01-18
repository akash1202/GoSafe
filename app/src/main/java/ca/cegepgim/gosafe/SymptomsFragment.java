package ca.cegepgim.gosafe;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ca.cegepgim.gosafe.R;

public class SymptomsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_symptoms, container, false);
    }

    static void sendFeedbackEmail(Context context) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO,
                Uri.fromParts("mailto", "anaghanakash1202@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                context.getString(R.string.email_title,
                        context.getString(R.string.app_version)));
        emailIntent.putExtra(Intent.EXTRA_TEXT,
                context.getString(R.string.email_body));
        context.startActivity(Intent.createChooser(emailIntent,
                context.getString(R.string.send_feedback)));
    }
}
