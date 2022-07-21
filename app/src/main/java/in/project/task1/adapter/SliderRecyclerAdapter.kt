package `in`.project.task1.adapter

import `in`.project.task1.databinding.ActivityMainBinding
import `in`.project.task1.databinding.ItemSliderBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.slider.Slider
import com.google.android.material.textview.MaterialTextView

class SliderRecyclerAdapter(private val listener: SliderInterface, private val noOfSliders: Int) :
	RecyclerView.Adapter<SliderViewHolder>() {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder =
		SliderViewHolder(ItemSliderBinding.inflate(LayoutInflater.from(parent.context),
													 parent, false))

	override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
			holder.binding.slider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
				override fun onStartTrackingTouch(slider: Slider) {
					listener.onSliderStart(slider, holder.binding.minValue, holder.binding.maxValue)
				}

				override fun onStopTrackingTouch(slider: Slider) {
					listener.onSliderStop(slider, holder.binding.minValue, holder.binding.maxValue)
				}
			})
	}

	override fun getItemCount(): Int = noOfSliders

}

class SliderViewHolder(val binding: ItemSliderBinding) : RecyclerView.ViewHolder(binding.root) {

}

interface SliderInterface {
	fun onSliderStart(slider: Slider, minValue: MaterialButton, maxValue: MaterialButton)
	fun onSliderStop(slider: Slider, minValue: MaterialButton, maxValue: MaterialButton)
}