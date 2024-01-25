package com.example.registros.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Anotación Entity indica que esta clase es una entidad de la base de datos Room
@Entity(tableName = "mediciones")
data class Medicion(
    // Anotación PrimaryKey indica que el campo 'id' es la clave primaria
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    // ColumnInfo especifica el nombre de la columna en la base de datos para 'tipo'
    @ColumnInfo(name = "tipo") val tipo: String,
    // ColumnInfo especifica el nombre de la columna en la base de datos para 'valor'
    @ColumnInfo(name = "valor") val valor: Double,
    // ColumnInfo especifica el nombre de la columna en la base de datos para 'fecha'
    @ColumnInfo(name = "fecha") val fecha: String
)
