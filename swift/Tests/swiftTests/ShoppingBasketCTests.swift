import Testing
import Foundation
@testable import swift

/*
 * Implement tests in this order:
 *
 * Empty basket - basket contains no items
 * one item "A" - basket contains 1 item "A"
 * two items "A" - basket contains 2 items "A"
 * two items, "A" and "B" - basket contains 1 item "A"
 * Empty basket - total price 0
 * "A" costs $10, basket contains one "A" - total $10
 * "A" costs $10, basket contains two "A" - total $20
 * "D" costs $160, basket contains one "D" - total $152 (5% discount)
 * "E" costs $250, basket contains one "E" - total $225 (10% discount)
 * Then remove the "Ignore" marking on the test that's here and hopefully it will pass!
 */

struct ShoppingBasketCTests {

    @Test(.enabled(if: false))   
    func test_total_over_100_gives_five_percent_discount() throws {
        
        let basket = ShoppingBasketBuilder()
            .addItem(item: ItemBuilder("A").withPrice(10.0).withQuantity(5).build())
            .addItem(item: ItemBuilder("B").withPrice(25.0).withQuantity(2).build())
            .addItem(item: ItemBuilder("C").withPrice(9.99).withQuantity(6).build())
            .build()


        #expect(
            basket.getQuantity(of: "C") == 6,
            "Quantity of item 'C' should be 6"
        )
        
        #expect(
            basket.calculateTotal().isApproximatelyEqual(to: 151.94, tolerance: 0.01),
            "Total should be approximately 151.94"
        )
    }
}


