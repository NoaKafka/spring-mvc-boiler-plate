package com.ace.soniceweather.dto.weather

import com.ace.soniceweather.domain.Weather

data class WeatherResponse(val date: String, val fcstValue: String){

    companion object{
        fun of(weather: Weather): WeatherResponse{
            return WeatherResponse(weather.date, weather.fcstValue)
        }
    }
}
