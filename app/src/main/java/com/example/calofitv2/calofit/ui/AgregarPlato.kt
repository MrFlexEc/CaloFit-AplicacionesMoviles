import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.calofitv2.R
import com.example.calofitv2.calofit.navigation.AppScreen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AgregarPlatoScreen(navController: NavController){
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
            Text(text = "Agregar Platos",
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

        Box(
            Modifier
                .fillMaxSize()
                .padding(8.dp),
        ){
            //Se crea el login y se centra los elementos
            AgregarPlatoInterface(Modifier.align(Alignment.TopCenter))
        }

    }
}

@Composable
fun AgregarPlatoInterface(modifier: Modifier){

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =Arrangement.Center,modifier = modifier) {

        Spacer(modifier = Modifier.padding(10.dp))
        AgregarImagen()
        Spacer(modifier = Modifier.padding(15.dp))
        NombrePlato()
        //AgregarImagen()
        Spacer(modifier = Modifier.padding(15.dp))
        DescripcionPlato()
        //BtnSleccionImagen()
        Spacer(modifier = Modifier.padding(15.dp))
        CaloriasPlato()
        Spacer(modifier = Modifier.padding(25.dp))
        btnGuardar()


    }
}
@Composable
fun btnGuardar() {
    Button(
        onClick = {  },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF97DF6D)
        ),
        shape = RoundedCornerShape(25),
        modifier = Modifier.height(40.dp).width(200.dp)

    ) {
        Text(
            text = "Guardar",
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
                .wrapContentSize(align = Alignment.Center),
            textAlign = TextAlign.Start,
            // modifier = Modifier.padding(start = 10.dp)
            //.wrapContentSize(align = Alignment.CenterStart)
        )
    }
}

@Composable
fun NombrePlato() {
    var nombrePlato by remember { mutableStateOf("") }
    OutlinedTextField(
        value = nombrePlato,
        onValueChange = {nombrePlato=it},
        label = { Text(text = "Nombre")},
        placeholder = { Text(text = "Nombre")},
        singleLine =  true,
        modifier = Modifier
            .fillMaxWidth()
        ,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFFECEDC1),
            placeholderColor = Color.Black,
            focusedLabelColor = Color.Black
        ))
}

@Composable
fun CaloriasPlato() {
    var caloriasPlato by remember { mutableStateOf("") }
    OutlinedTextField(
        value = caloriasPlato,
        onValueChange = {caloriasPlato=it},
        label = { Text(text = "Calorias")},
        placeholder = { Text(text = "Calorias")},
        singleLine =  true,
        modifier = Modifier
            .fillMaxWidth()
        ,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFFECEDC1),
            placeholderColor = Color.Black,
            focusedLabelColor = Color.Black
        ))
}
@Composable
fun DescripcionPlato(){
    var descripcionPlato by remember { mutableStateOf("") }
    OutlinedTextField(
        value = descripcionPlato,
        onValueChange = {descripcionPlato=it},
        label = { Text(text = "Descripción")},
        placeholder = { Text(text = "Descripción")},
        singleLine =  true,
        modifier = Modifier
            .fillMaxWidth()
        ,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFFECEDC1),
            placeholderColor = Color.Black,
            focusedLabelColor = Color.Black
        ))
}



@Composable
fun BtnSleccionImagen() {
    Button(
        onClick = {  },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF97DF6D)
        ),
        shape = RoundedCornerShape(25),
        modifier = Modifier
            .height(40.dp)
            .width(220.dp)

    ) {
        Text(
            text = "SELECCIONAR IMAGEN",
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.Center),
            //textAlign = TextAlign.Start,
            // modifier = Modifier.padding(start = 10.dp)
            //.wrapContentSize(align = Alignment.CenterStart)
        )


    }
}

@Composable
fun AgregarImagen() {
    Image(painter = painterResource(R.drawable.logofinal)
        , contentDescription =""
        ,modifier = Modifier
            .size(150.dp)
    )
}

/*
@Preview(showBackground = true, showSystemUi = true)
//@Preview(showBackground = true)
@Composable
fun PreviewInicio(){
     AgregarPlatoScreen()
}*/