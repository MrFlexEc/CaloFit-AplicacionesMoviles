package com.example.calofitv2.calofit.ui

import com.example.calofitv2.calofit.data.DataFit.PlatoEntity


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

@Composable
fun PlatosItems(
    plato: PlatoEntity,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Green)) {
                    append("Nombre:")
                }
                append(" ${plato.Nombre}")
            }
        )
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Green)) {
                    append("Descripcion:")
                }
                append(" ${plato.Descripcion}")
            }
        )
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Green)) {
                    append("Calorias:")
                }
                append(" ${plato.Calorias}")
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


