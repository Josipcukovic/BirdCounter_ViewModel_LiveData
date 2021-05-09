package josip.cukovic.birdcounter.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import josip.cukovic.birdcounter.model.BirdCounter

class BirdCounterViewModel: ViewModel() {
    private val birdCounter = BirdCounter()
    var number = birdCounter.getCounter()
    var color = birdCounter.getLastBirdColor()

    val counter: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }

    fun birdSeen() { birdCounter.birdSeen()}
    fun saveBirdColor(color : Int) {birdCounter.saveBirdColor(color)}

    fun resetCounter()  {
        birdCounter.resetBirdCounter()
        number = 0
    }

    val  birdColor : MutableLiveData<Int> by lazy { MutableLiveData<Int>() }

}