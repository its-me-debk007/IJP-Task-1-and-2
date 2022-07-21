package `in`.project.task1.adapter

import `in`.project.task1.databinding.ItemSliderBinding
import `in`.project.task1.model.SliderValues
import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.slider.Slider
import com.google.android.material.textview.MaterialTextView

class SliderRecyclerAdapter(private val listener: SliderInterface,
							private var items: MutableList<SliderValues>) :
	RecyclerView.Adapter<SliderRecyclerAdapter.SliderViewHolder>() {

	inner class SliderViewHolder(val binding: ItemSliderBinding) :
		RecyclerView.ViewHolder(binding.root) {
		init {
			binding.apply {
				slider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
					override fun onStartTrackingTouch(slider: Slider) {
						listener.onSliderStart(minValue, adapterPosition)
					}

					override fun onStopTrackingTouch(slider: Slider) {
						listener.onSliderStop(slider, minValue, maxValue, adapterPosition)
					}
				})

				slider.addOnChangeListener { it, _, _ ->
					listener.onSliderChange(it, maxValue, adapterPosition)
				}
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder =
		SliderViewHolder(ItemSliderBinding.inflate(LayoutInflater.from(parent.context),
												   parent, false))

	override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
		holder.binding.apply {
			minValue.text = items[position].startValue.toString()
			maxValue.text = items[position].endValue.toString()
			slider.valueFrom = items[position].startValue.toFloat()
			slider.valueTo = items[position].endValue.toFloat()
			slider.value = items[position].endValue.toFloat()
			maxValue.setBackgroundColor(items[position].color)
			minValue.setBackgroundColor(items[position].color)
			slider.thumbTintList = ColorStateList.valueOf(items[position].color)
			slider.trackActiveTintList = ColorStateList.valueOf(items[position].color)
		}
	}

	override fun getItemCount(): Int = items.size

	@SuppressLint("NotifyDataSetChanged")
	fun setSliders(newItems: List<SliderValues>) {
		items = newItems.toMutableList()
		notifyDataSetChanged()
	}
}

interface SliderInterface {
	fun onSliderStart(minValue: MaterialTextView, position: Int)

	fun onSliderStop(slider: Slider, minValue: MaterialTextView,
					 maxValue: MaterialTextView, position: Int)

	fun onSliderChange(slider: Slider, maxValue: MaterialTextView, position: Int)
}