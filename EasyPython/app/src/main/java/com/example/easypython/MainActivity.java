package com.example.easypython;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<Articles> articles;
    private static String JSON_URL = "http://easypython.site/api/article/";
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_img);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        articles = new ArrayList<>();
        extractArticle();

    }

    private void extractArticle() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject articleObject = response.getJSONObject(i);
                        Articles post = new Articles();
                        post.setTitle(articleObject.getString("title").toString());
                        post.setPreview(articleObject.getString("preview".toString()));
                        post.setFull_text(articleObject.getString("full_text"));
                        post.setDate(articleObject.getString("date"));
                        articles.add(post);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                ListAdapter adapter = new ListViewAdapter(getApplicationContext(),R.layout.row,R.id.textViewTitle,articles);
                listView.setAdapter(adapter);


               // Log.d("NewsChannel", "Важная новость: сообщение для отладки! " + articles.size() + " "+ articles.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse: " + error.getMessage());
            }
        });

        queue.add(jsonArrayRequest);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String full_text = articles.get(position).getFull_text();
                //Toast.makeText(getApplicationContext(), full_text, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                intent.putExtra("full_text",full_text);
                startActivity(intent);
            }
        });
    }

}
