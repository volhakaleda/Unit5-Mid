package com.volha.myapplication;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class CustomViewHolder extends RecyclerView.ViewHolder {

  private TextView first;
  private TextView last;
  private ImageView image;

  public CustomViewHolder(View itemView) {
    super(itemView);

    first = itemView.findViewById(R.id.first);
    last = itemView.findViewById(R.id.last);
    image = itemView.findViewById(R.id.image);
  }

  public void bind(final Person person) {
    first.setText(person.getName().getFirst());
    last.setText(person.getName().getLast());
    Picasso.with(itemView.getContext()).load(person.getPicture().getThumbnail()).into(image);

    itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
        intent.putExtra("person", person);
        itemView.getContext().startActivity(intent);
      }
    });

  }

}
