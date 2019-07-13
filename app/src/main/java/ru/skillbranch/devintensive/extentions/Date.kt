package ru.skillbranch.devintensive.extentions

import ru.skillbranch.devintensive.Utils.Utils
import java.lang.Math.abs
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.sign

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String="HH:mm:ss dd:MM:yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND) : Date{
    var time = this.time
    time += when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(): String {
    val currentime: Long = Date().time
    val time: Long = this.time
    val diff: Float = abs(currentime-time).toFloat() //все вычисления будем делать с Float, чтобы избежать ошибок округления
    val isPositive: Boolean = when((currentime-time).sign) {
        1 -> true
        else -> false
    }
    var result: String = ""
    if (diff <= SECOND) result="только что"
    else if (diff <= 45 * SECOND) result="${if(isPositive)"несколько секунд назад" else "через несколько секунд"}"
    else if (diff <= 75 * SECOND) result="${if(isPositive)"минуту назад" else "через минуту"}"
    else if (diff <= 45 * MINUTE) result=Utils.toMinuteString(diff/ MINUTE, isPositive)
    else if (diff <= 75 * MINUTE) result="${if(isPositive)"час назад" else "через час"}"
    else if (diff <= 22 * HOUR) result=Utils.toHoursString(diff/ HOUR, isPositive)
    else if (diff <= 26 * HOUR) result="${if(isPositive)"день назад" else "через день"}"
    else if (diff <= 22 * DAY) result=Utils.toDaysString(diff / DAY, isPositive)
    else if (diff > 360 * DAY) result="${if(isPositive)"более года назад" else "более чем через год"}"
    return result
}


enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}

fun TimeUnits.plural(number: Long):String{
    return when(this){
        TimeUnits.SECOND -> "$number "+Utils.toEndingSecond(number.toFloat())
        TimeUnits.MINUTE -> "$number "+Utils.toEndingMinute(number.toFloat())
        TimeUnits.HOUR -> "$number "+Utils.toEndingHours(number.toFloat())
        TimeUnits.DAY -> "$number "+Utils.toEndingDays(number.toFloat())
    }
}