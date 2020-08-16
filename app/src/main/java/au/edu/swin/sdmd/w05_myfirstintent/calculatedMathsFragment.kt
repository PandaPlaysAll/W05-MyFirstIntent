package au.edu.swin.sdmd.w05_myfirstintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class calculatedMathsFragment: Fragment() {

    private lateinit var answerTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_maths_calculated, container, false)

        answerTextView = view.findViewById(R.id.calculatedMathsActivity_answerTextView)
        val inputs = activity!!.intent.getParcelableExtra<multiplication>(times_tables_values_key_for_putExtra)

        if (inputs != null) {
            answerTextView.text = (inputs.firstInput * inputs.secondInput).toString()
        }

        return view
    }
}