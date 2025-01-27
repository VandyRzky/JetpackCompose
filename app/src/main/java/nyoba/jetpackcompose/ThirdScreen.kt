package nyoba.jetpackcompose


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import nyoba.jetpackcompose.api.adapter.ProductViewModel
import nyoba.jetpackcompose.api.model.Product
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun thirdScreen(navControler: NavController,modifier: Modifier = Modifier) {
    Column (
        modifier
        .fillMaxSize()
    ){
        buttonHomeScreen(navController = navControler)
        productScreen()
    }

}@Composable
fun productScreen(viewModel: ProductViewModel = viewModel()) {
    val products = viewModel.products.value
    val isLoading = viewModel.isLoading.value
    val errorMessage = viewModel.errorMassage.value

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            errorMessage.isNotEmpty() -> {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            else -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(products) { product ->
                        productItem(product)
                    }
                }
            }
        }
    }
}

@Composable
fun productItem(product: Product,modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = product.title)
            Text(text = product.description)
            Text(text = "Price: $${product.price}")
            Text(text = "Stock: ${product.stock}")
        }
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