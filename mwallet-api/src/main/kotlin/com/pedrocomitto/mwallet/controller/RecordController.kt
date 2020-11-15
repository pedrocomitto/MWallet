package com.pedrocomitto.mwallet.controller

import com.pedrocomitto.mwallet.request.CreateRecordRequest
import com.pedrocomitto.mwallet.service.RecordService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/assets/{assetId}/records")
class RecordController(
    private val recordService: RecordService
) {

    @GetMapping
    fun findAllByAssetId(@PathVariable assetId: Long) =
        recordService.findAllByAssetId(assetId)

    @PostMapping
    @CacheEvict("assets", allEntries = true)
    fun create(@PathVariable assetId: Long, @RequestBody recordRequest: CreateRecordRequest) {
        recordService.create(assetId, recordRequest)
    }

}