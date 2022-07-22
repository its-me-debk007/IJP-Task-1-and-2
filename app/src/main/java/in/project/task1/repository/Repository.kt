package `in`.project.task1.repository

import `in`.project.task1.model.SliderValues
import `in`.project.task1.roomDB.SliderDAO
import androidx.lifecycle.LiveData

class Repository(private val sliderDao: SliderDAO) {

	suspend fun insertSliders(sliders: List<SliderValues>) = sliderDao.insertSliders(sliders)

	fun getSliders(): LiveData<List<SliderValues>> = sliderDao.getSliders()

	suspend fun clearAllSlides() = sliderDao.clearAllSlides()

}