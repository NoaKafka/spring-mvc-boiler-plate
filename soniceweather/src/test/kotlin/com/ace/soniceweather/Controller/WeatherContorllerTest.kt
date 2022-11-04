package com.ace.soniceweather.Controller

import com.ace.soniceweather.domain.Weather
import com.ace.soniceweather.service.WeatherService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class WeatherContorllerTest @Autowired constructor(
    private val weatherService: WeatherService,
) {

    @Test
    @DisplayName("saveWeather")
    fun saveWeather(){
        //given
        val weather = Weather("20221104", "Good")
        //when
        val result = weatherService.saveWeather(weather.date, weather.fcstValue)
        //then
        assertThat(result.date).isEqualTo("20221104")
    }

    @Test
    @DisplayName("getWeather")
    fun getWeather(){
        //given
        val weather = Weather("20221104", "Good")
        weatherService.saveWeather(weather.date, weather.fcstValue)
        //when
        val result = weatherService.getWeather(weather.date)
        //then
        assertThat(result.date).isEqualTo("20221104")
    }

}