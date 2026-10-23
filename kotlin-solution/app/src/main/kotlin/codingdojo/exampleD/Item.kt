package codingdojo.exampleD

import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
data class Item(
    val name: String,
    val quantity: Int,
    @Serializable(with = BigDecimalAsDoubleSerializer::class) val price: BigDecimal)
