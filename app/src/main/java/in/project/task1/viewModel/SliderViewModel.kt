package `in`.project.task1.viewModel

import `in`.project.task1.model.SliderValues
import android.graphics.Color
import androidx.lifecycle.ViewModel

class SliderViewModel : ViewModel() {
	val sliderValuesList = mutableListOf(SliderValues(1, 32, Color.parseColor("#DC143C")),
										 SliderValues(33, 56, Color.parseColor("#F28C28")),
										 SliderValues(57, 85, Color.parseColor("#6495ED")),
										 SliderValues(86, 100, Color.parseColor("#B4C424")))
}