package codingdojo.exampleA

import java.math.BigDecimal

class ShoppingBasket {

    val items: MutableMap<String, Pair<BasketItem, Int>> = mutableMapOf()

    fun add(item: BasketItem, quantity: Int) {
        items[item.name] = Pair(item, quantity)
    }

    fun getQuantity(itemName: String): Int {
        return items[itemName]?.second ?: 0
    }

    fun calculateTotal(): BigDecimal {
        val total = items.values.sumOf { it.first.price * it.second.toBigDecimal() }
        if (total > BigDecimal(200)) {
            return total - total * BigDecimal("0.1")
        }
        if (total > BigDecimal(100)) {
            return total - total * BigDecimal("0.05")
        }
        return total
    }
}
