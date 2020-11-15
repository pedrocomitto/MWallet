package com.pedrocomitto.mwallet.domain.entity

import com.pedrocomitto.mwallet.domain.enumeration.FinancialOperationEnum
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "RECORDS")
data class RecordEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val financialOperation: FinancialOperationEnum,

    @ManyToOne
    val asset: AssetEntity,

    @Column(nullable = false)
    val quantity: Int,

    @Column(nullable = false)
    val price: BigDecimal,

    @Column(nullable = false)
    val date: LocalDate,

    @Column(nullable = false)
    val tax: BigDecimal,

    @Column(nullable = false)
    var value: BigDecimal = BigDecimal.ZERO
)