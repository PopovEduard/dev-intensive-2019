package ru.skillbranch.devintensive.extentions

fun String.truncate(amount:Int = 16):String{
    return if(this.trimEnd().length > amount) {
                if (this[amount-1] == ' ') this.removeRange(amount - 1, this.length)+"..."
                else this.removeRange(amount, this.length)+"..."
           }
           else this
}