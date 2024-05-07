package com.assessment.universityandroid.list_module.model

data class University(
    var id:Int,
    var name:String,
    var alphaTwoCode:String,
    var country:String,
    var stateProvince:String,
    var webPage: List<String>,
    var domains: List<String>,
)