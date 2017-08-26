package com.doricovix.utif.multiselectrvitems;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
            public void onItemLongClick(View v, Model itemModel, int position, SparseBooleanArray selectedItems) {
                if (selectedItems.get(position, false)){
                    selectedItems.delete(position);
                    v.setSelected(false);
                }else {
                    selectedItems.put(position, true);
                    v.setSelected(true);
                }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_more, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_remove:
                Toast.makeText(MainActivity.this, "More clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
