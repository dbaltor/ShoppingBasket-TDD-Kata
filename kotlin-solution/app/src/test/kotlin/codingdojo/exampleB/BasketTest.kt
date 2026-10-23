package codingdojo.exampleB

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
        val basket = mutableMapOf<String, Map<String,Any>>()

        assertEquals(
            0,
            BasketAnalysis.getQuantity(basket,"A"),
            "Quantity of item 'A' should be 0"
            )
    }

    @Test
    fun `one item`() {
        val basket = mutableMapOf<String, Map<String,Any>>()
        val itemA = mapOf(
            "quantity" to 1
        )
        basket["A"] = itemA

        assertEquals(
            1,
            BasketAnalysis.getQuantity(basket,"A"),
            "Quantity of item 'A' should be 1"
        )
    }

    @Test
    fun `two items A`() {
        val basket = mutableMapOf<String, Map<String,Any>>()
        val itemA = mapOf(
            "quantity" to 1
        )
        val itemB = mapOf(
            "quantity" to 1
        )
        basket["A"] = itemA
        basket["B"] = itemB

        assertEquals(
            1,
            BasketAnalysis.getQuantity(basket,"A"),
            "Quantity of item 'A' should be 1"
        )
    }

    @Test
    fun `two items A and B`() {
        val basket = mutableMapOf<String, Map<String,Any>>()
        val itemA = mapOf(
            "quantity" to 2
        )
        basket["A"] = itemA

        assertEquals(
            2,
            BasketAnalysis.getQuantity(basket,"A"),
            "Quantity of item 'A' should be 2"
        )
    }

    @Test
    fun `empty basket total price 0`() {
        val basket = mutableMapOf<String, Map<String,Any>>()

        assertEquals(BigDecimal(0).toDouble(),
            BasketAnalysis.calculateTotal(basket).toDouble(),
            "Basket total price should be 0")
    }

    @Test
    fun `item A costs 10 basket total price is 10`() {
        val basket = mutableMapOf<String, Map<String,Any>>()
        val itemA = mapOf(
            "price" to BigDecimal("10.0"),
            "quantity" to 1
        )
        basket["A"] = itemA

        assertEquals(BigDecimal("10.0").toDouble(),
            BasketAnalysis.calculateTotal(basket).toDouble(),
            "Basket total price should be 10.0")
    }

    @Test
    fun `item D costs 160 basket total price is 152 with 5 percent discount`() {
        val basket = mutableMapOf<String, Map<String,Any>>()
        val itemD = mapOf(
            "price" to BigDecimal("160.0"),
            "quantity" to 1
        )
        basket["D"] = itemD

        assertEquals(BigDecimal("152.0").toDouble(),
            BasketAnalysis.calculateTotal(basket).toDouble(),
            "Basket total price should be 152.0")
    }

    @Test
    fun `item E costs 250 basket total price is 225 with 10 percent discount`() {
        val basket = mutableMapOf<String, Map<String,Any>>()
        val itemD = mapOf(
            "price" to BigDecimal("250.0"),
            "quantity" to 1
        )
        basket["D"] = itemD

        assertEquals(BigDecimal("225.0").toDouble(),
            BasketAnalysis.calculateTotal(basket).toDouble(),
            "Basket total price should be 225.0")
    }

    @Test
//    @Disabled
    fun `total over 100 gives five percent discount`() {
        val basket = mutableMapOf<String, Map<String,Any>>()
        val itemA = mapOf(
                "price" to BigDecimal("10.0"),
                "quantity" to 5
        )
        val itemB = mapOf(
                "price" to BigDecimal("25.0"),
                "quantity" to 2
        )
        val itemC = mapOf(
                "price" to BigDecimal("9.99"),
                "quantity" to 6
        )
        basket["A"] = itemA
        basket["B"] = itemB
        basket["C"] = itemC

        assertEquals(6, BasketAnalysis.getQuantity(basket, "C"))
        assertEquals( BigDecimal("151.94").toDouble(),
                BasketAnalysis.calculateTotal(basket).toDouble(), 0.01)
    }

}
