package codingdojo.exampleB

import java.math.BigDecimal

class BasketAnalysis {

    companion object {
        fun getQuantity(basket: MutableMap<String, Map<String,Any>>, itemName: String): Int {
            return (basket[itemName]?.get("quantity") ?: 0) as Int
        }

        fun calculateTotal(basket: MutableMap<String, Map<String,Any>>): BigDecimal {
            val total = basket.values.sumOf {
                it["price"] as BigDecimal * (it["quantity"] as Int).toBigDecimal()
            }

            if (total > BigDecimal(200)) {
                return total - total * BigDecimal("0.1")
            }
            if (total > BigDecimal(100)) {
                return total - total * BigDecimal("0.05")
            }
            return total
        }
    }
}
