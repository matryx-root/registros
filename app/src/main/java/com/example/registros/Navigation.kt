

package com.example.registros


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.registros.ui.MedicionListScreen
import com.example.registros.ui.MedicionRegistroScreen
import com.example.registros.viewmodels.MedicionViewModel

// Anotación que indica que esta función es un Composable. Los Composables construyen la UI.
@Composable
fun Navigation() {
    // Crea y recuerda un NavController. Este controlador gestiona la navegación en la app.
    val navController = rememberNavController()

    // Obtiene o crea una instancia del MedicionViewModel para la lógica relacionada con mediciones.
    val medicionViewModel: MedicionViewModel = viewModel()

    // NavHost define un área en la UI que puede mostrar diferentes composables basados en la navegación.
    NavHost(navController = navController, startDestination = "medicionList") {

        // Define un destino de navegación con la ruta "medicionList".
        // Al seleccionar esta ruta, se muestra el composable MedicionListScreen.
        composable("medicionList") {
            MedicionListScreen(navController, medicionViewModel)
        }

        // Define otro destino de navegación con la ruta "medicionRegistro".
        // Muestra el composable MedicionRegistroScreen al seleccionar esta ruta.
        composable("medicionRegistro") {
            MedicionRegistroScreen(navController, medicionViewModel)
        }
    }
}
