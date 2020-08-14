package au.edu.swin.sdmd.w05_myfirstintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DetailActivity : AppCompatActivity() {

    private lateinit var gotoActivityMaths: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        gotoActivityMaths = findViewById(R.id.detailActivity_gotoActivityMathsBtn)

        gotoActivityMaths.setOnClickListener {
            val intent = Intent(this@DetailActivity, MathsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}