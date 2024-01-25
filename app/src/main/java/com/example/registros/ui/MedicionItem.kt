package com.example.registros.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.registros.data.Medicion


// MedicionItem es una función composable que muestra los detalles de una Medición en una tarjeta.
@Composable
fun MedicionItem(medicion: Medicion) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = "Tipo: ${medicion.tipo}") // Muestra el tipo de medición.
            Spacer(modifier = Modifier.width(8.dp)) // Agrega un espacio horizontal.
            Text(text = "Valor: ${medicion.valor}") // Muestra el valor de la medición.
            Spacer(modifier = Modifier.width(8.dp)) // Agrega otro espacio horizontal.
            Text(text = "Fecha: ${medicion.fecha}") // Muestra la fecha de la medición.
        }
    }
}

