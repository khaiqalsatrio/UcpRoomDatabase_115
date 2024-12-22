package com.example.ucp2_115.ui.view.dosen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2_115.ui.costumwidget.TopAppBar
import com.example.ucp2_115.ui.navigation.AlamatNavigasi
import com.example.ucp2_115.ui.viewmodel.dosen.DosenEvent
import com.example.ucp2_115.ui.viewmodel.dosen.DosenUiState
import com.example.ucp2_115.ui.viewmodel.dosen.DosenViewModel
import com.example.ucp2_115.ui.viewmodel.dosen.FormErrorState
import com.example.ucp2_115.ui.viewmodel.dosen.PenyediaDosenViewModel
import kotlinx.coroutines.launch


object DestinasiDosenInsert : AlamatNavigasi {
    override val route = "insert_dsn"
}

@Composable
fun InsertDosenView(
    onBack: () -> Unit,
    onNavigate:()->Unit,
    modifier: Modifier = Modifier,
    viewModel: DosenViewModel = viewModel(factory = PenyediaDosenViewModel.Factory)
) {
    val uiState = viewModel.uiState
    val snackbarHostState = remember{ SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(uiState.snackBarMessage) {
        uiState.snackBarMessage?.let { message ->
            coroutineScope.launch {
                snackbarHostState.showSnackbar(message)
                viewModel.resetSnackBarMessage()
            }
        }
    }
    Scaffold (
        modifier=modifier,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ){padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ){
            TopAppBar(
                onBack = onBack,
                showBackButton = true,
                judul = "Tambah Dosen",
                modifier = Modifier
            )
            InsertBodyDosen(
                uiState = uiState,
                onValueChange = {updatedEvent->
                    viewModel.updateState(updatedEvent)
                },
                onClick = {
                    coroutineScope.launch {
                        viewModel.saveData()
                    }
                    onNavigate()
                }
            )
        }
    }
}

@Composable
fun InsertBodyDosen(
    modifier: Modifier = Modifier,
    onValueChange:(DosenEvent)->Unit,
    onClick:() -> Unit,
    uiState: DosenUiState
) {
    Column (
        modifier= modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FormDosen(
            dosenEvent = uiState.dosenEvent,
            onValueChange = onValueChange,
            error = uiState.isEntryvalid,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Simpan")
        }
    }
}

@Composable
fun FormDosen(
    dosenEvent: DosenEvent = DosenEvent(),
    onValueChange: (DosenEvent) -> Unit,
    error: FormErrorState = FormErrorState(),
    modifier: Modifier = Modifier
) {
    val jenisKelamin = listOf("Laki-Laki", "Perempuan")

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = dosenEvent.nama,
            onValueChange = {
                onValueChange(dosenEvent.copy(nama = it))
            },
            label = { Text("Nama") },
            isError = error.nama != null,
            placeholder = { Text("Masukkan Nama") },

            )
        Text(
            text = error.nama ?: "",
            color = Color.Red
        )
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = dosenEvent.nidn,
                onValueChange = {
                    onValueChange(dosenEvent.copy(nidn = it))
                },
                label = { Text("NIDN") },
                isError = error.nidn != null,
                placeholder = { Text("Masukkan NIDN") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

            )
            Text(
                text = error.nidn ?: "",
                color = Color.Red
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Jenis Kelamin")
            Row(
                modifier = Modifier.fillMaxWidth()

            ) {
                jenisKelamin.forEach { jk ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        RadioButton(
                            selected = dosenEvent.jeniskelamin == jk,
                            onClick = {
                                onValueChange(dosenEvent.copy(jeniskelamin = jk))
                            },
                        )
                        Text(
                            text = jk,
                        )
                    }
                }
            }
        }
    }
}