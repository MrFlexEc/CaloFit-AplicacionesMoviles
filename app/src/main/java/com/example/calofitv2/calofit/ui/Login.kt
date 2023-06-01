package com.example.calofitv2.calofit.ui

import android.util.Log
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.calofitv2.R
import com.example.calofitv2.calofit.ViewModels.LoginViewModel
import com.example.calofitv2.calofit.navigation.AppScreen
import com.example.calofitv2.ui.theme.greencolor
import com.example.calofitv2.ui.theme.greentext
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


private val auth by lazy {
    Firebase.auth
}
@Composable
fun LoginScreen(navController: NavController, auth: FirebaseAuth, viewModel: LoginViewModel){

    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp),

        ){
        //Se crea el login y se centra los elementos
        LoginInterface(Modifier.align(Alignment.TopCenter),navController, auth,viewModel)
    }
}

@Composable
fun LoginInterface(modifier: Modifier, navController: NavController, auth: FirebaseAuth, viewModel: LoginViewModel) {

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =Arrangement.Center,modifier = modifier) {
        Titulo1Login(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(5.dp))
        LogoImageLogin(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(5.dp))
        Subtitulo1Login(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(5.dp))
        Subtitulo2Login(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(15.dp))
        DatosInicioSesion(viewModel,navController)
        //EmailDoctor()

        //ContrasenaDoctor()

        //BtnIniciarSesion()
    }


}

@Composable
fun DatosInicioSesion( viewModel: LoginViewModel, navController: NavController) {
    val state =viewModel.state
    //val passwordValue = remember { mutableStateOf("")}
    val passwordVisibility  = remember { mutableStateOf(false)}
    //val emailValue = remember { mutableStateOf("") }
    val isEmailValid by derivedStateOf {
        Patterns.EMAIL_ADDRESS.matcher(state.email).matches()
    }
    val isPasswordValid by derivedStateOf {

        state.password.length>5
    }
    OutlinedTextField(
        value = state.email,
        onValueChange = {viewModel.ObtenerEmail(it)},
        label = { Text(text = "Usuario")},
        placeholder = { Text(text = "Usuario")},
        singleLine =  true,
        modifier = Modifier
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        )
        ,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            placeholderColor = Color.Black,
            focusedLabelColor = Color.Black
        ),

        isError = !isEmailValid,

        leadingIcon = {
            Icon(painter = painterResource(id = R.drawable.doctor),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 2.dp)
                    .size(25.dp, 25.dp)
            )
        }
    )

    Spacer(modifier = Modifier.padding(8.dp))

    OutlinedTextField(
        value = state.password,
        onValueChange = {viewModel.ObtenerPassword(it)},
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
                modifier = Modifier
                    .padding(end = 2.dp)
                    .size(25.dp, 25.dp)
            )
        },
        isError = !isPasswordValid,
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

    Spacer(modifier = Modifier.padding(16.dp))

    Button(onClick = {viewModel.Login(navController, auth)

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
fun BtnIniciarSesion() {
}

@Composable
fun ContrasenaDoctor() {

}

@Composable
fun EmailDoctor() {
}

@Composable
fun Subtitulo2Login(modifier: Modifier) {
    Text(
        text = "Ingrese su usuario y contraseña",
        fontSize = 20.sp,
        color = Color(0xFF6DE161)
    )

}

@Composable
fun Subtitulo1Login(modifier: Modifier) {
    Text(
        text = "BIENVENIDO",
        fontSize = 25.sp,
        color = Color(0xFF040303)
    )
}

@Composable
fun Titulo1Login(modifier: Modifier) {
    Text(
        text = "REGISTRO DE CALORIAS",
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF000000)
    )
}

@Composable
fun LogoImageLogin(modifier: Modifier) {
    Image(painter = painterResource(R.drawable.logofinal ),
        contentDescription = null,
        modifier = modifier
    )
}

