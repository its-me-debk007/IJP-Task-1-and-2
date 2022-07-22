package `in`.project.task1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "slider")
data class SliderValues(
	@PrimaryKey val startValue: Int,
	var endValue: Int,
	val color: Int
)
