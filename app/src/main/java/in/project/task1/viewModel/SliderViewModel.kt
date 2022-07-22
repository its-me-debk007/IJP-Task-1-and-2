package `in`.project.task1.viewModel

import `in`.project.task1.model.SliderValues
import `in`.project.task1.repository.Repository
import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SliderViewModel(private val repository: Repository) : ViewModel() {
	var sliderValuesList = mutableListOf(SliderValues(1, 32, Color.parseColor("#DC143C")),
										 SliderValues(33, 56, Color.parseColor("#F28C28")),
										 SliderValues(57, 85, Color.parseColor("#6495ED")),
										 SliderValues(86, 100, Color.parseColor("#B4C424")))
	var isDataChanged = false

	fun insertSliders(sliders: List<SliderValues>) = viewModelScope.launch {
		repository.insertSliders(sliders)
	}

	fun getSliders(): LiveData<List<SliderValues>> = repository.getSliders()

	fun clearAllSlides() = viewModelScope.launch {
		repository.clearAllSlides()
	}
}