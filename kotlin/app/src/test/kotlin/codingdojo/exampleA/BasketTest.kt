package codingdojo.exampleA

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
        val basket = ShoppingBasket()
        val itemA = BasketItem("A", BigDecimal(10))
        val itemB = BasketItem("B", BigDecimal(25))
        val itemC = BasketItem("C", BigDecimal("9.99"))
        basket.add(itemA, 5)
        basket.add(itemB, 2)
        basket.add(itemC, 6)
        assertEquals(6, basket.getQuantity("C"))
        assertEquals(BigDecimal("151.94").toDouble(),
                basket.calculateTotal().toDouble(), 0.01)
    }
}
