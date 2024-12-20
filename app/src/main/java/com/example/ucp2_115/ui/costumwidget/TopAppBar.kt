package com.example.ucp2_115.ui.costumwidget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopAppBar(
    onBack: () -> Unit,
    showBackButton: Boolean = true,
    judul: String,
    modifier: Modifier = Modifier,
    backgroundColor:Color = Color.Gray,
    contentColor: Color = Color.Black,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(vertical = 16.dp, horizontal = 8.dp)
    ) {
        if (showBackButton) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(
                    onClick = onBack,
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = contentColor
                    ),
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = "Kembali",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }
        }

        // Centered title text
        Text(
            text = judul,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = contentColor,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

