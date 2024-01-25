package com.example.registros.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.registros.viewmodels.MedicionViewModel


// MedicionListScreen es una función composable que muestra una lista de mediciones.
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MedicionListScreen(navController: NavController, viewModel: MedicionViewModel) {
    val mediciones = viewModel.todasLasMediciones.observeAsState(listOf())

    // Scaffold es un componente de Material Design que proporciona una estructura básica para la pantalla.
    Scaffold(
        floatingActionButton = {
            // FloatingActionButton es un botón flotante que permite agregar nuevas mediciones.
            FloatingActionButton(onClick = { navController.navigate("medicionRegistro") }) {
                Icon(Icons.Filled.Add, contentDescription = "Agregar Medicion")
            }
        }
    ) {
        // LazyColumn es un componente de Compose para mostrar listas grandes de elementos de manera eficiente.
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(mediciones.value) { medicion ->
                // Para cada elemento en la lista de mediciones, se muestra utilizando el composable MedicionItem.
                MedicionItem(medicion)
            }
        }
    }
}
