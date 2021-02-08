package com.pedrocomitto.mwallet.repository

import com.pedrocomitto.mwallet.domain.entity.RecordEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RecordRepository : JpaRepository<RecordEntity, Long> {

    fun findAllByAssetId(assetId: Long): MutableList<RecordEntity>

}