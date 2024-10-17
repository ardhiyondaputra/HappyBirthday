package dev.ardhi.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ardhi.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BirthdayCard(
                        name = "Ardhi",
                        age = 20,
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun BirthdayCard(name: String, age: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF64B5F6), // Biru lebih cerah
                        Color(0xFF42A5F5),
                        Color(0xFF1E88E5)
                    ) // Gradien latar belakang
                )
            )
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color.White.copy(alpha = 0.9f), Color.LightGray.copy(alpha = 0.6f))
                    ),
                    shape = RoundedCornerShape(24.dp) // Kartu dengan sudut membulat
                )
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Tambahkan gambar ulang tahun di atas
            Image(
                painter = painterResource(id = R.drawable.cake), // Ganti dengan ikon yang tersedia di drawable
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFFEF5350), shape = CircleShape)
                    .padding(16.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Happy Birthday!",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White, // Warna teks kontras dengan latar belakang
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Halo $name,",
                fontSize = 28.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Yellow, // Warna yang cerah dan kontras
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Selamat Ulang Tahun yang ke- $age!",
                fontSize = 22.sp,
                color = Color(0xFFFFEE58), // Warna kuning lembut
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Semoga panjang umur, sehat selalu, dimudahkan semua urusannya",
                fontSize = 18.sp,
                color = Color.White.copy(alpha = 0.7f),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "BirthdayCardPreview")
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        BirthdayCard(name = "Ardhi", age = 20)
    }
}