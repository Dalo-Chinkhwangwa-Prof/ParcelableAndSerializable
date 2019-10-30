package com.example.myhomeworksolution;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class HumanJava implements Parcelable {
    private String name;
    private String hairColor;

    public HumanJava(String name, String hairColor) {
        this.name = name;
        this.hairColor = hairColor;
    }

    protected HumanJava(Parcel in) {
        name = in.readString();
        hairColor = in.readString();
    }

    public static final Creator<HumanJava> CREATOR = new Creator<HumanJava>() {
        @Override
        public HumanJava createFromParcel(Parcel in) {
            return new HumanJava(in);
        }

        @Override
        public HumanJava[] newArray(int size) {
            return new HumanJava[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(hairColor);
    }
}
