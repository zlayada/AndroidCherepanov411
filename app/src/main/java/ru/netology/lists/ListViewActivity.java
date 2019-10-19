package ru.netology.lists;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);

        List<Map<String, String>> values = prepareContent();

        BaseAdapter listContentAdapter = createAdapter(values);

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private BaseAdapter createAdapter(List<Map<String, String>> values) {
        return new SimpleAdapter(this, values,
                R.layout.activity_title,
                new String[]{"titleUp", "titleDown"},
                new int[]{R.id.textTitle, R.id.textTitleDown});
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {

        List<Map<String, String>> content = new ArrayList<>();
        String[] titles = getString(R.string.large_text).split("\n\n");

        for (String title : titles) {

            Map<String, String> item = new HashMap<>();

            item.put("titleUp", title);
            item.put("titleDown", Integer.toString(title.length()));

            content.add(item);
        }
        return content;
    }
}
