package com.volha.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private Name name;
    private Location location;
    private String email;
    private String dob;
    private String cell;
    private Picture picture;

  public Name getName() {
    return name;
  }

  public Location getLocation() {
    return location;
  }

  public String getEmail() {
    return email;
  }

  public String getDob() {
    return dob;
  }

  public String getCell() {
    return cell;
  }

  public Picture getPicture() {
    return picture;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeParcelable(this.name, flags);
    dest.writeParcelable(this.location, flags);
    dest.writeString(this.email);
    dest.writeString(this.dob);
    dest.writeString(this.cell);
    dest.writeParcelable(this.picture, flags);
  }

  public User() {
  }

  protected User(Parcel in) {
    this.name = in.readParcelable(Name.class.getClassLoader());
    this.location = in.readParcelable(Location.class.getClassLoader());
    this.email = in.readString();
    this.dob = in.readString();
    this.cell = in.readString();
    this.picture = in.readParcelable(Picture.class.getClassLoader());
  }

  public static final Creator<User> CREATOR = new Creator<User>() {
    @Override
    public User createFromParcel(Parcel source) {
      return new User(source);
    }

    @Override
    public User[] newArray(int size) {
      return new User[size];
    }
  };
}
