package com.ace.soniceweather

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class SoniceweatherApplication

fun main(args: Array<String>) {
	runApplication<SoniceweatherApplication>(*args)
}
