package pl.iteger.fragmenty.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jolanta.szyszkiewicz on 2017.12.15.
 */

public class DataBase extends SQLiteOpenHelper {


    public static final String CREATE_NEWS_TABLE = "create table news(_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "tytul TEXT, tresc TEXT)";
    private static final String NASZA_DB_DB = "BAZA_WIADOMOSCI";
    private static final String KOLUMNA_TYTUL = "tytul";
    private static final String KOLUMNA_TRESC = "tresc";
    public static final int VERSION = 1;

    public DataBase(Context context) {
        super(context, NASZA_DB_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(CREATE_NEWS_TABLE);
    }

    private void insertRow(SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KOLUMNA_TYTUL, "Przykladowy tytul");
        contentValues.put(KOLUMNA_TRESC, "PRzykladowe cialo wiadomosci");
        sqLiteDatabase.insert(NASZA_DB_DB, null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
