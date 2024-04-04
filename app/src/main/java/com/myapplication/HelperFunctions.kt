package com.myapplication

fun validateRegData(firstName:String, lastName:String, ): Boolean{
    var validated = false

    if (firstName.isNotBlank() && lastName.isNotBlank()){
            validated = true
    }

    return validated
}