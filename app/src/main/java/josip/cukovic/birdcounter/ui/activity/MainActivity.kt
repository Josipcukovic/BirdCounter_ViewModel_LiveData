package josip.cukovic.birdcounter.ui.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import josip.cukovic.birdcounter.BirdCounterApplication
import josip.cukovic.birdcounter.R

import josip.cukovic.birdcounter.databinding.ActivityMainBinding
import josip.cukovic.birdcounter.model.BirdCounter
import josip.cukovic.birdcounter.ui.viewmodels.BirdCounterViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    lateinit var viewModel: BirdCounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        viewModel = ViewModelProvider(this).get(BirdCounterViewModel::class.java)
        viewModel.counter.observe(this, { mainBinding.tvCountValue.text = it.toString() })
        viewModel.birdColor.observe(this,{
            mainBinding.tvCountValue.setBackgroundColor(viewModel.birdColor.value!!)
            viewModel.saveBirdColor(viewModel.color)
        })

        setUpUi()
    }

    private fun setUpUi() {
        showInfo()
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
        viewModel.resetCounter()
        viewModel.counter.value = viewModel.number
        updateColor(R.color.white)
    }

    private fun changeToYellow() {
        updateColor(R.color.yellow)
    }

    private fun changeToRed() {
        updateColor(R.color.red)
    }

    private fun changeToGreen() {
        updateColor(R.color.green)
    }

    private fun changeToBlue() {
        updateColor(R.color.blue)
    }

    private fun showInfo(){
         mainBinding.tvCountValue.setBackgroundColor(viewModel.color)
         mainBinding.tvCountValue.text = viewModel.number.toString()
    }

    private fun updateColor(color: Int) {
        viewModel.color = ContextCompat.getColor(BirdCounterApplication.ApplicationContext, color)
        viewModel.birdColor.value = viewModel.color
        mainBinding.tvCountValue.setBackgroundColor(viewModel.birdColor.value!!)
    }

    private fun saveCount() {
        viewModel.counter.value = ++viewModel.number
        viewModel.birdSeen()
    }

}