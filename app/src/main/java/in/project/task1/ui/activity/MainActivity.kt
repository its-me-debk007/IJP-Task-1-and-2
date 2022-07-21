package `in`.project.task1.ui.activity

import `in`.project.task1.R
import `in`.project.task1.adapter.SliderInterface
import `in`.project.task1.adapter.SliderRecyclerAdapter
import `in`.project.task1.databinding.ActivityMainBinding
import `in`.project.task1.model.SliderValues
import `in`.project.task1.viewModel.SliderViewModel
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.slider.Slider
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity(), SliderInterface {
	private val viewModel by lazy { ViewModelProvider(this)[SliderViewModel::class.java] }
	private lateinit var toast: Toast
	private val adapter by lazy { SliderRecyclerAdapter(this, viewModel.sliderValuesList) }
	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		toast = Toast.makeText(this, null, Toast.LENGTH_SHORT)
		binding.sliderRecyclerView.adapter = adapter
	}

	override fun onSliderStart(minValue: MaterialTextView, position: Int) {
		val icon = if (position == 0) R.drawable.ic_delete_sweep else R.drawable.ic_delete
		minValue.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0)
		minValue.text = null
	}

	override fun onSliderStop(slider: Slider, minValue: MaterialTextView,
							  maxValue: MaterialTextView, position: Int) {

		minValue.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
		minValue.text = slider.valueFrom.toInt().toString()

		if (slider.value == slider.valueFrom) {
			if (position == 0) {
				viewModel.sliderValuesList.clear()
				viewModel.sliderValuesList.add(SliderValues(1, 100, Color.parseColor("#DC143C")))
			} else {
				viewModel.sliderValuesList[position - 1].endValue =
					viewModel.sliderValuesList[position].endValue
				viewModel.sliderValuesList.removeAt(position)
			}
			adapter.setSliders(viewModel.sliderValuesList)
			return
		}

		if (slider.valueTo - slider.value <= 2) {
			toast.cancel()
			toast = Toast.makeText(this, "Minimum segment length is 2!", Toast.LENGTH_SHORT)
			toast.show()
			slider.value = slider.valueTo
			return
		}

		viewModel.sliderValuesList[position].endValue = slider.value.toInt()
		val color = viewModel.sliderValuesList[position].color
		viewModel.sliderValuesList.add(position + 1, SliderValues(slider.value.toInt() + 1,
																  slider.valueTo.toInt(), color))
		adapter.setSliders(viewModel.sliderValuesList)
		slider.valueTo = slider.value
	}

	override fun onSliderChange(slider: Slider, maxValue: MaterialTextView, position: Int) {

		if (slider.value == slider.valueFrom) {
			val icon = if (position == 0) R.drawable.ic_delete_sweep else R.drawable.ic_delete
			maxValue.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0)
			maxValue.text = null
		} else {
			maxValue.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
			maxValue.text = slider.value.toInt().toString()
		}
	}

	override fun onPause() {
		super.onPause()
		toast.cancel()
	}
}