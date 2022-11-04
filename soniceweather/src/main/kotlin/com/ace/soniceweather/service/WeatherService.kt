package com.ace.soniceweather.service

import com.ace.soniceweather.domain.Weather
import com.ace.soniceweather.dto.weather.WeatherResponse
import com.ace.soniceweather.repository.WeatherRepository
import org.springframework.stereotype.Service

@Service
class WeatherService(
    private val weatherRepository: WeatherRepository
) {
    fun getWeather(date: String): Weather {
        return weatherRepository.findByDate(date)
    }

    fun saveWeather(date: String, fcstValue: String): WeatherResponse{
        return WeatherResponse.of(weatherRepository.save(Weather(date, fcstValue)))
    }
}