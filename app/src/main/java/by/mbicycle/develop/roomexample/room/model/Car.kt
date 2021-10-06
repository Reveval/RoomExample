package by.mbicycle.develop.roomexample.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(foreignKeys =
[ForeignKey(
    entity = Employee::class,
    parentColumns = ["id"],
    childColumns = ["employee_id"],
    onDelete = CASCADE
)])
data class Car(

    @PrimaryKey(autoGenerate = true)
    var id: Long,

    var model: String,

    var year: Int,

    @ColumnInfo(name = "employee_id")
    var employeeId: Long)