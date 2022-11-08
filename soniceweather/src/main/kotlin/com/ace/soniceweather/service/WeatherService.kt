package com.ace.soniceweather.service

import com.ace.soniceweather.domain.Weather
import com.ace.soniceweather.dto.weather.WeatherDTO
import com.ace.soniceweather.dto.weather.WeatherResponse
import com.ace.soniceweather.repository.WeatherRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class WeatherService(
    private val weatherRepository: WeatherRepository
) {

    @Cacheable(value=["simpleCache"], key = "#date")
    fun getWeather(date: String): WeatherDTO {
        println("no cache")
        return WeatherDTO.of(weatherRepository.findByDate(date))
    }

    fun saveWeather(date: String, fcstValue: String): WeatherDTO{
        return WeatherDTO.of(weatherRepository.save(Weather(date, fcstValue)))
    }
}