package codingdojo.exampleD

import java.math.BigDecimal
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BasketTest {

    @Test
    @Disabled
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
