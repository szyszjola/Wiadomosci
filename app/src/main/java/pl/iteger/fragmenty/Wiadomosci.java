package pl.iteger.fragmenty;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jolanta.szyszkiewicz on 2017.11.23.
 */

public class Wiadomosci implements Parcelable{

    long id;
    String tytul;
    String tresc;

    public Wiadomosci()
    {}

    protected Wiadomosci(Parcel in) {
        id = in.readLong();
        tytul = in.readString();
        tresc = in.readString();
    }

    public static final Creator<Wiadomosci> CREATOR = new Creator<Wiadomosci>() { //klasa anonimowa!
        @Override
        public Wiadomosci createFromParcel(Parcel in) {
            return new Wiadomosci(in);
        }

        @Override
        public Wiadomosci[] newArray(int size) {
            return new Wiadomosci[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(tytul);
        parcel.writeString(tresc);
    }
}

