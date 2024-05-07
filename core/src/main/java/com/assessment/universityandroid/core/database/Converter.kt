package com.assessment.universityandroid.core.database

import androidx.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.lang.reflect.Type


class Converter {
    @TypeConverter
    fun listToJson(value: List<String>?) = Gson().toJson(value)
    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()
}