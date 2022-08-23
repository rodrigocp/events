package br.com.rcp.domain.models

import java.math.BigDecimal

data class Event(
    val id          : Long,
    val title       : String,
    val description : String,
    val image       : String,
    val date        : Long,
    val price       : BigDecimal,
    val latitude    : BigDecimal,
    val longitude   : BigDecimal
)