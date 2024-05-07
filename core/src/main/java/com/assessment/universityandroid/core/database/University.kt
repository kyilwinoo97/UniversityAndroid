package com.assessment.universityandroid.core.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "university_table")
data class University(
    @PrimaryKey(autoGenerate = true) var id:Int,
    @SerializedName("name")
    val name:String?,
    @SerializedName("alpha_two_code")
    val alphaTwoCode:String?,
    @SerializedName("country")
    val country:String?,
    @SerializedName("state-province")
    val stateProvince:String?,
    @SerializedName("web_pages")
    val webPage: List<String>,
    @SerializedName("domains")
    val domains: List<String>,
)