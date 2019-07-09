package ru.skillbranch.devintensive.extentions

import ru.skillbranch.devintensive.Utils.Utils
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView

fun User.toUserView(): UserView {

    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if (lastVisit == null) "Еще не разу не был" else if (isOnline) "online" else "Последний раз был ${lastVisit?.humanizeDiff()}"

        return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickName = nickName,
        initials = initials,
        status = status 
    )
}

