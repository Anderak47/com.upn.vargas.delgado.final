package com.example.comupnvargasdelgadofinal.Entitis;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "cartas", foreignKeys = @ForeignKey(entity = Duelista.class, parentColumns = "id", childColumns = "duelistaId", onDelete = ForeignKey.CASCADE))
public class Cartas {
    @PrimaryKey(autoGenerate = true)
    public long id;
    private long duelistaId;
    public String Nombre;
    private int puntoAtaque;
    private int puntoDefensa;
    private String imagen;
    private String latitud;
    private String longitud;

    public Cartas(long id, String nombre, int puntoAtaque, int puntoDefensa, String imagen, String latitud, String longitud) {
        this.id = id;
        Nombre = nombre;
        this.puntoAtaque = puntoAtaque;
        this.puntoDefensa = puntoDefensa;
        this.imagen = imagen;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Cartas(String nombre, int puntoAtaque, int puntoDefensa, String imagen, String latitud, String longitud) {
        Nombre = nombre;
        this.puntoAtaque = puntoAtaque;
        this.puntoDefensa = puntoDefensa;
        this.imagen = imagen;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getPuntoAtaque() {
        return puntoAtaque;
    }

    public void setPuntoAtaque(int puntoAtaque) {
        this.puntoAtaque = puntoAtaque;
    }

    public int getPuntoDefensa() {
        return puntoDefensa;
    }

    public void setPuntoDefensa(int puntoDefensa) {
        this.puntoDefensa = puntoDefensa;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
