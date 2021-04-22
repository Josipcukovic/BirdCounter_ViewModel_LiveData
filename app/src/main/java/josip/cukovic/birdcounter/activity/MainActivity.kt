package josip.cukovic.birdcounter.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import josip.cukovic.birdcounter.R.color.*
import josip.cukovic.birdcounter.databinding.ActivityMainBinding
import josip.cukovic.birdcounter.model.BirdCounter

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private val birdCounter = BirdCounter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setUpUi()
    }

    private fun setUpUi() {
        mainBinding.btnBlueBird.setOnClickListener{
            changeToBlue()
            saveCount()
        }
        mainBinding.btnGreenBird.setOnClickListener{
            changeToGreen()
            saveCount()
        }
        mainBinding.btnRedBird.setOnClickListener{
            changeToRed()
            saveCount()
       }
        mainBinding.btnYellowBird.setOnClickListener{
            changeToYellow()
            saveCount()
        }

        mainBinding.btnReset.setOnClickListener{resetValues()}
    }

    private fun resetValues() {
        birdCounter.resetBirdCounter()
        birdCounter.saveBirdColor(resources.getColor(white))
        displayCounterInformation()
    }

    private fun changeToYellow() {
        birdCounter.saveBirdColor(resources.getColor(yellow))
    }

    private fun changeToRed() {
        birdCounter.saveBirdColor(resources.getColor(red))
    }

    private fun changeToGreen() {
        birdCounter.saveBirdColor(resources.getColor(green))
    }

    private fun changeToBlue() {
        birdCounter.saveBirdColor(resources.getColor(blue))
    }

    override fun onResume() {
        super.onResume()
        displayCounterInformation()
    }

    private fun displayCounterInformation() {
        mainBinding.tvCountValue.text = birdCounter.getCounter().toString()
        mainBinding.tvCountValue.setBackgroundColor(birdCounter.getLastBirdColor())
    }

    private fun saveCount() {
        birdCounter.birdSeen()
        displayCounterInformation()
    }

}