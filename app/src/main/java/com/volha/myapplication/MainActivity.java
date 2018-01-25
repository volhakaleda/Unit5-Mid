package com.volha.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    RecyclerView rv = findViewById(R.id.rv);
    CustomAdapter adapter = new CustomAdapter();
    GridLayoutManager manager = new GridLayoutManager(this, 2);
    rv.setAdapter(adapter);
    rv.setLayoutManager(manager);


  }
}
