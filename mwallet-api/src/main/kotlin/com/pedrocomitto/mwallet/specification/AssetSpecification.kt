package com.pedrocomitto.mwallet.specification

import com.pedrocomitto.mwallet.domain.entity.AssetEntity
import com.pedrocomitto.mwallet.domain.enumeration.AssetCategoryEnum
import com.pedrocomitto.mwallet.domain.enumeration.BrokerEnum
import com.pedrocomitto.mwallet.domain.enumeration.CountryEnum
import org.springframework.data.jpa.domain.Specification
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

class AssetSpecification(
    private val ticker: String?,
    private val broker: BrokerEnum?,
    private val category: AssetCategoryEnum?,
    private val country: CountryEnum?,
    private val active: Boolean

) : Specification<AssetEntity> {
    override fun toPredicate(root: Root<AssetEntity>, query: CriteriaQuery<*>, criteriaBuilder: CriteriaBuilder): Predicate? {
        val predicates = mutableListOf<Predicate>()

        ticker?.let {
            predicates.add(
                criteriaBuilder.equal(root.get<String>("ticker"), ticker)
            )
        }

        broker?.let {
            predicates.add(
                criteriaBuilder.equal(root.get<BrokerEnum>("broker"), broker)
            )
        }

        category?.let {
            predicates.add(
                criteriaBuilder.equal(root.get<AssetCategoryEnum>("category"), category)
            )
        }

        country?.let {
            predicates.add(
                criteriaBuilder.equal(root.get<CountryEnum>("country"), country)
            )
        }

        active.let {
            predicates.add(
                criteriaBuilder.equal(root.get<Boolean>("active"), active)
            )
        }

        return criteriaBuilder.and(*predicates.toTypedArray())
    }

}