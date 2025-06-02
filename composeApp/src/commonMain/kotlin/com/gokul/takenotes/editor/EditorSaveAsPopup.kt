package com.gokul.takenotes.editor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gokul.takenotes.components.Popup

@Composable
fun EditorSaveAsPopup(
    modifier: Modifier,
    titleValue: String,
    onValueChange: (String) -> Unit,
    onClose: () -> Unit,
    onSave: () -> Unit
) {
    Popup(
        modifier = modifier,
        title = {
            Text(
                text = "Save As",
                fontWeight = FontWeight.Bold
            )
        },
        onClose = onClose
    ) {
        OutlinedTextField(
            value = titleValue,
            onValueChange = onValueChange,
            label = { Text("Enter Note Title") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colors.primary,
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = MaterialTheme.colors.primary,
                unfocusedLabelColor = Color.Gray
            ),
            singleLine = true,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 10.dp)
                .fillMaxWidth()
                .height(50.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = MaterialTheme.colors.onPrimary,
                    containerColor = MaterialTheme.colors.primary
                ),
                onClick = onSave
            ) {
                Text("Save")
            }
        }
    }
}