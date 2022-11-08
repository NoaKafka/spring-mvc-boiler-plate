package com.ace.soniceweather.controller

import com.ace.soniceweather.domain.Weather
import com.ace.soniceweather.dto.weather.WeatherResponse
import com.ace.soniceweather.service.WeatherService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Api(tags = ["날씨"])
@RestController
class WeatherController(
    private val weatherService: WeatherService,
) {
    @ApiOperation(value = "날짜로 날씨정보 조회")
    @GetMapping("/weather/{date}")
    fun getWeather(
        @ApiParam(value = "날짜정보 YYYYMMDD") @PathVariable date: String
    ): WeatherResponse {
        return WeatherResponse.of(weatherService.getWeather(date))
    }

    @ApiOperation(value = "날짜로 날씨정보 저장")
    @PostMapping("/weather")
    fun saveWeather(
        @ApiParam(value = "날짜정보 YYYYMMDD") @RequestBody weather: Weather
    ): WeatherResponse{
        return WeatherResponse.of(weatherService.saveWeather(weather.date, weather.fcstValue))
    }
}