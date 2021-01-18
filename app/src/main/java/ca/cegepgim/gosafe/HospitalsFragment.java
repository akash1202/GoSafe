package ca.cegepgim.gosafe;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import ca.cegepgim.gosafe.R;

import ca.cegepgim.gosafe.model.Hospital;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import timber.log.Timber;

public class HospitalsFragment extends Fragment {

    ArrayList<Hospital> hospitals = new ArrayList<>();
    HospitalsAdapter hospitalsAdapter;
    RecyclerView recyclerView;
    View view;
    String url = "https://services1.arcgis.com/B6yKvIZqzuOr0jBR/arcgis/rest/services/COVID19_Testing_Centres_in_Canada/FeatureServer/0/query?where=1%3D1&outFields=OBJECTID,USER_Name,USER_Link,USER_Street,USER_City,USER_Prov,USER_PostalCode,USER_Phone,USER_Notes,Field,GlobalID,CreationDate,Creator,EditDate,Editor&outSR=4326&f=json";
    ProgressDialog process;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_hospitals, container, false);
        retrieveHospitals(url, view);
        return view;
    }

    public void retrieveHospitals(String url, View view) {
        process = new ProgressDialog(getActivity());
        process.setMessage("Wait...");
        process.setCancelable(false);
        process.show();
        RequestQueue rq = Volley.newRequestQueue(getActivity());
        StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //loader.hide();
                /*if(process.isShowing())*/
                process.cancel();
                Log.d("response:", response);

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    Timber.d("response:", jsonObject.toString());
                    JSONArray features = jsonObject.getJSONArray("features");
                    for (int i = 0; i < features.length(); i++) {
                        Hospital hospital = new Hospital();
                        JSONObject feature = (JSONObject) features.get(i);
                        JSONObject geometry = feature.getJSONObject("geometry");
                        JSONObject attributes = feature.getJSONObject("attributes");
                        hospital.setName(attributes.getString("USER_Name"));  //hospital's name
                        hospital.setLink(attributes.getString("USER_Link"));
                        hospital.setStreet(attributes.getString("USER_Street"));
                        hospital.setCity(attributes.getString("USER_City"));
                        hospital.setProvince(attributes.getString("USER_Prov"));
                        hospital.setPhone(attributes.getString("USER_Phone"));
                        hospital.setLatitude(geometry.getDouble("y"));
                        hospital.setLongitude(geometry.getDouble("x"));
                        hospitals.add(hospital);
                    }
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView = getActivity().findViewById(R.id.hospitalsList);
                    hospitalsAdapter = new HospitalsAdapter(getActivity(), hospitals);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(hospitalsAdapter);
                    hospitalsAdapter.notifyDataSetChanged();
                    // Log.d("response:", str.toString());

                    Log.e("response", response);
                    //Toast.makeText(getActivity(), "" +response, Toast.LENGTH_SHORT).show();
                    if (!TextUtils.isEmpty(response)) {


                    }
                } catch (JSONException ex) {
                    process.cancel();
                    Toast.makeText(getActivity(), "Json parsing Exception!" + ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                process.cancel();
                Toast.makeText(getActivity(), "Something gone Wrong!!", Toast.LENGTH_SHORT).show();
            }
        });
        rq.add(sr);
    }


}
