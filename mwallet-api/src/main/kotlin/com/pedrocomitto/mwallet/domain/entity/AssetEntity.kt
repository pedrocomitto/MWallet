package com.pedrocomitto.mwallet.domain.entity

import com.pedrocomitto.mwallet.domain.enumeration.AssetCategoryEnum
import com.pedrocomitto.mwallet.domain.enumeration.BrokerEnum
import com.pedrocomitto.mwallet.domain.enumeration.CountryEnum
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "ASSETS")
data class AssetEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(unique = true, nullable = false)
    val ticker: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val broker: BrokerEnum,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val country: CountryEnum,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val category: AssetCategoryEnum,

    @Column(nullable = false)
    var quantity: Int = 0,

    @Column(nullable = false)
    val active: Boolean

)