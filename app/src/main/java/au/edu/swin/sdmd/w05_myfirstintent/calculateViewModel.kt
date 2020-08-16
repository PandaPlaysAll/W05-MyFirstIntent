package au.edu.swin.sdmd.w05_myfirstintent

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class calculateViewModel: ViewModel() {

    fun calculateRandomValue() = Random.nextInt(13) + 1
    var firstInput: Int = 0
    var secondInput: Int = 0

    fun regenInputs() {
        firstInput = calculateRandomValue()
        secondInput = calculateRandomValue()
    }

}

