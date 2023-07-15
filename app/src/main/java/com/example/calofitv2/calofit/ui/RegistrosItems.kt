package com.example.calofitv2.calofit.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.calofitv2.calofit.data.DataFit.PacienteEntity
import com.example.calofitv2.calofit.data.DataFit.PlatoEntity
import com.example.calofitv2.calofit.data.DataFit.RegistroEntity

@Composable
fun RegistrosItems(
    registro: RegistroEntity,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
    pacientes: List<PacienteEntity>,
    platos: List<PlatoEntity>,
    modifier: Modifier = Modifier
) {
    val paciente = pacientes.find { it.Id?.toLong() == registro.PacienteId }
    val plato = platos.find { it.Id?.toLong() == registro.PlatotId }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Green)) {
                    append("Paciente:")
                }
                append(" ${paciente?.Nombre}")
            }
        )
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Green)) {
                    append("Plato:")
                }
                append(" ${plato?.Nombre}")
            }
        )
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Green)) {
                    append("Fecha:")
                }
                append(" ${registro.Fecha}")
            }
        )
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Green)) {
                    append("Porciones:")
                }
                append(" ${registro.Porciones}")
            }
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onEdit) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                }
                IconButton(onClick = onDelete) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
                }
            }
        }
    }
}
