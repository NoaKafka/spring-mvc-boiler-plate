package com.ace.soniceweather.dto.weather

import com.ace.soniceweather.domain.Weather

data class WeatherDTO(var date: String, var fcstValue: String){

    companion object {
        fun of(weather: Weather): WeatherDTO{
            return WeatherDTO(weather.date, weather.fcstValue)
        }
    }
}

