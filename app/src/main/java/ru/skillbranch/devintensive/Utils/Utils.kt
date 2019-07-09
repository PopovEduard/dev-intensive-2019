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
                else -> ""
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
}