package com.example.easypython;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter< Articles> {
    int listLayout;
    List<Articles> articleList;
    Context context;

    public ListViewAdapter(Context context, int listLayout , int field, List<Articles> articleList) {

        super(context, listLayout, field, articleList);
        this.context = context;
        this.listLayout=listLayout;
        this.articleList = articleList;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listViewItem = inflater.inflate(listLayout, null, false);
        TextView title = listViewItem.findViewById(R.id.textViewTitle);
        TextView preview = listViewItem.findViewById(R.id.textViewPreView);
        TextView date = listViewItem.findViewById(R.id.textViewDate);



            title.setText(articleList.get(position).getTitle());
            preview.setText(articleList.get(position).getPreview());
            date.setText(articleList.get(position).getDate());


        return listViewItem;

    }

}

