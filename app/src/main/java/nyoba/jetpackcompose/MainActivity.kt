package nyoba.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import nyoba.jetpackcompose.ui.theme.JetpackComposeTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column (modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, start = 10.dp, bottom = 20.dp, end = 10.dp)) {

                userProfile()
                userChat()

            }
//            JetpackComposeTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
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

@Preview(showBackground = true)
@Composable
private fun userProfileView() {
    JetpackComposeTheme {
        userProfile()
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTheme {
        Greeting("Android")
    }
}