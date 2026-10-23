package codingdojo.exampleB

import kotlin.test.assertEquals


import java.math.BigDecimal
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

/*
 * Implement tests in this order:
 *
 * Empty basket - basket contains no items
 * one item "A" - basket contains 1 item "A"
 * two items "A" - basket contains 2 items "A"
 * two items, "A" and "B" - basket contains 1 item "A"
 * Empty basket - total price 0
 * "A" costs $10, basket contains one "A" - total $10
 * "D" costs $160, basket contains one "D" - total $152 (5% discount)
 * "E" costs $250, basket contains one "E" - total $225 (10% discount)
 * Then remove the "Disabled" marking on the test that's here and hopefully it will pass!
 */
class BasketTest {
    @Test
    @Disabled
    fun `total over 100 gives five percent discount`() {
        val basket = mutableMapOf<String, Map<String,Any>>()
        val itemA = mapOf(
                "price" to BigDecimal("10.0"),
                "quantity" to  5.0
        )
        val itemB = mapOf(
                "price" to BigDecimal("25.0"),
                "quantity" to  2.0
        )
        val itemC = mapOf(
                "price" to BigDecimal("9.99"),
                "quantity" to  6.0
        )
        basket["A"] = itemA
        basket["B"] = itemB
        basket["C"] = itemC
        assertEquals(6, BasketAnalysis.getQuantity(basket, "C"))
        assertEquals( BigDecimal("151.94").toDouble(),
                BasketAnalysis.calculateTotal(basket).toDouble(), 0.01)
    }

}
