package com.anatame.recylerview3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnAddOne;
    Menu menu;

    private MyApplication myApplication = (MyApplication) this.getApplication();
    private List<President> presidentList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presidentList = MyApplication.getPresidentList();

        Log.d("PresidentList", presidentList.toString());

        btnAddOne = findViewById(R.id.btn_addOne);
        recyclerView = findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecyclerViewAdapter(presidentList, this);
        recyclerView.setAdapter(mAdapter);

        btnAddOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,  AddEditOne.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_aToz:
                // sort a to z
                Collections.sort(presidentList, President.PresidentNameAZComparator);
                mAdapter.notifyDataSetChanged();
                return true;

            case R.id.menu_zToa:
                return true;

            case R.id.menu_dateAscending:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


}