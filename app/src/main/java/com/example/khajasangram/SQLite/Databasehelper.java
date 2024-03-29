package com.example.khajasangram.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.khajasangram.Classes.Restaurant_SQLite;

import java.util.ArrayList;

public class Databasehelper extends SQLiteOpenHelper {
    static String name = "NearbyRestaurants";

    static int version = 1;

    String create2kmtable = "CREATE TABLE if not exists `twokmtable` (\n" +
            "\t`id`\tTEXT,\n" +
            "\t`name`\tTEXT,\n" +
            "\t`address`\tTEXT,\n" +
            "\t`contact`\tTEXT,\n" +
            "\t`latitude`\tTEXT,\n" +
            "\t`longitude`\tTEXT,\n" +
            "\t`distance`\tTEXT\n" +
            ")";

    String createplacetable = "CREATE TABLE if not exists`place_table` ( `id` TEXT, `name` TEXT, `address` TEXT, `distance` TEXT, `contact` TEXT, `latitude` TEXT, `longitude` TEXT )";

    public Databasehelper(Context context) {
        super(context, name, null, version);

        getWritableDatabase().execSQL(create2kmtable);
        getWritableDatabase().execSQL(createplacetable);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void populate_2kmtable(ContentValues cv)
    {
        getWritableDatabase().insert("twokmtable","",cv);
    }
    public void drop_twokmtable()
    {
        String delete = "drop table `twokmtable`";
        getWritableDatabase().execSQL(delete);
    }

    public ArrayList<Restaurant_SQLite> twokmrestaurant_list()
    {
        String query = "select distinct * from twokmtable order by distance";
        Cursor c = getReadableDatabase().rawQuery(query,null);

        ArrayList<Restaurant_SQLite> list = new ArrayList<>();

        while(c.moveToNext())
        {
            Restaurant_SQLite restaurant_sqLite = new Restaurant_SQLite();
            restaurant_sqLite.id = c.getString(c.getColumnIndex("id"));
            restaurant_sqLite.name = c.getString(c.getColumnIndex("name"));
            restaurant_sqLite.address = c.getString(c.getColumnIndex("contact"));
            restaurant_sqLite.contact = c.getString(c.getColumnIndex("address"));
            restaurant_sqLite.latitude = c.getString(c.getColumnIndex("latitude"));
            restaurant_sqLite.longitude = c.getString(c.getColumnIndex("longitude"));
            restaurant_sqLite.distance = c.getString(c.getColumnIndex("distance"));

            list.add(restaurant_sqLite);
        }
        c.close();
        return list;

    }
    public ArrayList<Restaurant_SQLite> twokmrestaurant_list(int distance)
    {
        String query = "select distinct * from twokmtable where distance < "+distance+" order by distance";
        Cursor c = getReadableDatabase().rawQuery(query,null);

        ArrayList<Restaurant_SQLite> list = new ArrayList<>();

        while(c.moveToNext())
        {
            Restaurant_SQLite restaurant_sqLite = new Restaurant_SQLite();
            restaurant_sqLite.id = c.getString(c.getColumnIndex("id"));
            restaurant_sqLite.name = c.getString(c.getColumnIndex("name"));
            restaurant_sqLite.address = c.getString(c.getColumnIndex("contact"));
            restaurant_sqLite.contact = c.getString(c.getColumnIndex("address"));
            restaurant_sqLite.latitude = c.getString(c.getColumnIndex("latitude"));
            restaurant_sqLite.longitude = c.getString(c.getColumnIndex("longitude"));
            restaurant_sqLite.distance = c.getString(c.getColumnIndex("distance"));

            list.add(restaurant_sqLite);
        }
        c.close();
        return list;

    }
    public ArrayList<Restaurant_SQLite> twokmrestaurant_list(String place)
    {
        String query = "select distinct * from twokmtable where address ="+"'"+place+"'"+ "order by distance";
        Cursor c = getReadableDatabase().rawQuery(query,null);

        ArrayList<Restaurant_SQLite> list = new ArrayList<>();

        while(c.moveToNext())
        {
            Restaurant_SQLite restaurant_sqLite = new Restaurant_SQLite();
            restaurant_sqLite.id = c.getString(c.getColumnIndex("id"));
            restaurant_sqLite.name = c.getString(c.getColumnIndex("name"));
            restaurant_sqLite.address = c.getString(c.getColumnIndex("contact"));
            restaurant_sqLite.contact = c.getString(c.getColumnIndex("address"));
            restaurant_sqLite.latitude = c.getString(c.getColumnIndex("latitude"));
            restaurant_sqLite.longitude = c.getString(c.getColumnIndex("longitude"));
            restaurant_sqLite.distance = c.getString(c.getColumnIndex("distance"));

            list.add(restaurant_sqLite);
        }
        c.close();
        return list;

    }
}
