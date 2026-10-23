package codingdojo.exampleD

import java.math.BigDecimal


class ShoppingBasketFactory {
    fun getQuantity(itemName: String): Int {
        throw UnsupportedOperationException("Not implemented")
    }

    fun calculateTotal(): BigDecimal {
        throw UnsupportedOperationException("Not implemented")
    }

    companion object {
        fun fromJson(json: String): ShoppingBasketFactory {
            throw UnsupportedOperationException("Not implemented")
        }
    }
}
