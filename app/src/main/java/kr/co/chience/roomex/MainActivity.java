package kr.co.chience.roomex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    static FragmentManager fragmentManager;
    static PersonDatabase personDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        personDatabase = Room
                .databaseBuilder(getApplicationContext(), PersonDatabase.class, "mydb")
                .allowMainThreadQueries()
                .build();

        if (findViewById(R.id.Container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            fragmentManager.beginTransaction()
                    .add(R.id.Container, new HomeFragment(), null)
                    .commit();
        }
    }
}
