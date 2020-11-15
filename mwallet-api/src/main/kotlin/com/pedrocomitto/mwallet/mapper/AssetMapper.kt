package com.pedrocomitto.mwallet.mapper

import com.pedrocomitto.mwallet.domain.entity.AssetEntity
import com.pedrocomitto.mwallet.request.CreateAssetRequest
import com.pedrocomitto.mwallet.response.AssetResponse

fun CreateAssetRequest.toEntity() =
    AssetEntity(
        ticker = ticker,
        broker = broker,
        country = country,
        category = category,
        active = active
    )

fun AssetEntity.toResponse() =
    AssetResponse(
        id = id,
        ticker = ticker,
        broker = broker,
        country = country,
        category = category,
        quantity = quantity
    )

fun List<AssetEntity>.toResponse(): List<AssetResponse> =
    map { it.toResponse() }
