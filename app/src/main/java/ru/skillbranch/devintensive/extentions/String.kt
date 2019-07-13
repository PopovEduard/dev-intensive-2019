package ru.skillbranch.devintensive.extentions

fun String.truncate(amount:Int = 16):String{
    return if(this.trimEnd().length > amount) {
                if (this[amount-1] == ' ') this.removeRange(amount - 1, this.length)+"..."
                else this.removeRange(amount, this.length)+"..."
           }
           else this
}

fun String.stripHTML():String{
    var result: String = ""
    var count:Int = 0
    var bracket:Boolean = false

    for(ch in this){
        if(ch==' ' && !bracket) {
            count++
            if (count >= 2) {
                count = 1
                continue
            } else result += ch
        }
        else {
            count = 0
            if(ch=='<') {
                bracket = true
                continue
            } else {
                if (ch=='>') {
                    bracket=false
                    continue
                } else {
                    if(bracket) continue
                    else {
                        if(ch=='\'' || ch=='"') continue
                        else result += ch

                    }
                }
            }
        }
    }
    return result
}