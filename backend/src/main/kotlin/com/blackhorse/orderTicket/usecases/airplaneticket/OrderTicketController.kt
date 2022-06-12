package com.blackhorse.airplaneTicket.usecases.bookTicket

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user-agreement/order")
class OrderTicketController {

    @Autowired
    lateinit var orderTicketService: OrderTicketService

    @GetMapping("")
    fun getTicketsBy(
        @RequestParam("company", required = false, defaultValue = "China Eastern Airlines") company: String,
        @RequestParam("airplaneType", required = false, defaultValue = "") airplaneType: String,
        @RequestParam("startTime", required = true) startTime: String,
        @RequestParam("arriveTime", required = true) arriveTime: String,
        @RequestParam("price", required = true) price: String,
        @RequestParam("locationFrom", required = true) locationFrom: String,
        @RequestParam("locationTo", required = true) locationTo: String,
    ): List<AirplaneInfo> {
        val queryParamDTO: QueryParamDTO =
            QueryParamDTO(company, airplaneType, startTime, arriveTime, price, locationFrom, locationTo)

        return orderTicketService.getTicketsBy(
            queryParamDTO
        )
    }

    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    fun bookTicket(
        queryParamDTO: QueryParamDTO
    ) = orderTicketService.bookTicket(queryParamDTO)
}
