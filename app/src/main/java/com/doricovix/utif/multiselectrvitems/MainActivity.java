package com.doricovix.utif.multiselectrvitems;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MAdapter mAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MAdapter(this, loadItems(), new MAdapter.ClickListener() {
            @Override
            public void onItemClick(Model itemModel, int position) {
                Toast.makeText(MainActivity.this, itemModel.getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(Model itemModel, int position) {
                /*if (selectedItems.get(getAdapterPosition(), false)){
                    selectedItems.delete(getAdapterPosition());
                    v.setSelected(false);
                }else {
                    selectedItems.put(getAdapterPosition(), true);
                    v.setSelected(true);
                }*/
            }
        });

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    private List<Model> loadItems() {
        List<Model> temp = new ArrayList<>();
        temp.add(new Model("Judul satu", "Deskripsi satu saja."));
        temp.add(new Model("Judul dua", "Deskripsi dua saja."));
        temp.add(new Model("Judul tiga", "Deskripsi tiga saja."));
        temp.add(new Model("Judul empat", "Deskripsi empat saja."));
        return temp;
    }
}
