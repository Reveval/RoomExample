package by.mbicycle.develop.roomexample.room.model

import androidx.room.*

@Entity(tableName = "employees")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    @ColumnInfo(name = "full_name")
    var name: String = "",

    var salary: Int = 0,

    @Embedded
    var address: Address = Address(),
)