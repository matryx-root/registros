package com.example.registros.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.registros.data.Medicion
import com.example.registros.viewmodels.MedicionViewModel

// Anotación para suprimir una advertencia relacionada con Scaffold
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MedicionRegistroScreen(navController: NavController, viewModel: MedicionViewModel) {
    // Estado de la UI para los campos de medidor, fecha y tipo
    var medidor by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("agua") } // Valor por defecto: "agua"

    // Scaffold es un componente de Material3 que proporciona la estructura básica de la pantalla
    Scaffold {
        Column(modifier = Modifier.padding(16.dp)) {
            // TextField para el medidor
            TextField(
                value = medidor,
                onValueChange = { medidor = it },
                label = { Text("Medidor") },
                modifier = Modifier.fillMaxWidth()
            )
            // TextField para la fecha
            TextField(
                value = fecha,
                onValueChange = { fecha = it },
                label = { Text("Fecha") },
                modifier = Modifier.fillMaxWidth()
            )
            // RadioButtons para seleccionar el tipo (agua, luz, gas)
            Row(modifier = Modifier.fillMaxWidth()) {
                RadioButton(selected = tipo == "agua", onClick = { tipo = "agua" })
                Text("Agua")
                RadioButton(selected = tipo == "luz", onClick = { tipo = "luz" })
                Text("Luz")
                RadioButton(selected = tipo == "gas", onClick = { tipo = "gas" })
                Text("Gas")
            }
            // Botón para registrar la medición
            Button(
                onClick = {
                    // Crear una nueva instancia de Medicion con los valores ingresados
                    val nuevaMedicion = Medicion(tipo = tipo, valor = medidor.toDouble(), fecha = fecha)
                    // Llamar al método insertarMedicion del viewModel para agregar la medición a la base de datos
                    viewModel.insertarMedicion(nuevaMedicion)
                    // Navegar de vuelta a la lista de mediciones
                    navController.navigate("medicionList")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Registrar medición")
            }
        }
    }
}
