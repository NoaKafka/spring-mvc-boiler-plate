package com.ace.soniceweather.Service

import com.ace.soniceweather.domain.Weather
import com.ace.soniceweather.repository.WeatherRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class WeatherServiceTest @Autowired constructor(
    private val weatherRepository: WeatherRepository
    ) {

    @Test
    @DisplayName("save weather")
    fun saveWeather(){
        //given
        val weather = Weather("20221104", "Good")
        //when
        val result = weatherRepository.save(weather)
        //then
        assertThat(result.date).isEqualTo("20221104")
    }

    @Test
    @DisplayName("get weather")
    fun getWeather(){
        //given
        val weather = Weather("20221104", "Good")
        weatherRepository.save(weather)
        //when
        val result = weatherRepository.findByDate(weather.date)
        //then
        assertThat(result.date).isEqualTo("20221104")
    }
}