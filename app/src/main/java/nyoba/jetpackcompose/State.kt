package nyoba.jetpackcompose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

class State (field: String, condition: Boolean){
    var inputField by mutableStateOf(field)
    var textField by  mutableStateOf(field)
    var showText by  mutableStateOf(condition)
    var buttonClick by  mutableStateOf(condition)
}

@Composable
fun stateRemember(field: String, condition: Boolean): State = remember {
    State(field, condition)
}