@file:OptIn(ExperimentalMaterial3Api::class)

package nyoba.jetpackcompose

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import nyoba.jetpackcompose.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            scaffoldSample()
        }
    }
}

@Composable
fun userChat(modifier: Modifier = Modifier){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)){
        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.gambar1),
                contentDescription = null,
                modifier = Modifier
                    .padding(2.dp)
                    .size(50.dp)
                    .border(2.dp, Color.Blue, CircleShape)
                    .clip(CircleShape))
            Spacer(modifier = Modifier
                .size(4.dp))
            Column(modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()) {
                Text(text = "ini nama", fontWeight = FontWeight.Bold)
                Text(text = "Ini pesan text", modifier = Modifier.offset(5.dp))
            }

        }
        Icon(Icons.Filled.Check, contentDescription = null, modifier = Modifier
            .align(Alignment.BottomEnd)
            .size(18.dp))
    }
}


@Composable
fun userProfile(modifier: Modifier = Modifier) {
    Row (modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
        ){
        Box(modifier = Modifier){
            Image(painter = painterResource(id = R.drawable.gambar1),
                contentDescription = "ini gambar",
                modifier = Modifier.size(50.dp)
            )
            Icon(Icons.Filled.Check,
                contentDescription = null,
                modifier = Modifier
                    .size(10.dp)
                    .align(Alignment.BottomEnd)
            )
        }
        Column {
            Text(text = "ini nama")
            Text(text = "nama@nama")
        }
    }
}

fun checkInternetConnection(context: Context) {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivityManager.activeNetwork
    val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)

    if (networkCapabilities != null) {
        when {
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                Log.e("InternetStatus", "Internet tersedia melalui Wi-Fi")
            }
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                Log.e("InternetStatus", "Internet tersedia melalui data seluler")
            }
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                Log.e("InternetStatus", "Internet tersedia melalui Ethernet")
            }
            else -> {
                Log.e("InternetStatus", "Internet tidak tersedia")
            }
        }
    } else {
        Log.e("InternetStatus", "Tidak ada koneksi internet")
    }
}

@Composable
fun iniButton(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Button(
        onClick = {
            checkInternetConnection(context)
        val intent = Intent(context, SecondActivity::class.java)
        context.startActivity(intent)
    },
        contentPadding = PaddingValues(12.dp),
        colors = ButtonColors(Purple40, Color.Gray, Color.Blue, Color.Red)
    ) {
        Row (verticalAlignment = Alignment.CenterVertically){
            Icon(Icons.Filled.Build, contentDescription = null, modifier = Modifier
                .size(15.dp))
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = "ini button text")
        }
    }
}

@Composable
fun countFunction(modifier: Modifier = Modifier) { //menggunakan state hosting
    var count by remember {
        mutableStateOf(0)
    }
    countButton(count = count, pengubah = {count++})
}

@Composable
fun countButton(count: Int, pengubah: () -> Unit) {

    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
        ){
        Text(text = "count: $count")
        Button(onClick = pengubah) {
            Text(text = "Pencet")
        }
    }
}

@Composable
fun searchBar(modifier: Modifier = Modifier) {
    var input by rememberSaveable{ mutableStateOf("")} //state
    TextField(
        value = input,
        onValueChange = {updateInput-> //update state
            input = updateInput
        },
        modifier= Modifier
            .fillMaxWidth(),
        placeholder = { Text(text = "ini placeholder")}

    )
}

@Composable
fun tulisNama(state: State = stateRemember(field = "", condition = false)) {
    //penggunaan state management

    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp),
    ) {
        TextField(
            value = state.inputField,
            onValueChange = {state.inputField = it}
        )
        Button(onClick = {
            state.showText = state.inputField.isNotEmpty()
            state.buttonClick = true
            state.textField = state.inputField
        },
            modifier = Modifier
        ) {
            Text(text = "kirim")
        }

        if(state.showText){
            Text(text = "halo ${state.textField}")
            state.buttonClick = false
        }
    }
}

@Composable
fun scaffoldSample(modifier: Modifier = Modifier) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "ini top bar")
                },
                colors = TopAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White,
                    scrolledContainerColor = Color.White,
                    navigationIconContentColor = Color.White
                ),
            )
        }
    ){
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            userProfile()
            userChat()
            iniButton()
            countFunction()
            searchBar()
            tulisNama()
        }
    }
}