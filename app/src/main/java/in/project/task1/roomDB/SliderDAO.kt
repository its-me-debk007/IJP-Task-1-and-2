package `in`.project.task1.roomDB

import `in`.project.task1.model.SliderValues
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SliderDAO {

	@Insert
	suspend fun insertSliders(sliders: List<SliderValues>)

	@Query("SELECT * FROM slider")
	fun getSliders(): LiveData<List<SliderValues>>

	@Query("DELETE FROM slider")
	suspend fun clearAllSlides()
}