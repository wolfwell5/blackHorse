package com.blackhorse.airplaneTicket.usecases.bookTicket


data class AirplaneOrderDTO(
    val personInfo: PersonInfo? = null,
    val airplaneInfo: AirplaneInfo? = null,
    val businessCard: BusinessCard? = null,
)

data class PersonInfo(
    val name: String? = null,
    val IDNumber: String? = null,
    val phone: String? = null,
    val age: String? = null,
)

class AirplaneInfo(
    val company: String? = null,
    val airplaneId: String? = null,
    val airplaneType: String? = null,
    val startTime: String? = null,
    val arriveTime: String? = null,
    val price: String? = null,
    val locationFrom: String? = null,
    val locationTo: String? = null,
)

class BusinessCard(
    val id: String? = null,
    val expiredDate: String? = null,
)

data class QueryParamDTO(
    val company: String? = null,
    val airplaneType: String? = null,
    val startTime: String? = null,
    val arriveTime: String? = null,
    val price: String? = null,
    val locationFrom: String? = null,
    val locationTo: String? = null,
)
