package by.mbicycle.develop.roomexample.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import by.mbicycle.develop.roomexample.room.model.Car

@Dao
interface CarDao {
    @Query("SELECT * FROM car")
    fun getAll(): List<Car>

    @Insert
    fun insert(car: Car)

    @Delete
    fun delete(car: Car)
}