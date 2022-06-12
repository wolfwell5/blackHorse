package com.blackhorse.airplaneTicket.utils.timeformatter

import com.blackhorse.airplaneTicket.usecases.bookTicket.GO_LIVE_DATE
import java.time.Duration
import java.time.LocalDate
import java.time.LocalTime

fun isStartDateEarlierThanGoLiveDate(startDate: String): Boolean {
    val start = LocalDate.parse(startDate)
    val goLiveDate = LocalDate.parse(GO_LIVE_DATE)
    if (start.isBefore(goLiveDate)) {
        return true
    }
    return false
}

fun isEndDateLaterThanToday(endDate: String): Boolean {
    val end = LocalDate.parse(endDate)
    val today = LocalDate.now()
    if (end.isAfter(today)) {
        return true
    }
    return false
}

fun isStartDateLaterThanEndDate(startDate: String, endDate: String): Boolean {
    val start = LocalDate.parse(startDate)
    val end = LocalDate.parse(endDate)
    if (start.isAfter(end)) {
        return true
    }
    return false
}

const val HOUR = 23
const val MINUTE = 59
const val SECOND = 59

fun isPeriodBiggerThanSpecificDays(startDate: String, endDate: String, period: Int): Boolean {
    val start = LocalDate.parse(startDate).atStartOfDay()
    val end = LocalDate.parse(endDate).atTime(LocalTime.of(HOUR, MINUTE, SECOND))

//    this between api will not include the end day, so lack of 1 day
    val diffDays = Duration.between(start, end).toDays() + 1
    if (diffDays > period) {

        return true
    }
    return false
}
