package com.example.calofitv2.calofit.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calofitv2.R
import com.example.calofitv2.ui.theme.greencolor
import com.example.calofitv2.ui.theme.greentext


@Composable
fun LoginScreen(){

    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp),

    ){
        //Se crea el login y se centra los elementos
        LoginInterface(Modifier.align(Alignment.TopCenter))
    }
}

@Composable
fun LoginInterface(modifier: Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =Arrangement.Center,modifier = modifier) {
        Titulo1(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(5.dp))
        LogoImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(5.dp))
        Subtitulo1(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(5.dp))
        Subtitulo2(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(15.dp))
        EmailDoctor()

    }


}

@Composable
fun EmailDoctor() {
    val emailValue = remember { mutableStateOf("") }
    OutlinedTextField(
        value = emailValue.value,
        onValueChange = {emailValue.value=it},
        label = { Text(text = "Correo Electronico")},
        placeholder = { Text(text = "Correo Electronico")},
        singleLine =  true,
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 5.dp,
                brush = Brush.horizontalGradient(listOf(greencolor, greentext)),
                shape = RoundedCornerShape(10.dp)
            ),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            placeholderColor = Color.Black
        ),
        leadingIcon = {
            Icon(painter = painterResource(id = R.drawable.doctor),
                contentDescription = null,
                modifier = Modifier.padding(end=5.dp).size(100.dp,100.dp)
                )
        }
    )

}

@Composable
fun Subtitulo2(modifier: Modifier) {
    Text(
        text = "Ingrese su usuario y contraseña",
        fontSize = 20.sp,
        color = Color(0xFF6DE161)
    )

}

@Composable
fun Subtitulo1(modifier: Modifier) {
    Text(
        text = "BIENVENIDO",
        fontSize = 25.sp,
        color = Color(0xFF040303)
    )
}

@Composable
fun Titulo1(modifier: Modifier) {
    Text(
        text = "REGISTRO DE CALORIAS",
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF000000)
    )
}

@Composable
fun LogoImage(modifier: Modifier) {
    Image(painter = painterResource(R.drawable.logofinal ),
        contentDescription = null,
        modifier = modifier
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewLogin(){
    LoginScreen()
}