package au.edu.swin.sdmd.w05_myfirstintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CalculatedMathsActivity : AppCompatActivity() {

    private lateinit var answerTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculated_maths)

        val inputs = intent.getParcelableExtra<multiplication>(times_tables_values_key_for_putExtra)

        answerTextView = findViewById(R.id. calculatedMathsActivity_answerTextView)
        answerTextView.text = (inputs.firstInput * inputs.secondInput).toString()


    }
}