package com.example.registros.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.registros.database.AppDatabase
import com.example.registros.data.Medicion
import com.example.registros.data.MedicionDao
import kotlinx.coroutines.launch

// MedicionViewModel es una clase que extiende AndroidViewModel y se utiliza para la lógica de presentación relacionada con Mediciones.
class MedicionViewModel(application: Application) : AndroidViewModel(application) {

    // Se crea una instancia de la base de datos de la aplicación.
    private val db: AppDatabase = AppDatabase.getDatabase(application, viewModelScope)
    private val medicionDao: MedicionDao = db.medicionDao()

    // LiveData que almacena todas las Mediciones y se actualiza automáticamente cuando cambian.
    val todasLasMediciones: LiveData<List<Medicion>> = medicionDao.getAll()

    // Función para insertar una nueva Medición de manera asincrónica utilizando corrutinas.
    fun insertarMedicion(medicion: Medicion) = viewModelScope.launch {
        medicionDao.insert(medicion)
    }
}

