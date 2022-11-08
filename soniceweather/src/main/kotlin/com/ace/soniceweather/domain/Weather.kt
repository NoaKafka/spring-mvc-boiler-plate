package com.ace.soniceweather.domain

import javax.persistence.Cacheable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Weather(
    @Id
    val date: String,

    @Column
    val fcstValue: String,
)
