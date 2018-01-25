package com.volha.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

  private RetrofitService service;
  private CustomAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    RecyclerView rv = findViewById(R.id.rv);
    adapter = new CustomAdapter();
    GridLayoutManager manager = new GridLayoutManager(this, 2);
    rv.setAdapter(adapter);
    rv.setLayoutManager(manager);

    Retrofit retrofit = new Retrofit.Builder()
      .baseUrl("https://randomuser.me/")
      .addConverterFactory(GsonConverterFactory.create())
      .build();

    service = retrofit.create(RetrofitService.class);
    pullData();

  }


  private void pullData() {

    Call<Response> response = service.getPeople();
    response.enqueue(new Callback<Response>() {
      @Override
      public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
        List<Person> people = response.body().getResults();
        adapter.setData(people);
        adapter.notifyDataSetChanged();
      }

      @Override
      public void onFailure(Call<Response> call, Throwable t) {

      }
    });

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main_menu, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.refresh:
        pullData();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

}
