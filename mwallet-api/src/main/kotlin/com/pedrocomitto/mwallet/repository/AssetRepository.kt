package com.pedrocomitto.mwallet.repository

import com.pedrocomitto.mwallet.domain.entity.AssetEntity
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AssetRepository : JpaRepository<AssetEntity, Long> {

    fun findAll(specification: Specification<AssetEntity>): List<AssetEntity>
}