package com.example.calofitv2.calofit.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import com.example.calofitv2.R
import com.example.calofitv2.calofit.navigation.AppScreen

@Composable
fun SplashScreen(navController: NavHostController){

    LaunchedEffect(key1 = true ){
        delay(5000)
        navController.popBackStack()
        navController.navigate(AppScreen.Login.route)
    }
    Splash()
}

@Composable
fun Splash(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(R.drawable.logofinal) ,
            contentDescription ="logo",
            Modifier.size(380.dp,380.dp))

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SplashScreenPreview(){
    //SplashScreen()
    Splash()
}