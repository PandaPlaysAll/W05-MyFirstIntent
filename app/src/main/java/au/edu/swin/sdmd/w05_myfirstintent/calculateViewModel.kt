package au.edu.swin.sdmd.w05_myfirstintent

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class calculateViewModel: ViewModel() {

    fun calculateRandomValue() = Random.nextInt(13) + 1
    var firstInput: Int = calculateRandomValue()
    var secondInput: Int = calculateRandomValue()

    fun regenInputs() {
        firstInput = calculateRandomValue()
        secondInput = calculateRandomValue()
    }

}

