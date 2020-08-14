package au.edu.swin.sdmd.w05_myfirstintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

const val main_activity_to_detail_activity_data_key = 0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.mainImage)
        image.setOnClickListener {
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            startActivity(intent)
        }
    }
}