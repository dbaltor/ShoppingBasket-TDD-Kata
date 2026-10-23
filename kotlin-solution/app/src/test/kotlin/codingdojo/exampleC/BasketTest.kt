package codingdojo.exampleC

import java.math.BigDecimal
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/*
 * Implement tests in this order:
 *
 * x Empty basket - basket contains no items
 * x one item "A" - basket contains 1 item "A"
 * x two items "A" - basket contains 2 items "A"
 * x two items, "A" and "B" - basket contains 1 item "A"
 * x Empty basket - total price 0
 * x "A" costs $10, basket contains one "A" - total $10
 * x "D" costs $160, basket contains one "D" - total $152 (5% discount)
 * x "E" costs $250, basket contains one "E" - total $225 (10% discount)
 * Then remove the "Disabled" marking on the test that's here and hopefully it will pass!
 */
class BasketTest {

    @Test
    fun `empty basket contains nothing`() {
        val basket = ShoppingBasketBuilder()
            .build()
        assertEquals(
            0,
            basket.getQuantity("C"),
            "Quantity of item 'C' should be 1"
        )
    }

    @Test
    fun `one item`() {
        val basket = ShoppingBasketBuilder()
            .addItem(ItemBuilder("A").withQuantity(1).build())
            .build()
        assertEquals(
            1,
            basket.getQuantity("A"),
            "Quantity of item 'A' should be 1"
            )
    }

    @Test
    fun `two items A`() {
        val basket = ShoppingBasketBuilder()
            .addItem(ItemBuilder("A").withQuantity(2).build())
            .build()
        assertEquals(
            2,
            basket.getQuantity("A"),
            "Quantity of item 'A' should be 2"
        )
    }

    @Test
    fun `two items A and B`() {
        val basket = ShoppingBasketBuilder()
            .addItem(ItemBuilder("A").withQuantity(1).build())
            .addItem(ItemBuilder("B").withQuantity(1).build())
            .build()
        assertEquals(
            1,
            basket.getQuantity("A"),
            "Quantity of item 'A' should be 1"
        )
    }

    @Test
    fun `empty basket total price 0`() {
        val basket = ShoppingBasketBuilder()
            .build()

        assertEquals(BigDecimal(0).toDouble(),
            basket.totalPrice().toDouble(),
            0.01,
            "Basket total price should be 0")
    }

    @Test
    fun `item A costs 10 basket total price is 10`() {
        val basket = ShoppingBasketBuilder()
            .addItem(ItemBuilder("A").withPrice(BigDecimal("10.0")).withQuantity(1).build())
            .build()

        assertEquals(BigDecimal("10.0").toDouble(),
            basket.totalPrice().toDouble(),
            0.01,
            "Basket total price should be 10.0")
    }

    @Test
    fun `item D costs 160 basket total price is 152 with 5 percent discount`() {
        val basket = ShoppingBasketBuilder()
            .addItem(ItemBuilder("D").withPrice(BigDecimal("160.0")).withQuantity(1).build())
            .build()

        assertEquals(BigDecimal("152.0").toDouble(),
            basket.totalPrice().toDouble(),
            0.01,
            "Basket total price should be 152.0")
    }

    @Test
    fun `item E costs 250 basket total price is 225 with 10 percent discount`() {
        val basket = ShoppingBasketBuilder()
            .addItem(ItemBuilder("D").withPrice(BigDecimal("250.0")).withQuantity(1).build())
            .build()

        assertEquals(BigDecimal("225.0").toDouble(),
            basket.totalPrice().toDouble(),
            0.01,
            "Basket total price should be 225.0")
    }
    @Test
//    @Disabled
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
