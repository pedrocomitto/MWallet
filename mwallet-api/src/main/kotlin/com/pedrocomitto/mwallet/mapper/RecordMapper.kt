package com.pedrocomitto.mwallet.mapper

import com.pedrocomitto.mwallet.domain.entity.AssetEntity
import com.pedrocomitto.mwallet.domain.entity.RecordEntity
import com.pedrocomitto.mwallet.request.CreateRecordRequest
import com.pedrocomitto.mwallet.response.RecordResponse

fun CreateRecordRequest.toEntity(asset: AssetEntity) =
    RecordEntity(
        financialOperation = financialOperation,
        quantity = quantity,
        price = price,
        date = date,
        tax = tax,
        asset = asset
    )

fun RecordEntity.toResponse() =
    RecordResponse(
        id = id,
        financialOperation = financialOperation,
        asset = asset.ticker,
        quantity = quantity,
        price = price,
        date = date,
        tax = tax,
        value = value
    )

fun MutableList<RecordEntity>.toResponse() =
    map { it.toResponse() }