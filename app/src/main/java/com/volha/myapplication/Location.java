package com.volha.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable{
  private String street;
  private String city;
  private String state;
  private int postcode;

  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public int getPostcode() {
    return postcode;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.street);
    dest.writeString(this.city);
    dest.writeString(this.state);
    dest.writeInt(this.postcode);
  }

  public Location() {
  }

  protected Location(Parcel in) {
    this.street = in.readString();
    this.city = in.readString();
    this.state = in.readString();
    this.postcode = in.readInt();
  }

  public static final Creator<Location> CREATOR = new Creator<Location>() {
    @Override
    public Location createFromParcel(Parcel source) {
      return new Location(source);
    }

    @Override
    public Location[] newArray(int size) {
      return new Location[size];
    }
  };
}
