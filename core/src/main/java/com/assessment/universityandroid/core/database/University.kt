package com.assessment.universityandroid.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "university_table")
data class University(
    @PrimaryKey var id:Long,
    var name:String,
    var alphaTwoCode:String,
    var country:String,
    var stateProvince:String,
    var webPage: List<String>,
    var domains: List<String>,

)