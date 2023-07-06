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
    private long puntoAtaque;
    private long puntoDefensa;
    private String imagen;
    private Double latitud;
    private Double longitud;

    public Cartas(long duelistaId, String nombre, long puntoAtaque, long puntoDefensa) {
        this.duelistaId = duelistaId;
        Nombre = nombre;
        this.puntoAtaque = puntoAtaque;
        this.puntoDefensa = puntoDefensa;
    }

    public Cartas() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDuelistaId() {
        return duelistaId;
    }

    public void setDuelistaId(long duelistaId) {
        this.duelistaId = duelistaId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public long getPuntoAtaque() {
        return puntoAtaque;
    }

    public void setPuntoAtaque(long puntoAtaque) {
        this.puntoAtaque = puntoAtaque;
    }

    public long getPuntoDefensa() {
        return puntoDefensa;
    }

    public void setPuntoDefensa(long puntoDefensa) {
        this.puntoDefensa = puntoDefensa;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}
