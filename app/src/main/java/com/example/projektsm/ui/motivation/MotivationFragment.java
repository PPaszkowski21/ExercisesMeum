package com.example.projektsm.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.projektsm.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MotivationFragment extends Fragment {

    private Button GetMotivationFromApi;
    private RequestQueue mQueue;
    private String JSON_URL = "https://localhost:44345/home/read";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_motivation, container, false);
        GetMotivationFromApi = root.findViewById(R.id.requestButton);
        GetMotivationFromApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadQuoteFromApi();
            }
        });
        return root;
    }

    private void LoadQuoteFromApi(){



        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, JSON_URL,
                null, new Response.Listener<JSONArray>()
        {
            @Override
            public void onResponse(JSONArray jsonArray)
            {
                dishArrayList.clear();
                for(int i =0; i < jsonArray.length(); i++)
                {
                    try
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Dish dish = new Dish();
                        dish.setId(jsonObject.getInt("Id"));
                        dish.setTitle(jsonObject.getString("Title"));
                        dish.setDescription1(jsonObject.getString("Description1"));
                        dish.setDescription2(jsonObject.getString("Description2"));
                        dish.setDescription3(jsonObject.getString("Description3"));
                        dish.setDescription4(jsonObject.getString("Description4"));
                        dish.setImageURL(jsonObject.getString("ImageURL"));
                        dishArrayList.add(dish);
                    }
                    catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                }
//                progressDialog.dismiss();
            }
        },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        error.printStackTrace(); Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        mQueue.add(request);
    }
}