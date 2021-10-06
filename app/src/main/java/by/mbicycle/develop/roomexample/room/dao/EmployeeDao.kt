package by.mbicycle.develop.roomexample.room.dao


import androidx.room.*
import by.mbicycle.develop.roomexample.room.model.Employee

@Dao
interface EmployeeDao {
    @Query("SELECT * FROM employees")
    fun getAll(): List<Employee>

    @Query("SELECT * FROM employees WHERE id = :id")
    fun getById(id: Long): Employee

    @Insert
    fun insert(employee: Employee)

    @Update
    fun update(employee: Employee)

    @Delete
    fun delete(employee: Employee)
}