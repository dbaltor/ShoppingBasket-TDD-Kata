package codingdojo.exampleA

import java.math.BigDecimal

data class BasketItem(val name: String, val price: BigDecimal) {
    init {
        throw UnsupportedOperationException("Not implemented")
    }
}
