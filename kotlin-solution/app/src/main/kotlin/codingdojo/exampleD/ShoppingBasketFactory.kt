package codingdojo.exampleD

import java.math.BigDecimal
import kotlinx.serialization.json.Json

class ShoppingBasketFactory private constructor(val itemsList: ItemsList) {

    fun getQuantity(itemName: String): Int {
        return itemsList.items.find { it.name == itemName }?.quantity ?: 0
    }

    fun calculateTotal(): BigDecimal {
//        val total = itemsList.items.fold(BigDecimal.ZERO) { acc, item -> acc + item.price * item.quantity.toBigDecimal() }
        val total = itemsList.items.sumOf { it.price * it.quantity.toBigDecimal()}
        if (total > BigDecimal(200)) {
            return total - total * BigDecimal("0.1")
        }
        if (total > BigDecimal(100)) {
            return total - total * BigDecimal("0.05")
        }
        return total
    }

    companion object {
        fun fromJson(json: String): ShoppingBasketFactory {
            if (json.isEmpty()) {
                return ShoppingBasketFactory(ItemsList(listOf()))
            }

            val itemsList = Json.decodeFromString<ItemsList>(json)
            return ShoppingBasketFactory(itemsList)
        }
    }
}

