package codingdojo.exampleD

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
        val json = ""
        val basket = ShoppingBasketFactory.fromJson(json)

        assertEquals(0,
            basket.getQuantity("C"),
            "Quantity of item 'C' should be 0")
    }

    @Test
    fun `one item`() {
        val json = """
            {
                "items": [
                    {
                        "name": "A",
                        "price": 10.0,                        
                        "quantity": 1
                    }
                ]
            }
                    """
        val basket = ShoppingBasketFactory.fromJson(json)

        assertEquals(1,
            basket.getQuantity("A"),
            "Quantity of item 'A' should be 1")
    }

    @Test
    fun `two items A`() {
        val json = """
        {
            "items": [
                {
                    "name": "A",
                    "price": 10.0,
                    "quantity": 2
                }
            ]
        }
                """
        val basket = ShoppingBasketFactory.fromJson(json)

        assertEquals(2,
            basket.getQuantity("A"),
            "Quantity of item 'A' should be 2")
    }

    @Test
    fun `two items A and B`() {
        val json = """
        {
            "items": [
                {
                    "name": "A",
                    "price": 10.0,
                    "quantity": 1
                },
                {
                    "name": "B",
                    "price": 25.0,
                    "quantity": 1
                }
            ]
        }
                """
        val basket = ShoppingBasketFactory.fromJson(json)

        assertEquals(1,
            basket.getQuantity("A"),
            "Quantity of item 'A' should be 1")
    }

    @Test
    fun `empty basket total price 0`() {
        val json = ""
        val basket = ShoppingBasketFactory.fromJson(json)

        assertEquals(BigDecimal("0").toDouble(),
            basket.calculateTotal().toDouble(), 0.01)
    }

    @Test
    fun `item A costs 10 basket total price is 10`() {
        val json = """
            {
                "items": [
                    {
                        "name": "A",
                        "price": 10.0,                        
                        "quantity": 1
                    }
                ]
            }
                    """
        val basket = ShoppingBasketFactory.fromJson(json)

        assertEquals(BigDecimal("10").toDouble(),
            basket.calculateTotal().toDouble(), 0.01)
    }

    @Test
    fun `item E costs 250 basket total price is 225 with 10 percent discount`() {
        val json = """
            {
                "items": [
                    {
                        "name": "E",
                        "price": 250.0,                        
                        "quantity": 1
                    }
                ]
            }
                    """
        val basket = ShoppingBasketFactory.fromJson(json)

        assertEquals(BigDecimal("225").toDouble(),
            basket.calculateTotal().toDouble(), 0.01)
    }

    @Test
    fun `item D costs 160 basket total price is 152 with 5 percent discount`() {
        val json = """
            {
                "items": [
                    {
                        "name": "D",
                        "price": 160.0,                        
                        "quantity": 1
                    }
                ]
            }
                    """
        val basket = ShoppingBasketFactory.fromJson(json)

        assertEquals(BigDecimal("152").toDouble(),
            basket.calculateTotal().toDouble(), 0.01)
    }

    @Test
//    @Disabled
    fun `total over 100 gives five percent discount`() {
        val json = """
            {
                "items": [
                    {
                        "name": "A",
                        "price": 10.0,
                        "quantity": 5
                    },
                    {
                        "name": "B",
                        "price": 25.0,
                        "quantity": 2
                    },
                    {
                        "name": "C",
                        "price": 9.99,
                        "quantity": 6
                    }
                ]
            }
                    """
        val basket = ShoppingBasketFactory.fromJson(json)

        assertEquals(6, basket.getQuantity("C"))
        assertEquals(BigDecimal("151.94").toDouble(),
                basket.calculateTotal().toDouble(), 0.01)
    }
}
