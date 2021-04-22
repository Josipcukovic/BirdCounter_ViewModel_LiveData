package josip.cukovic.birdcounter.model

import josip.cukovic.birdcounter.manager.PreferenceManager

class BirdCounter {
    private val preferenceManager = PreferenceManager()

    fun birdSeen(){
        var counter = preferenceManager.retrieveCount()
        counter++
        preferenceManager.saveCount(counter)
    }

    fun saveBirdColor(color : Int){
        preferenceManager.saveColor(color)
    }

    fun getCounter() : Int{
        return preferenceManager.retrieveCount()
    }

    fun getLastBirdColor() : Int{
        return preferenceManager.retrieveColor()
    }

    fun resetBirdCounter(){
        preferenceManager.saveCount(0)
    }

}