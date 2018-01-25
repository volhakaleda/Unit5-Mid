package com.volha.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    ImageView imageView = findViewById(R.id.image);
    TextView name = findViewById(R.id.name);
    TextView email = findViewById(R.id.email);
    TextView phone = findViewById(R.id.phone);
    TextView address1 = findViewById(R.id.address_one);
    TextView address2 = findViewById(R.id.address_two);
    TextView dob = findViewById(R.id.dob);

    Person person = getIntent().getParcelableExtra("person");
    Picasso.with(this).load(person.getPicture().getLarge()).into(imageView);

    name.setText(person.getName().getFirst() + " " + person.getName().getLast());
    email.setText(person.getEmail());
    phone.setText(person.getCell());
    address1.setText(person.getLocation().getStreet());
    address2.setText(person.getLocation().getCity() + ", " + person.getLocation().getState() + ", " + person.getLocation().getPostcode());
    dob.setText(person.getDob());


  }
}
