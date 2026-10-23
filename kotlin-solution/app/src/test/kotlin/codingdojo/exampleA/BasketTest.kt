package codingdojo.exampleA

import kotlin.test.assertEquals


import java.math.BigDecimal
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

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
 * x Then remove the "Disabled" marking on the test that's here and hopefully it will pass!
 */
class BasketTest {

    @Test
    fun `empty basket contains nothing`() {
        val basket = ShoppingBasket()

        assertEquals(0,
            basket.getQuantity("A"),
            "Quantity of item 'A' should be 0"
        )
    }

    @Test
    fun `one item`() {
        val basket = ShoppingBasket()
        val itemA = BasketItem("A", BigDecimal(10))

        basket.add(itemA, 1)

        assertEquals(1,
            basket.getQuantity("A"),
            "Quantity of item 'A' should be 1"
        )
    }

    @Test
    fun `two items A`() {
        val basket = ShoppingBasket()
        val itemA = BasketItem("A", BigDecimal(10))

        basket.add(itemA, 2)

        assertEquals(2,
            basket.getQuantity("A"),
            "Quantity of item 'A' should be 2"
        )
    }

    @Test
    fun `two items A and B`() {
        val basket = ShoppingBasket()
        val itemA = BasketItem("A", BigDecimal(10))
        val itemB = BasketItem("B", BigDecimal(20))

        basket.add(itemA, 1)
        basket.add(itemB, 1)

        assertEquals(1,
            basket.getQuantity("A"),
            "Quantity of item 'A' should be 1"
        )
        assertEquals(1,
            basket.getQuantity("B"),
            "Quantity of item 'B' should be 1"
        )
    }

    @Test
    fun `empty basket total price 0`() {
        val basket = ShoppingBasket()

        assertEquals(BigDecimal(0).toDouble(),
            basket.calculateTotal().toDouble(),
            "Basket total price should be 0")
    }

    @Test
    fun `item A costs 10 basket total price is 10`() {
        val basket = ShoppingBasket()
        val itemA = BasketItem("A", BigDecimal(10))

        basket.add(itemA, 1)

        assertEquals(BigDecimal(10).toDouble(),
            basket.calculateTotal().toDouble(),
            "Basket total price should be 10.0")
    }

    @Test
    fun `item D costs 160 basket total price is 152 with 5 percent discount`() {
        val basket = ShoppingBasket()
        val itemD = BasketItem("D", BigDecimal(160))

        basket.add(itemD, 1)

        assertEquals(BigDecimal(152).toDouble(),
            basket.calculateTotal().toDouble(),
            "Basket total price should be 152.0")
    }

    @Test
    fun `item E costs 250 basket total price is 225 with 10 percent discount`() {
        val basket = ShoppingBasket()
        val itemE = BasketItem("E", BigDecimal(250))

        basket.add(itemE, 1)

        assertEquals(BigDecimal(225).toDouble(),
            basket.calculateTotal().toDouble(),
            "Basket total price should be 225.0")
    }


    @Test
    //    @Disabled
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
