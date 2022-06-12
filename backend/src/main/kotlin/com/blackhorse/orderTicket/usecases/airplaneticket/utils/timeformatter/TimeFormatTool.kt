package com.blackhorse.airplaneTicket.utils.timeformatter

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TimeFormatTool {
    companion object {
        fun LocalDate.toISOFormattedString(): String = this.let {
            val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            return it.format(formatter)
        }

        fun LocalDateTime.toISOFormattedString(): String = this.let {
            val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
            return it.format(formatter)
        }
    }
}
