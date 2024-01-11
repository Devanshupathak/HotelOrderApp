package com.vishwa.hotelorderapp.util

import android.util.Patterns
import android.widget.TextView

class Validate(val tv:TextView) {

    fun isEmpty(msg:String): Validate {
        if (tv.text.toString().isEmpty())
            throw ValidationException(msg)
        return this
    }

    fun isEmptyWithTrim(msg:String): Validate {
        if (tv.text.toString().trim().isEmpty())
            throw ValidationException(msg)
        return this
    }

    fun minLength(size:Int,msg:String): Validate {
        if (tv.text.toString().length>size)
            throw ValidationException(msg)
        return this
    }

    fun checkEmail(msg:String): Validate {
        if (!tv.text.toString().matches(Patterns.EMAIL_ADDRESS.toRegex()))
            throw ValidationException(msg)
        return this
    }

    fun compare(tv1:TextView,msg:String): Validate {
        if (!tv.text.toString().equals(tv1.text.toString())) {
            throw ValidationException(msg)
            tv1.requestFocus()
        }
        return this
    }




}