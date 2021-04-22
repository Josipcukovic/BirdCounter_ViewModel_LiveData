package josip.cukovic.birdcounter.manager

import android.content.Context
import josip.cukovic.birdcounter.BirdCounterApplication
import josip.cukovic.birdcounter.R

class PreferenceManager {
    companion object {
        const val PREFS_FILE = "MyPreferences"
        const val PREFS_KEY_COUNTER = "count"
        const val PREFS_KEY_COLOR = "color"
    }

    fun saveCount(count : Int) {
        val sharedPreferences = BirdCounterApplication.ApplicationContext.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(PREFS_KEY_COUNTER, count)
        editor.apply()
    }

    fun saveColor(color : Int){
        val sharedPreferences = BirdCounterApplication.ApplicationContext.getSharedPreferences(PREFS_FILE,Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(PREFS_KEY_COLOR,color)
        editor.apply()
    }

    fun retrieveCount(): Int {
        val sharedPreferences = BirdCounterApplication.ApplicationContext.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
        return sharedPreferences.getInt(PREFS_KEY_COUNTER, 0)
    }

    fun retrieveColor(): Int {
        val sharedPreferences = BirdCounterApplication.ApplicationContext.getSharedPreferences(PREFS_FILE,Context.MODE_PRIVATE)
        return sharedPreferences.getInt(PREFS_KEY_COLOR, R.color.white)
    }

}