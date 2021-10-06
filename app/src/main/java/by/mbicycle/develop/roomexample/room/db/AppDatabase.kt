package by.mbicycle.develop.roomexample.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import by.mbicycle.develop.roomexample.room.dao.CarDao
import by.mbicycle.develop.roomexample.room.dao.EmployeeCarDao
import by.mbicycle.develop.roomexample.room.dao.EmployeeDao
import by.mbicycle.develop.roomexample.room.model.Car
import by.mbicycle.develop.roomexample.room.model.Employee

@Database(entities = [Employee::class, Car::class, EmployeeCarDao::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao
    abstract fun carDao(): CarDao
    abstract fun employeeCarDao(): EmployeeCarDao
}