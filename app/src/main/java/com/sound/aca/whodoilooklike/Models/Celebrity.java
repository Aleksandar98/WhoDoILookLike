package com.sound.aca.whodoilooklike.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "celebrities")
public class Celebrity implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    int id;
        @ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "noseRation")
    double noseRation;
    @ColumnInfo(name = "ratio36")
    double ratio36;
    @ColumnInfo(name = "ratio46")
    double ratio46;
    @ColumnInfo(name = "fOrM")
    public String fOrM;
    @Override
    public String toString() {
        return "Celebrity{" +
                "name='" + name + '\'' +
                ", noseRation=" + noseRation +
                ", ratio36=" + ratio36 +
                ", ratio46=" + ratio46 +
                ", fOrM=" + fOrM +
                '}';
    }

    public Celebrity(String name, double noseRation, double ratio36, double ratio46, String fOrM) {
        this.name = name;
        this.noseRation = noseRation;
        this.ratio36 = ratio36;
        this.ratio46 = ratio46;
        this.fOrM = fOrM;
    }

    @Ignore
    public Celebrity() {
    }

    protected Celebrity(Parcel in) {
        name = in.readString();
        noseRation = in.readDouble();
        ratio36 = in.readDouble();
        ratio46 = in.readDouble();
        fOrM = in.readString();
    }

    public static final Creator<Celebrity> CREATOR = new Creator<Celebrity>() {
        @Override
        public Celebrity createFromParcel(Parcel in) {
            return new Celebrity(in);
        }

        @Override
        public Celebrity[] newArray(int size) {
            return new Celebrity[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNoseRation() {
        return noseRation;
    }

    public void setNoseRation(double noseRation) {
        this.noseRation = noseRation;
    }

    public double getRatio36() {
        return ratio36;
    }

    public void setRatio36(double ratio36) {
        this.ratio36 = ratio36;
    }

    public double getRatio46() {
        return ratio46;
    }

    public void setRatio46(double ratio46) {
        this.ratio46 = ratio46;
    }

    public String getfOrM() {
        return fOrM;
    }

    public void setfOrM(String fOrM) {
        this.fOrM = fOrM;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(noseRation);
        dest.writeDouble(ratio36);
        dest.writeDouble(ratio46);
        dest.writeString(fOrM);
    }
}
