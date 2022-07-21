package `in`.project.task1.ui.activity

import `in`.project.task1.R
import `in`.project.task1.adapter.SliderInterface
import `in`.project.task1.adapter.SliderRecyclerAdapter
import `in`.project.task1.databinding.ActivityMainBinding
import `in`.project.task1.viewModel.SliderViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.google.android.material.slider.Slider
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity(), SliderInterface {
	private val viewModel by lazy { ViewModelProvider(this)[SliderViewModel::class.java] }

	//	private val viewModel : SliderViewModel by viewModels()
	private val adapter by lazy { SliderRecyclerAdapter(this, viewModel.sliderCount) }
	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		binding.sliderRecyclerView.adapter = adapter
	}

	override fun onSliderStart(slider: Slider,
							   minValue: MaterialButton,
							   maxValue: MaterialButton) {
		minValue.setIconResource(R.drawable.ic_delete_sweep)
		minValue.text = ""
	}

	override fun onSliderStop(slider: Slider,
							  minValue: MaterialButton,
							  maxValue: MaterialButton) {
		TODO("Not yet implemented")
	}
}