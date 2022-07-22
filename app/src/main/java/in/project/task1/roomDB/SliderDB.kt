package `in`.project.task1.roomDB

import `in`.project.task1.model.SliderValues
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SliderValues::class], version = 1)
abstract class SliderDB : RoomDatabase() {

	abstract fun sliderDao(): SliderDAO

	companion object {
		@Volatile
		private var INSTANCE: SliderDB? = null

		fun getDB(context: Context): SliderDB {
			if (INSTANCE == null) {
				synchronized(this) {
					INSTANCE = Room.databaseBuilder(context, SliderDB::class.java, "sliderDB")
						.build()
				}
			}
			return INSTANCE!!
		}
	}
}