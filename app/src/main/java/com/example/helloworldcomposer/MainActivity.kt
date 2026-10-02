package com.example.helloworldcomposer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloworldcomposer.ui.theme.HelloWorldComposerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldComposerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaFilas(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PantallaFilas(modifier: Modifier = Modifier) {
    val estadoDesplazamiento = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(estadoDesplazamiento)
            .padding(16.dp)
    ) {
        Text(text = "Fila basica", style = MaterialTheme.typography.titleMedium)
        FilaBasica()

        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "horizontalArrangement", style = MaterialTheme.typography.titleMedium)
        FilaConArrangement(Arrangement.Start, "Start")
        FilaConArrangement(Arrangement.SpaceBetween, "SpaceBetween")
        FilaConArrangement(Arrangement.spacedBy(12.dp), "SpacedBy(12.dp)")

        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "verticalAlignment", style = MaterialTheme.typography.titleMedium)
        FilaConAlineacion(Alignment.Top, "Top")
        FilaConAlineacion(Alignment.CenterVertically, "CenterVertically")
        FilaConAlineacion(Alignment.Bottom, "Bottom")

        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Modifier.weight", style = MaterialTheme.typography.titleMedium)
        FilaConPesos()

        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Fila desplazable (horizontalScroll)", style = MaterialTheme.typography.titleMedium)
        FilaDesplazable()

        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Tarjeta con fila anidada", style = MaterialTheme.typography.titleMedium)
        TarjetaConFilaAnidada()
    }
}

@Composable
fun FilaBasica() {
    Row(modifier = Modifier.padding(16.dp)) {
        Text(text = "Elemento 1")
        Text(text = "Elemento 2")
        Text(text = "Elemento 3")
    }
}

@Composable
fun FilaConArrangement(arrangement: Arrangement.Horizontal, etiqueta: String) {
    Column(modifier = Modifier.padding(bottom = 8.dp)) {
        Text(text = etiqueta)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceVariant),
            horizontalArrangement = arrangement
        ) {
            repeat(3) {
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(width = 60.dp, height = 40.dp)
                        .background(MaterialTheme.colorScheme.primary)
                )
            }
        }
    }
}

@Composable
fun FilaConAlineacion(alineacion: Alignment.Vertical, etiqueta: String) {
    Column(modifier = Modifier.padding(bottom = 8.dp)) {
        Text(text = etiqueta)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(MaterialTheme.colorScheme.surfaceVariant),
            verticalAlignment = alineacion
        ) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(width = 40.dp, height = 24.dp)
                    .background(MaterialTheme.colorScheme.primary)
            )
        }
    }
}

@Composable
fun FilaConPesos() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(80.dp)
                .background(Color(0xFF1B4F9C))
        )
        Box(
            modifier = Modifier
                .weight(2f)
                .height(80.dp)
                .background(Color(0xFFD6E2F5))
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .height(80.dp)
                .background(Color(0xFFF4F6F8))
        )
    }
}

@Composable
fun FilaDesplazable() {
    val estado = rememberScrollState()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(estado)
            .padding(vertical = 8.dp)
    ) {
        for (indice in 1..15) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .size(width = 80.dp, height = 80.dp)
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = "$indice",
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun TarjetaConFilaAnidada() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = "Miguel Angel Guerrero", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(MaterialTheme.colorScheme.primary)
            )
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(MaterialTheme.colorScheme.secondary)
            )
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(MaterialTheme.colorScheme.tertiary)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaFilasPreview() {
    HelloWorldComposerTheme {
        PantallaFilas()
    }
}