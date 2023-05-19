package com.circlemove.sample.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.circlemove.sample.theme.CoDarkBlue
import com.circlemove.sample.theme.CoGray
import com.circlemove.sample.theme.CoOceanBlue

@Composable
fun CustomTextFields(
    value: String,
    readOnly: Boolean,
    onEditClick: () -> Unit,
) {
    TextField(
        value = value,
        onValueChange = {},
        readOnly = readOnly,
        trailingIcon = {
            IconButton(onClick = onEditClick) {
                Icon(
                    Icons.Default.Edit,
                    contentDescription = null
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = CoOceanBlue,
            unfocusedBorderColor = CoGray
        ),
        textStyle = TextStyle.Default.copy(
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = CoDarkBlue
        )
    )
}