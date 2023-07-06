package com.example.comupnvargasdelgadofinal.Service;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.comupnvargasdelgadofinal.Entitis.Duelista;

import java.util.List;

@Dao
public interface DuelistaDao {
    @Query("SELECT * FROM duelistas")
    List<Duelista> getAllDuelista();

    @Insert
    long insertDuelista(Duelista duelista);
}
