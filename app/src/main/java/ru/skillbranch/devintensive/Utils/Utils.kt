package ru.skillbranch.devintensive.Utils

import android.service.voice.AlwaysOnHotwordDetector

object Utils {
    fun parseFullName(fullName:String?): Pair<String?,String?>{
        // TODO Fix me!!!
        var parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
//        return Pair(firstName, lastName)
        return firstName to lastName

    }

    fun transliteration(payload: String, divider: String = " "): String {
        TODO()
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}