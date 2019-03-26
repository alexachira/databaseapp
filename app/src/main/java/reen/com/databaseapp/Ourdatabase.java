package reen.com.databaseapp;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Account.class},version = 1)
public abstract class Ourdatabase extends RoomDatabase{
    public abstract Accountdao accountdao();

    //singleton
    private static Ourdatabase instance;
    public static Ourdatabase getInstance (Context context)
    {
        if (instance==null)
        {
            instance= Room.databaseBuilder(context,Ourdatabase.class,"bank_db").allowMainThreadQueries().build();
        }
        return instance;
    }


}
