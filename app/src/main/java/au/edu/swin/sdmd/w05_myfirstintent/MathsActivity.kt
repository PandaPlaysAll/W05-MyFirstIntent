package au.edu.swin.sdmd.w05_myfirstintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

const val times_tables_key_for_calculateActivity = 0
const val times_tables_values_key_for_putExtra = "TwoValueInput"
class MathsActivity : AppCompatActivity() {

    private lateinit var firstInput: TextInputEditText
    private lateinit var secondInput: TextInputEditText
    private lateinit var calculateButton: Button
    private lateinit var provider: calculateViewModel


    /*  fun updateScreen(): multiplication {
          firstInput.text = provider.firstInput.toString()
          secondInput.text = provider.secondInput.toString()
          return multiplication(provider.firstInput, provider.secondInput)
    }*/

    override fun onResume() {
        super.onResume()
      /*  provider.regenInputs()
        calculation = updateScreen()

       return ...*/
    }


    fun calculateValues(): multiplication? {
        var firstValue = firstInput?.text.toString()
        var secondValue = secondInput?.text.toString()

        var actualValueOne = firstValue.toIntOrNull()
        var actualValueTwo = secondValue.toIntOrNull()

        if (actualValueOne == null || actualValueTwo == null) {
            return null
        } else {
            return multiplication(actualValueOne, actualValueTwo)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maths)

        firstInput = findViewById(R.id.activityMaths_firstInput)
        secondInput = findViewById(R.id.activityMaths_secondInput)
        calculateButton = findViewById(R.id.activityMaths_calculateBtn)

        provider = ViewModelProvider(this).get(calculateViewModel::class.java)




        //ADJUST THIS TO USE A FRAGMENT
        val currentFragment = supportFragmentManager.findFragmentById(R.id.calculate_answer_section)

        if (currentFragment == null) {
            newFragment()
        }




        calculateButton.setOnClickListener {
            var calculation = calculateValues()
            if (calculation == null) {
                Toast.makeText(this.parent, "Invalid Input", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var bundle = Bundle()
            bundle.putParcelable(times_tables_values_key_for_putExtra, calculation)

            var fragment = calculatedMathsFragment()
            fragment.arguments = bundle

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.calculate_answer_section, fragment)
                .addToBackStack(null)
                .commit()

            /*provider.regenInputs()
            calculation = updateScreen()*/
        }

    }

    fun newFragment() {
        val fragment = calculatedMathsFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.calculate_answer_section, fragment)
            .commit()
    }






}