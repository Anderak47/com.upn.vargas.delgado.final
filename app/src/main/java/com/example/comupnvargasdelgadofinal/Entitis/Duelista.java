package com.example.comupnvargasdelgadofinal.Entitis;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "duelistas")
public class Duelista {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String nombre;

    @Ignore
    private List<Cartas> cartas;

    public Duelista(String nombre) {

        this.nombre = nombre;
        this.cartas = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cartas> getCartas() {
        return cartas;
    }

    public void setCartas(List<Cartas> cartas) {
        this.cartas = cartas;
    }
}
