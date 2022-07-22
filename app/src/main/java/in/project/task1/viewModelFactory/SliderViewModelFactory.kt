package `in`.project.task1.viewModelFactory

import `in`.project.task1.repository.Repository
import `in`.project.task1.viewModel.SliderViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SliderViewModelFactory(private val repository: Repository) :
	ViewModelProvider.Factory {
	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		if (modelClass.isAssignableFrom(SliderViewModel::class.java))
			return SliderViewModel(repository) as T
		throw IllegalArgumentException("ViewModel not found")
	}
}