package com.example.automated_greenhouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class notification extends AppCompatActivity implements ListingAdapter.ItemClicked{

    private RecyclerView.Adapter<ListingAdapter.ViewHolder> myAdapter;
    private ArrayList<Listing> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        initXML();
        addItems();
    }

    private void initXML() {
        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        items = new ArrayList<>();

        myAdapter = new ListingAdapter(this, items);

        recyclerView.setAdapter(myAdapter);
    }

    private void addItems() {
        items.add(new Listing(R.drawable.rose,
                "20-21°C(Cloudy) 24-28°C(Sunny)",
                "sandy loam soils",
                "50-70%",
                "6.0-7",
                "Rose"));

        items.add(new Listing(R.drawable.papaya,
                "16 ° C - 25 to 30 ° C",
                "well-drained or sandy loam soil",
                "60 to 85%",
                "6-6.5",
                "Papaya"));
        items.add(new Listing(R.drawable.strawberry,
                "18-25°C(Day) 10-12°C (Night)",
                "dry sandy soil",
                "60-80%",
                "5.5-7",
                "Strawberry"));

        items.add(new Listing(R.drawable.cabbage,
                "25-30°C",
                "Well-drained, fertile, sandy loam",
                "95-98%",
                "6.5-7.5",
                "Cabbage"));

        items.add(new Listing(R.drawable.capsicum,
                "25-30°C(Day) 18-20°C(Night)",
                "well-drained sandy loam soil",
                "50-60%",
                "6 to 7",
                "Capsicum"));

        items.add(new Listing(R.drawable.chili,
                "22-26°C",
                "loam soil",
                "70%",
                "6.0 to 6.8",
                "Chili"));

        items.add(new Listing(R.drawable.okra,
                "23-32°C",
                "Well Drained , Sandy soil",
                "65%-75%",
                "6.5 to 7.5",
                "Okra"));

        items.add(new Listing(R.drawable.onion,
                "20-25°C",
                "well-drained sandy loam soil",
                "70%",
                "6.0 to 6.8",
                "Onion"));

        items.add(new Listing(R.drawable.tomato,
                "21-24°C",
                "well-drained fertile loam soil",
                "80% - 90%",
                "6.0 to 6.5",
                "Tomato"));

        items.add(new Listing(R.drawable.carnation,
                "20-25°C",
                "well-drained fertile soil",
                "80% - 85%",
                "6.0 to 7",
                "Carnation"));

        items.add(new Listing(R.drawable.gerbera,
                "22-25°C(Day) 12-16°C(Night)",
                "well-drained soil",
                "70% - 75%",
                "5.5 to 7",
                "Gerbera"));

        items.add(new Listing(R.drawable.orchid,
                "10-27°C",
                "Normal plotting soil",
                "40% - 70%",
                "5.5 to 6",
                "Orchid"));
        items.add(new Listing(R.drawable.cauli,
                "20-26°C",
                "Deep loamy soil",
                "95%",
                "5.5 - 6.6",
                "Cauliflower"));


        items.add(new Listing(R.drawable.coriander,
                "20-25°C",
                "well drained soil",
                "60-70%",
                "6.2 - 6.8",
                "Coriander"));
        items.add(new Listing(R.drawable.radish,
                "18-29°C",
                "light ,sandy loam",
                "75-80% ",
                "6.5 - 7",
                "Radish"));
        items.add(new Listing(R.drawable.spinach,
                "15-22°C",
                "Well drained soil",
                "80-85%",
                "5.8 - 6.0",
                "Spinach"));
        items.add(new Listing(R.drawable.marigold,
                "18-20°C",
                "Any soil",
                "60-70%",
                "7.0 - 7.5",
                "Marigold"));
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClicked(int index) {

    }


}