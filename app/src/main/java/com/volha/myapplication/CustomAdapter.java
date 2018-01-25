package com.volha.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

  private List<User> people = new ArrayList<>();

  @Override
  public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    return new CustomViewHolder(inflater.inflate(R.layout.view_holder_layout, parent, false));
  }

  @Override
  public void onBindViewHolder(CustomViewHolder holder, int position) {
    User person = people.get(position);
    holder.bind(person);

  }

  @Override
  public int getItemCount() {
    return people.size();
  }

  public void setData(List<User> people) {
    this.people = people;
  }

}

