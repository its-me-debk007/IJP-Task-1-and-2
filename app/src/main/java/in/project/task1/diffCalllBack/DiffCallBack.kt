package `in`.project.task1.diffCalllBack

import androidx.recyclerview.widget.DiffUtil

class DiffCallBack(private val oldList: List<Int>, private val newList: List<Int>) :
	DiffUtil.Callback() {
	override fun getOldListSize(): Int = oldList.size

	override fun getNewListSize(): Int = newList.size

	override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
		TODO("Not yet implemented")
	}

	override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
		TODO("Not yet implemented")
	}
}