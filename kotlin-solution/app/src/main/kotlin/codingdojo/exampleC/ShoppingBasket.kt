package codingdojo.exampleC

import java.math.BigDecimal

class ShoppingBasket {

    val items = mutableMapOf<String, Item>()

    fun addItem(item: Item) {
        items[item.name] = item
    }

    fun getQuantity(itemName: String): Int {
        return items[itemName]?.quantity ?: 0

    }

    fun totalPrice(): BigDecimal {
        if (items.isEmpty()) return BigDecimal.ZERO
        val total = items.values.sumOf { it.quantity.toBigDecimal() * it.price }

        if (total > BigDecimal(200)) {
            return total - total * BigDecimal("0.1")
        }
        if (total > BigDecimal(100)) {
            return total - total * BigDecimal("0.05")
        }
        return total
    }
}
