package com.blackhorse.airplaneTicket.usecases.bookTicket

import com.blackhorse.airplaneTicket.usecases.bookTicket.bookTicket
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
interface AirplaneTicketRepository : PagingAndSortingRepository<AirplaneInfo, String> {

    @Query(
        value = """
        select  *
        from tickets
        where
            deal_Id in (:dealIds) and
            created_At between :startDate and :endDate and
            bookTicket_type = :bookTicketType and
            locked = false 
    """,
        nativeQuery = true
    )
    fun getTicketsBy(
        @Param("dealIds") dealIds: List<String>,
        @Param("queryParamDTO") queryParamDTO: QueryParamDTO,
        pageable: Pageable
    ): List<bookTicket>

}
