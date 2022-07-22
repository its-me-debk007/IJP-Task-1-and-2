package `in`.project.task1.util

import `in`.project.task1.repository.Repository
import `in`.project.task1.roomDB.SliderDB
import android.app.Application

class SliderApplication : Application() {

	private val database by lazy { SliderDB.getDB(this) }
	val repository by lazy { Repository(database.sliderDao()) }
}