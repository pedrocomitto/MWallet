package com.pedrocomitto.mwallet.service

import com.pedrocomitto.mwallet.domain.entity.AssetEntity
import com.pedrocomitto.mwallet.domain.enumeration.AssetCategoryEnum
import com.pedrocomitto.mwallet.domain.enumeration.BrokerEnum
import com.pedrocomitto.mwallet.domain.enumeration.CountryEnum
import com.pedrocomitto.mwallet.domain.enumeration.FinancialOperationEnum
import com.pedrocomitto.mwallet.exception.AssetNotFoundException
import com.pedrocomitto.mwallet.mapper.toEntity
import com.pedrocomitto.mwallet.mapper.toResponse
import com.pedrocomitto.mwallet.repository.AssetRepository
import com.pedrocomitto.mwallet.request.CreateAssetRequest
import com.pedrocomitto.mwallet.resolver.AssetPriceResolver
import com.pedrocomitto.mwallet.response.AssetResponse
import com.pedrocomitto.mwallet.specification.AssetSpecification
import com.pedrocomitto.mwallet.strategy.financialoperation.FinancialOperation
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class AssetService(
    private val assetRepository: AssetRepository,
    private val assetPriceResolver: AssetPriceResolver
) {

    @Transactional(readOnly = true)
    fun findByIdOrElseThrow(id: Long): AssetEntity =
        assetRepository.findById(id).orElseThrow { AssetNotFoundException() }

    @Transactional
    fun create(assetRequest: CreateAssetRequest) =
        assetRepository.save(assetRequest.toEntity())

    @Transactional(propagation = Propagation.MANDATORY)
    fun updateQuantity(assetEntity: AssetEntity, recordQuantity: Int, financialOperation: FinancialOperationEnum) {
        assetEntity.quantity = FinancialOperation.of(financialOperation).updateQuantity(assetEntity.quantity, recordQuantity)

        assetRepository.save(assetEntity)
    }

    @Transactional(readOnly = true)
    fun findAll(
        ticker: String?,
        broker: BrokerEnum?,
        category: AssetCategoryEnum?,
        country: CountryEnum?,
        active: Boolean
    ): List<AssetResponse> =
        assetRepository.findAll(AssetSpecification(ticker, broker, category, country, active))
            .toResponse()
            .apply { assetPriceResolver.calculate(this) }

}



