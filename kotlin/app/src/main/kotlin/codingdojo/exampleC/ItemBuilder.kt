package codingdojo.exampleC

import java.math.BigDecimal

class ItemBuilder(name: String) {
    init {
        throw UnsupportedOperationException("Not implemented")
    }

    fun withPrice(price: BigDecimal): ItemBuilder {
        throw UnsupportedOperationException("Not implemented")
    }

    fun  withQuantity(quantity: Int): ItemBuilder {
        throw UnsupportedOperationException("Not implemented")
    }
    fun build(): Item  {
        throw UnsupportedOperationException("Not implemented")
    }
}
