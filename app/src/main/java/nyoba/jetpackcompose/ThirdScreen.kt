package nyoba.jetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun thirdScreen(navControler: NavController,modifier: Modifier = Modifier) {
    Column {
        Text(text = "Ini third screen")
        buttonHomeScreen(navController = navControler)
    }

}

@Composable
fun buttonHomeScreen(navController: NavController,modifier: Modifier = Modifier) {
    Button(onClick = {
        navController.navigate("home")
    },
        modifier = modifier
            .size(100.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Gray
        ),
        shape = RectangleShape
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(Icons.Filled.Home, contentDescription = null, modifier.size(50.dp))
            Text(text = "Home")
        }
    }
}