package com.blackhorse.airplaneTicket.usecases

import com.ninjasquad.springmockk.MockkBean
import com.blackhorse.blackhorse.config.security.PrincipalProvider
import io.mockk.every
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@ExtendWith(MockKExtension::class)
@AutoConfigureMockMvc
abstract class ControllerTestBase {

    @Autowired
    lateinit var webApplicationContext: WebApplicationContext

    protected lateinit var mockMvc: MockMvc

    @BeforeEach
    open fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
    }
}
