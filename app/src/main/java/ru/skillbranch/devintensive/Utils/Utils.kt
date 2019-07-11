package ru.skillbranch.devintensive.Utils

import android.text.TextUtils.isEmpty

object Utils {
    fun parseFullName(fullName:String?): Pair<String?,String?>{
        var firstName: String? = null
        var lastName: String? = null
        var parts: List<String>? = fullName?.split(" ")
        if (parts!= null) {
            if(parts?.getOrNull(0).isNullOrEmpty()){
                firstName = null
            } else {
                firstName = parts?.getOrNull(0)
            }
            if(parts?.getOrNull(1).isNullOrEmpty()){
                lastName = null
            } else {
                lastName = parts?.getOrNull(1)
            }
        } else{
            firstName = null
            lastName = null
        }


//        return Pair(firstName, lastName)
        return firstName to lastName

    }

    fun transliteration(payload: String, divider: String = " "): String? {
        var result: String? = ""
        var temp: String? = ""
        if(payload.isNullOrBlank()) result=""
        else
        for (c in payload){
            temp = when(c.toString().toLowerCase()){
                "а" -> "a"
                "б" -> "b"
                "в" -> "v"
                "г" -> "g"
                "д" -> "d"
                "е" -> "e"
                "ё" -> "e"
                "ж" -> "zh"
                "з" -> "z"
                "и" -> "i"
                "й" -> "i"
                "к" -> "k"
                "л" -> "l"
                "м" -> "m"
                "н" -> "n"
                "о" -> "o"
                "п" -> "p"
                "р" -> "r"
                "с" -> "s"
                "т" -> "t"
                "у" -> "u"
                "ф" -> "f"
                "х" -> "h"
                "ц" -> "c"
                "ч" -> "ch"
                "ш" -> "sh"
                "щ" -> "sh'"
                "ъ" -> ""
                "ы" -> "i"
                "ь" -> ""
                "э" -> "e"
                "ю" -> "yu"
                "я" -> "ya"
                " " -> divider
                else -> c.toString()
            }
            result+=if(c.isUpperCase()){temp.toUpperCase()}else{temp}
        }

        return result

    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var initials: String?
        if(firstName.isNullOrBlank() and lastName.isNullOrBlank()) initials=null
        else initials = if(firstName.isNullOrBlank()){""}else{firstName.firstOrNull().toString().toUpperCase()}+
                if(lastName.isNullOrBlank()){""}else{lastName.firstOrNull().toString().toUpperCase()}
        return initials
    }

    fun toEndingSecond(number: Float): String{
        return when(number.toLong().toString().last()){
            '1' -> "секунду"
            '2', '3', '4' -> "секунды"
            else -> "секунд"
        }
    }

    fun toEndingMinute(number: Float): String{
        return when(number.toLong().toString().last()){
            '1' -> "минуту"
            '2', '3', '4' -> "минуты"
            else -> "минут"
        }
    }

    fun toEndingHours(number: Float): String{
        return when(number.toLong().toString().last()){
            '1' -> "час"
            '2', '3', '4' -> "часа"
            else -> "часов"
        }
    }

    fun toEndingDays(number: Float): String{
        return when(number.toLong().toString().last()){
            '1' -> "день"
            '2', '3', '4' -> "дня"
            else -> "дней"
        }
    }


    fun toMinuteString(number: Float, isPositive: Boolean): String{
        val numberL:Long = number.toLong()
        return if(isPositive) "$numberL ${toEndingMinute(number)} назад"
        else "через $numberL ${toEndingMinute(number)}"
    }

    fun toHoursString(number: Float, isPositive: Boolean): String{
        val numberL:Long = number.toLong()
        return if(isPositive) "$numberL ${toEndingHours(number)} назад"
        else "через $numberL ${toEndingHours(number)}"
    }

    fun toDaysString(number: Float, isPositive: Boolean): String{
        val numberL:Long = number.toLong()
        return if(isPositive) "$numberL ${toEndingDays(number)} назад"
        else "через $numberL ${toEndingDays(number)}"
    }
}