package com.pedrocomitto.mwallet.service

import com.pedrocomitto.mwallet.domain.entity.RecordEntity
import com.pedrocomitto.mwallet.mapper.toEntity
import com.pedrocomitto.mwallet.mapper.toResponse
import com.pedrocomitto.mwallet.repository.RecordRepository
import com.pedrocomitto.mwallet.request.CreateRecordRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Service
class RecordService(
    private val recordRepository: RecordRepository,
    private val assetService: AssetService
) {

    @Transactional
    fun create(assetId: Long, recordRequest: CreateRecordRequest): RecordEntity {
        val assetEntity = assetService.findByIdOrElseThrow(assetId)

        val recordEntity = recordRequest.toEntity(assetEntity)
            .apply { calculateTotalValue() }
            .let { recordRepository.save(it) }

        assetService.updateQuantity(assetEntity, recordEntity.quantity, recordEntity.financialOperation)

        return recordEntity
    }

    @Transactional(readOnly = true)
    fun findAllByAssetId(assetId: Long) =
        recordRepository.findAllByAssetId(assetId).toResponse()


    private fun RecordEntity.calculateTotalValue() {
        value = price.multiply(BigDecimal(quantity)).plus(tax)
    }

}