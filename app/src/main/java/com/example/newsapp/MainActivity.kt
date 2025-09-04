package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.ui.theme.NewsAppTheme
import com.example.newsapp.ui.theme.NewsColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    var taskText by remember {
        mutableStateOf("")
    }
    val noticias = listOf(
        Noticia("El presidente de EE.UU. no muestra signos de arrepentimiento...", "febrero 08 - 2024", R.drawable.ada),
        Noticia("Bañarse en la piscina del desierto de Cleopatra", "febrero 10 - 2024", R.drawable.kat),
        Noticia("Mamesco logra remontar BoxFights reñidas contra MetrooMax", "septiembre 09 - 2025", R.drawable.mamesco),
        Noticia("La historia REAL de la silueta del hombre", "febrero 17 - 2025", R.drawable.silueta),
        Noticia("Mi vieja", "marzo 21 - 2025", R.drawable.maria),
        Noticia("La MUJER que hablaba con la IA porque no tenía AMIGOS...", "junio 28 - 2024", R.drawable.aleph),
        Noticia("Moi no hizo su tabla de 3x5 y prefirió apostar en CalienteMX", "diciembre 29 - 2023", R.drawable.moi),
        Noticia("Saquen sus crayonsitos y vamos a hacer una analogía del modelo OSI en una maqueta...", "mayo 13 - 2025", R.drawable.perro),
        Noticia("Que le pasaaaaaa", "agosto 18 - 2024", R.drawable.dexter)
    )
    Column {
        // Barra de búsqueda
        Row (
            modifier = Modifier
                .padding(
                    start = 30.dp,
                    top = 30.dp,
                    end = 30.dp
                )
        ) {
            OutlinedTextField(
                value = taskText,
                onValueChange = {
                    taskText = it
                },
                placeholder = {
                    Text(
                        text = "Buscar",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "search"
                    )
                },
                modifier = Modifier
                    .weight(5f),
                shape = RoundedCornerShape(24.dp),
                singleLine = true
            )
        }
        // Secciones
        Row (
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Noticias",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 26.sp
                )
                Box(
                    modifier = Modifier
                        .height(5.dp)
                        .width(45.dp)
                        .background(NewsColor)
                )
            }
            Text(
                text = "Eventos",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 26.sp,
                color = Color.LightGray
            )
            Text(
                text = "Clima",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 26.sp,
                color = Color.LightGray
            )
        }
        // Texto de últimas noticias
        Text(
            modifier = Modifier
                .padding(10.dp),
            text = "Ultimas noticias",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 26.sp
        )
        LazyRow (
            modifier = Modifier
                .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(noticias) { noticia ->
                Card(
                    modifier = Modifier
                        .width(300.dp)
                        .height(200.dp),
                    colors = CardDefaults.cardColors(containerColor = NewsColor),
                    shape = RoundedCornerShape(30.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column {
                        Text(
                            modifier = Modifier.padding(
                                start = 15.dp,
                                top = 50.dp,
                                end = 12.dp,
                                bottom = 10.dp
                            )
                                .weight(2f),
                            text = noticia.descripcion,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp, end = 12.dp)
                                .padding(bottom = 10.dp),
                            text = noticia.fecha,
                            fontSize = 16.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
        // Texto de alrededor del mundo
        Text(
            modifier = Modifier
                .padding(10.dp),
            text = "Alrededor del mundo",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 26.sp
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(noticias){ noticia ->

                Box (
                    modifier = Modifier
                        .padding(10.dp)
                        .height(300.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                ){
                    Image(
                        painter = painterResource(id = noticia.imagen),
                        contentDescription = "Ada",
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Box (
                        modifier = Modifier
                            .wrapContentSize()
                            .fillMaxWidth()
                            .align(Alignment.BottomStart)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.Gray)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(10.dp),
                            text = noticia.descripcion,
                        )
                    }
                }
            }
        }

    }

}


@Preview(showBackground = true)
@Composable
fun NewsAppPreview() {
    NewsAppTheme {
        HomeScreen()
    }
}