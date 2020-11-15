package com.pedrocomitto.mwallet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableCaching
@EnableFeignClients
@SpringBootApplication
class MwalletApplication

fun main(args: Array<String>) {
	runApplication<MwalletApplication>(*args)
}
