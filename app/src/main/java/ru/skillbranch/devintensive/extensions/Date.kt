package ru.skillbranch.devintensive.extensions


import java.util.*
import java.lang.Math.abs
import java.text.SimpleDateFormat
import kotlin.math.sign

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits) : Date{
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

fun toEndingSecond(number: Float): String{
    val strnumber=number.toLong().toString()
    val lastdigit= strnumber.last()
    val prelastdigit: Char = if(strnumber.length>=2)
    {
        strnumber[strnumber.length-2]
        //strnumber.drop(strnumber.length-1).last()
    } else {
        '0'
    }
    return when(lastdigit){
        '1' -> if(prelastdigit=='1') "секунд" else "секунду"
        '2', '3', '4' -> if(prelastdigit=='1') "секунд" else "секунды"
        else -> "секунд"
    }
}

fun toEndingMinute(number: Float): String{
    val strnumber=number.toLong().toString()
    val lastdigit= strnumber.last()
    val prelastdigit: Char = if(strnumber.length>=2)
    {
        strnumber[strnumber.length-2]
        //strnumber.drop(strnumber.length-1).last()
    } else {
        '0'
    }
    return when(lastdigit){
        '1' -> if(prelastdigit=='1') "минут" else "минуту"
        '2', '3', '4' -> if(prelastdigit=='1') "минут" else "минуты"
        else -> "минут"
    }
}

fun toEndingHours(number: Float): String{
    val strnumber=number.toLong().toString()
    val lastdigit= strnumber.last()
    val prelastdigit: Char = if(strnumber.length>=2)
    {
        strnumber[strnumber.length-2]
        //strnumber.drop(strnumber.length-1).last()
    } else {
        '0'
    }
    return when(lastdigit){
        '1' -> if (prelastdigit=='1') "часов" else "час"
        '2', '3', '4' -> if (prelastdigit=='1') "часов" else "часа"
        else -> "часов"
    }
}

fun toEndingDays(number: Float): String{
    val strnumber=number.toLong().toString()
    val lastdigit= strnumber.last()
    val prelastdigit: Char = if(strnumber.length>=2)
    {
        strnumber[strnumber.length-2]
    } else {
        '0'
    }
    return when(lastdigit){
        '1' -> if (prelastdigit=='1') "дней" else "день"
        '2', '3', '4' -> if (prelastdigit=='1') "дней" else "дня"
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
    val result = if(isPositive) "$numberL ${toEndingDays(number)} назад"
    else "через $numberL ${toEndingDays(number)}"
    return result
}

fun Date.humanizeDiff(currDate: Date = Date()): String {
    val currentime: Long = currDate.time
    val time = this.time
    val diff: Float = abs(currentime-time).toFloat() //все вычисления будем делать с Float, чтобы избежать ошибок округления
    val isPositive: Boolean = when((currentime-time).sign) {
        1 -> true
        else -> false
    }
    var result: String = ""
    if (diff <= SECOND) result="только что"
    else if (diff <= 45 * SECOND) result="${if(isPositive)"несколько секунд назад" else "через несколько секунд"}"
    else if (diff <= 75 * SECOND) result="${if(isPositive)"минуту назад" else "через минуту"}"
    else if (diff <= 45 * MINUTE) result=toMinuteString(diff/ MINUTE, isPositive)
    else if (diff <= 75 * MINUTE) result="${if(isPositive)"час назад" else "через час"}"
    else if (diff <= 22 * HOUR) result=toHoursString(diff/ HOUR, isPositive)
    else if (diff <= 26 * HOUR) result="${if(isPositive)"день назад" else "через день"}"
    else if (diff <= 360 * DAY) result=toDaysString(diff / DAY, isPositive)
    else if (diff > 360 * DAY) result="${if(isPositive)"более года назад" else "более чем через год"}"
    return result
}


enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY;
    fun plural(number: Long):String{
        return when(this){
            TimeUnits.SECOND -> "$number "+ toEndingSecond(number.toFloat())
            TimeUnits.MINUTE -> "$number "+ toEndingMinute(number.toFloat())
            TimeUnits.HOUR -> "$number "+ toEndingHours(number.toFloat())
            TimeUnits.DAY -> "$number "+ toEndingDays(number.toFloat())
        }

    }





}