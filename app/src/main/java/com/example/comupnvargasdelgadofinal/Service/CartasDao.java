package com.example.comupnvargasdelgadofinal.Service;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.comupnvargasdelgadofinal.Entitis.Cartas;

import java.util.List;

@Dao
public interface CartasDao {
    @Query("SELECT * FROM cartas WHERE duelistaID = :duelistaID")
    List<Cartas> getDuelistaByDuelistaId(long duelistaID);


    @Insert
    long insertCartas(Cartas cartas);
}
