package com.ace.soniceweather.controller

import com.ace.soniceweather.dto.weather.WeatherResponse
import com.ace.soniceweather.service.WeatherService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class WeatherController(
    private val weatherService: WeatherService,
) {
    @GetMapping("/weather/{date}")
    fun getWeather(@PathVariable date: String): WeatherResponse {
        return WeatherResponse.of(weatherService.getWeather(date))
    }
}