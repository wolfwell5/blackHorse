package com.blackhorse.airplaneTicket.usecases.bookTicket

import com.google.gson.Gson
import com.ninjasquad.springmockk.MockkBean
import com.blackhorse.airplaneTicket.clients.orderstatus.blackhorseImage
import com.blackhorse.airplaneTicket.usecases.ControllerTestBase
import com.blackhorse.airplaneTicket.usecases.deal.Deal
import com.blackhorse.airplaneTicket.usecases.bookTicket.exceptions.NobookTicketException
import com.blackhorse.airplaneTicket.utils.timeformatter.TimeFormatTool.Companion.toISOFormattedString
import com.blackhorse.blackhorse.config.security.JwtIncomingRequestFilter.Companion.X_JWT_PAYLOAD
import com.blackhorse.blackhorse.config.security.TestAuthUtils
import io.mockk.Runs
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.just
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.util.UUID

@WebMvcTest(OrderTicketController::class)
internal class OrderTicketControllerTest : ControllerTestBase() {

    @MockkBean
    lateinit var orderTicketService: OrderTicketService

    private val dealId = UUID.randomUUID()
    private val orderNumber = "some-order-number"
    private val bookTicket = bookTicket(
        id = UUID.randomUUID().toString(),
        bookTicketType = bookTicketType.blackhorse,
        dealId = dealId.toString(),
        orderNumber = orderNumber,
        createdAt = LocalDateTime.of(2021, Month.MAY, 1, 0, 0, 0),
         = true
    )

    @BeforeEach
    override fun setUp() {
        super.setUp()
        val mockedNow: LocalDateTime = LocalDateTime.of(2021, 9, 23, 0, 0)
        val mockedToday = LocalDate.of(2022, 1, 25)
        mockkStatic(LocalDateTime::class)
        mockkStatic(LocalDate::class)
        every { LocalDateTime.now() }.returns(mockedNow)
        every { LocalDate.now() }.returns(mockedToday)
    }

    @AfterEach
    internal fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `should get bookTickets `() {
        val expectedResponseBody = ""

        val bookTicket = mapOf(
            bookTicketType.blackhorse.jsonName to Summary(3)
        )

        every { orderTicketService.getbookTicketsBy() }
            .returns(bookTicket)

        this.mockMvc
            .perform(
                MockMvcRequestBuilders
                    .get("/user-aggreement/bookTickets/")
                    .header(X_JWT_PAYLOAD, jwtPayload)
            )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().json(expectedResponseBody))
    }

    @Test
    fun `should respond 204 if there is no  target delivery date changed bookTicket of the given order`() {
        val dealId = UUID.randomUUID()
        every { orderTicketService.getLatestblackhorsebookTicketOf(dealId) }
            .throws(NobookTicketException())
        this.mockMvc
            .perform(
                MockMvcRequestBuilders
                    .get("/bookTickets")
                    .header(X_JWT_PAYLOAD, jwtPayload)
            )
            .andExpect(MockMvcResultMatchers.status().isNoContent)
    }

}
