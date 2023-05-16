package com.example.calofitv2.calofit.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.calofitv2.R
import com.example.calofitv2.calofit.navigation.AppScreen
import com.example.calofitv2.ui.theme.greencolor
import com.example.calofitv2.ui.theme.greentext


@Composable
fun LoginScreen(navController: NavController){

    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp),

    ){
        //Se crea el login y se centra los elementos
        LoginInterface(Modifier.align(Alignment.TopCenter),navController)
    }
}

@Composable
fun LoginInterface(modifier: Modifier, navController: NavController) {

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
        Spacer(modifier = Modifier.padding(8.dp))
        ContrasenaDoctor()
        Spacer(modifier = Modifier.padding(16.dp))
        BtnIniciarSesion(navController)
    }


}

@Composable
fun BtnIniciarSesion(navController: NavController) {
    Button(onClick = {
                    navController.navigate(route = AppScreen.Inicio.route)
    },
       // enabled = emailValue.length > 2,
        modifier = Modifier
            .fillMaxWidth(50.8f)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF6DE161),
            disabledBackgroundColor = Color.Gray,
            contentColor = Color.White,
            disabledContentColor = Color.White,
        ),
        shape = RoundedCornerShape(50)
    ) {
        Text(text = "Iniciar Sesion", fontSize = 20.sp)
    }
}

@Composable
fun ContrasenaDoctor() {
    val passwordValue = remember { mutableStateOf("")}
    val passwordVisibility  = remember { mutableStateOf(false)}
    OutlinedTextField(
        value = passwordValue.value,
        onValueChange = {passwordValue.value=it},
        label = { Text(text = "Contraseña")},
        placeholder = { Text(text = "Contraseña")},
        singleLine =  true,
        modifier = Modifier
            .fillMaxWidth()
            ,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            placeholderColor = Color.Black,
            focusedLabelColor = Color.Black
        ),
        leadingIcon = {
            Icon(painter = painterResource(id = R.drawable.candado),
                contentDescription = null,
                modifier = Modifier.padding(end=2.dp).size(25.dp,25.dp)
            )
        },
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility.value =!passwordVisibility.value
            }) {
                Icon(painterResource(id = R.drawable.contrasenaojo) , contentDescription ="",
                    tint = if(passwordVisibility.value){
                        Color.Red
                    }else{
                        Color.Gray
                    }
                )
            }
        },
        visualTransformation = if(passwordVisibility.value){
            VisualTransformation.None
        }else{
            PasswordVisualTransformation()
        }

    )

}

@Composable
fun EmailDoctor() {
    val emailValue = remember { mutableStateOf("") }
    OutlinedTextField(
        value = emailValue.value,
        onValueChange = {emailValue.value=it},
        label = { Text(text = "Usuario")},
        placeholder = { Text(text = "Usuario")},
        singleLine =  true,
        modifier = Modifier
            .fillMaxWidth()
            ,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            placeholderColor = Color.Black,
            focusedLabelColor = Color.Black
        ),
        leadingIcon = {
            Icon(painter = painterResource(id = R.drawable.doctor),
                contentDescription = null,
                modifier = Modifier.padding(end=2.dp).size(25.dp,25.dp)
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

