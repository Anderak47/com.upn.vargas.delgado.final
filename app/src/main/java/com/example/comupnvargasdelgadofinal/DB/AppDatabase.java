package com.example.comupnvargasdelgadofinal.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.comupnvargasdelgadofinal.Entitis.Cartas;
import com.example.comupnvargasdelgadofinal.Entitis.Duelista;
import com.example.comupnvargasdelgadofinal.Service.CartasDao;
import com.example.comupnvargasdelgadofinal.Service.DuelistaDao;

@Database(entities = {Duelista.class, Cartas.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract CartasDao cartasDao();
    public abstract DuelistaDao duelistaDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
