package by.mbicycle.develop.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import by.mbicycle.develop.roomexample.room.db.AppDatabase
import by.mbicycle.develop.roomexample.room.model.Address
import by.mbicycle.develop.roomexample.room.model.Employee
import java.util.concurrent.Executors

const val LOG_TAG = "myLogs"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(this, AppDatabase::class.java,
            "database").build()
        val employeeDao = db.employeeDao()

        Executors.newCachedThreadPool().submit {
            val createNewEmployee = Employee().apply {
                id = 1
                name = "John Smith"
                salary = 10000
            }

            //добавление нового сотрудника в базу
            employeeDao.insert(createNewEmployee)

            //получение сотрудника по id
            val employee = employeeDao.getById(1)
            Log.d(LOG_TAG, "employee: $employee")

            //обновление данных по сотруднику
            employee.salary = 200000
            employeeDao.update(employee)

            //добавляем новую запись с вложенным объектом
            val addressOfBenedict = Address().apply {
                city = "London"
                street = "Baker Street"
                number = 221
            }

            val benedictEmployee = Employee().apply {
                name = "Benedict Camberbatch"
                salary = 10000
                address = addressOfBenedict
            }

            employeeDao.insert(benedictEmployee)

            //возвращаем список всех сотрудников
            val employees = employeeDao.getAll()
            employees.forEach { Log.d(LOG_TAG, "employee: $it") }
        }
    }
}