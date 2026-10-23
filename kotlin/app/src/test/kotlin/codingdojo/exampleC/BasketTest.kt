package codingdojo.exampleC

import java.math.BigDecimal
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

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
        val basket = ShoppingBasketBuilder()
                .addItem(ItemBuilder("A").withPrice(BigDecimal("10.0")).withQuantity(5).build())
                .addItem(ItemBuilder("B").withPrice(BigDecimal("25.0")).withQuantity(2).build())
                .addItem(ItemBuilder("C").withPrice(BigDecimal("9.99")).withQuantity(6).build())
                .build()
        assertEquals(6, basket.getQuantity("C"))
        assertEquals(BigDecimal("151.94").toDouble(),
            basket.totalPrice().toDouble(), 0.01)

    }
}
