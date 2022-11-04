package com.ace.soniceweather.repository

import com.ace.soniceweather.domain.Weather
import org.springframework.data.jpa.repository.JpaRepository

interface WeatherRepository : JpaRepository<Weather, Long> {
    fun findByDate(date: String): Weather
}