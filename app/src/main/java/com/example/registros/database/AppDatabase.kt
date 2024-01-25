package com.example.registros.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.registros.data.Medicion
import com.example.registros.data.MedicionDao
import kotlinx.coroutines.CoroutineScope

// Anotación para indicar que esta clase es una base de datos Room
@Database(entities = [Medicion::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    // Función abstracta que devuelve un objeto MedicionDao para interactuar con la base de datos
    abstract fun medicionDao(): MedicionDao

    companion object {
        @Volatile
        var INSTANCE: AppDatabase? = null

        // Método para obtener una instancia de la base de datos
        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "servicios3_database"
                )
                    // Considera usar una estrategia de migración en lugar de fallbackToDestructiveMigration()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

