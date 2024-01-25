package com.example.registros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.registros.ui.theme.RegistrosTheme

// La clase MainActivity extiende de ComponentActivity, que es una subclase de Activity.
// Esta clase actúa como el punto de entrada para la interfaz de usuario de la aplicación.
class MainActivity : ComponentActivity() {

    // onCreate es un método del ciclo de vida de la Activity. Se llama cuando se crea la Activity.
    override fun onCreate(savedInstanceState: Bundle?) {
        // Llamada al método onCreate de la clase base (ComponentActivity) para completar la creación de la Activity.
        super.onCreate(savedInstanceState)

        // setContent es un método de Jetpack Compose que define el contenido de la UI de esta Activity.
        setContent {
            // RegistrosTheme es un tema personalizado definido para esta aplicación.
            // Un tema en Compose define colores, tipografías y otros aspectos visuales.
            RegistrosTheme {
                // Navigation es una función que gestiona la navegación en la aplicación.
                // En este contexto, se utiliza para definir la estructura de navegación de la UI.
                Navigation()
            }
        }
    }
}
