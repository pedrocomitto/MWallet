package com.pedrocomitto.mwallet.controller

import com.pedrocomitto.mwallet.domain.enumeration.AssetCategoryEnum
import com.pedrocomitto.mwallet.domain.enumeration.BrokerEnum
import com.pedrocomitto.mwallet.domain.enumeration.CountryEnum
import com.pedrocomitto.mwallet.request.CreateAssetRequest
import com.pedrocomitto.mwallet.service.AssetService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/assets")
class AssetController(
    private val assetService: AssetService
) {

    @GetMapping
    @Cacheable("assets", condition = "#cache")
    fun findAll(
        @RequestParam(required = false, defaultValue = "true") cache: Boolean,
        @RequestParam(required = false) ticker: String?,
        @RequestParam(required = false) broker: BrokerEnum?,
        @RequestParam(required = false) category: AssetCategoryEnum?,
        @RequestParam(required = false) country: CountryEnum?,
        @RequestParam(required = false, defaultValue = "true") active: Boolean
    ) =
        assetService.findAll(ticker, broker, category, country, active).also { println("entrei no metodo") }

    @PostMapping
    @CacheEvict("assets", allEntries = true)
    fun create(@RequestBody assetRequest: CreateAssetRequest) {
        assetService.create(assetRequest)
    }

}