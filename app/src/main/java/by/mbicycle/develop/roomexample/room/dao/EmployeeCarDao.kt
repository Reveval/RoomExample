package by.mbicycle.develop.roomexample.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Transaction
import by.mbicycle.develop.roomexample.room.model.Car
import by.mbicycle.develop.roomexample.room.model.Employee

@Dao
abstract class EmployeeCarDao {
    @Insert
    abstract fun insertEmployee(employee: Employee)

    @Insert
    abstract fun insertCar(car: Car)

    @Transaction
    fun insertCarAndEmployee(car: Car, employee: Employee) {
        insertCar(car)
        insertEmployee(employee)
    }
}