package codingdojo.exampleC

import java.math.BigDecimal

class ItemBuilder(name: String) {
    val item: Item = Item(name)

    fun withPrice(price: BigDecimal): ItemBuilder {
        item.price = price
        return this
    }

    fun withQuantity(quantity: Int): ItemBuilder {
        item.quantity = quantity
        return this
    }
    fun build(): Item  {
        return item
    }
}
