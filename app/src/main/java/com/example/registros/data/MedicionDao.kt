package com.example.registros.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.registros.data.Medicion

// Anotación Dao indica que esta interfaz representa un Data Access Object para Room
@Dao
interface MedicionDao {
    // Consulta que devuelve una lista LiveData de todas las mediciones en la tabla 'mediciones'
    @Query("SELECT * FROM mediciones")
    fun getAll(): LiveData<List<Medicion>>

    // Método de inserción que agrega una nueva 'Medicion' a la base de datos
    @Insert
    suspend fun insert(medicion: Medicion)
}
