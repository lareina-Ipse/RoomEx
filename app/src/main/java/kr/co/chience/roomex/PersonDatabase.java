package kr.co.chience.roomex;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class}, version = 2)
public abstract class PersonDatabase extends RoomDatabase {

    public abstract PersonDao personDao();

}
