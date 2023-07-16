package com.example.calofitv2.calofit.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.calofitv2.R
import com.example.calofitv2.calofit.navigation.AppScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun UserConfigurationScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color(0xFF97DF6D)
        ) {
            Image(painter = painterResource(R.drawable.inicioicon)
                , contentDescription = ""
                , modifier = Modifier
                    .clickable {
                        navController.navigate(route = AppScreen.Inicio.route)
                    }
                    .size(35.dp)
            )
            Text(text = "Configuracion",
                fontSize =25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(align = Alignment.Center)
            )
        }
    }) {
        UserConfigurationInterface();
    }
}

@Composable
fun UserConfigurationInterface(){
    Column() {
        Spacer(modifier = Modifier.padding(20.dp))
        switchDarkMode()
    }

}

@Composable
fun switchDarkMode(){
    var isChecked by remember { mutableStateOf(false) }
    Row(Modifier.fillMaxWidth()) {
        Text("Switch to DARK MODE", Modifier.padding(top = 10.dp))
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopEnd) {
            Switch(
                checked = isChecked,
                onCheckedChange = { isChecked = it }
            )
        }

    }
}