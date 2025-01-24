package nyoba.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import nyoba.jetpackcompose.data.HeroesData

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            heroList()
        }


    }
}

@Composable
fun heroList(modifier: Modifier = Modifier) {
    LazyColumn (
        modifier
            .fillMaxWidth()
    ){
        items(HeroesData.heroes){
            heroItem(name = it.name, photoUrl = it.photoUrl)
        }
    }
}

@Composable
fun heroItem(modifier: Modifier = Modifier, name: String, photoUrl: String) {
    Row (modifier
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        AsyncImage(model = photoUrl,
            contentDescription = null,
            modifier
                .padding(5.dp)
                .size(80.dp))
        Text(text = name,
            modifier
                .fillMaxWidth()
                .size(20.dp),
            fontWeight = FontWeight.Medium)
    }
}

@Preview(showBackground = true)
@Composable
private fun heroPrev() {
    heroList()
}