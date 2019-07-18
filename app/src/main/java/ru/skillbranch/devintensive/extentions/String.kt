package ru.skillbranch.devintensive.extentions

fun String.truncate(amount:Int = 16):String{
    var result = this.trim()
//    return if(this.trim().length > amount) {
//                if (this[amount-1] == ' ') this.removeRange(amount - 1, this.length)+"..."
//                else this.removeRange(amount, this.length)+"..."
//           }
//           else this.trim()
    return if(result.length > amount) {
        if (result[amount-1] == ' ') result.removeRange(amount - 1, result.length)+"..."
        else result.removeRange(amount, result.length)+"..."
    }
    else result.trim()
}

fun String.stripHtml():String? {
    var result: String? = Regex("""<.*?>|&[^а-яА-ЯёЁ\s]*?;""").replace(this, "")
    result = result?.let { Regex("""[\r\t\f ]{2,}""").replace(it, " ") }
    return result

}
