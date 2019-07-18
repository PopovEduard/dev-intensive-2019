package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val firstName: String?
        val lastName: String?
        val parts: List<String>? = fullName?.trim()?.split(" ")
        if (parts != null) {
            if (parts.getOrNull(0).isNullOrEmpty()) {
                firstName = null
            } else {
                firstName = parts.getOrNull(0)
            }
            if (parts.getOrNull(1).isNullOrEmpty()) {
                lastName = null
            } else {
                lastName = parts.getOrNull(1)
            }
        } else {
            firstName = null
            lastName = null
        }
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String? {
        var result: String? = ""
        var temp: String
        if (payload.isBlank()) result = ""
        else
            for (c in payload) {
                temp = when (c.toString().toLowerCase()) {
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
                result += if (c.isUpperCase()) {
                    if(temp!="")temp.
                        first().
                        toUpperCase().
                        plus(temp.
                            drop(1))
                    else continue
                } else {
                    if(temp!="")temp else continue
                }
            }

        return result

    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val initials: String?
        if (firstName.isNullOrBlank() and lastName.isNullOrBlank()) initials = null
        else initials = if (firstName.isNullOrBlank()) {
            ""
        } else {
            firstName.trim().firstOrNull().toString().toUpperCase()
        } +
                if (lastName.isNullOrBlank()) {
                    ""
                } else {
                    lastName.trim().firstOrNull().toString().toUpperCase()
                }
        return initials
    }


}