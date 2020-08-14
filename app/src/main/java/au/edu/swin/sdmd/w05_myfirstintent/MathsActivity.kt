package au.edu.swin.sdmd.w05_myfirstintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import org.w3c.dom.Text

const val times_tables_key_for_calculateActivity = 0
const val times_tables_values_key_for_putExtra = "TwoValueInput"
class MathsActivity : AppCompatActivity() {

    private lateinit var firstInput: TextView
    private lateinit var secondInput: TextView
    private lateinit var calculateButton: Button
    private lateinit var provider: calculateViewModel
    private lateinit var calculation: multiplication

    fun updateScreen(): multiplication {
        firstInput.text = provider.firstInput.toString()
        secondInput.text = provider.secondInput.toString()
        return multiplication(provider.firstInput, provider.secondInput)
    }

    override fun onResume() {
        super.onResume()
        provider.regenInputs()
        calculation = updateScreen()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maths)

        firstInput = findViewById(R.id.activityMaths_firstInput)
        secondInput = findViewById(R.id.activityMaths_secondInput)
        calculateButton = findViewById(R.id.activityMaths_calculateBtn)

        provider = ViewModelProvider(this).get(calculateViewModel::class.java)


        calculation = updateScreen()



        calculateButton.setOnClickListener {
            val intent = Intent(this, CalculatedMathsActivity::class.java).apply {
                putExtra(times_tables_values_key_for_putExtra, calculation)
            }
            startActivity(intent)
        }
    }






}