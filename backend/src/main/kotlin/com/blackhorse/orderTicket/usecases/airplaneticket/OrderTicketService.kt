package com.blackhorse.airplaneTicket.usecases.bookTicket

import com.blackhorse.airplaneTicket.usecases.bookTicket.AirplaneInfo
import com.blackhorse.airplaneTicket.usecases.bookTicket.bookTicketRepository
import com.blackhorse.airplaneTicket.usecases.bookTicket.QueryParamDTO
import com.google.gson.Gson
import com.blackhorse.airplaneTicket.clients.orderstatus.blackhorseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.UUID
import javax.transaction.Transactional

@Service
class OrderTicketService {

    @Autowired
    lateinit var airplaneTicketRepository: AirplaneTicketRepository

    fun getTicketsBy(queryParamDTO: QueryParamDTO): List<AirplaneInfo> {
        val sortColumn = "created_at"
        val dealIds = listOf("a","b")

        val bookTickets = airplaneTicketRepository.getTicketsBy(
            dealIds,
            queryParamDTO
        )

        return listOf()
    }

}
