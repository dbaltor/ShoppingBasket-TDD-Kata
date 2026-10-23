import Testing
import Foundation

@testable import swift

/*
 * Implement tests in this order:
 *
 * Empty basket - basket contains no items
 * one item "A" - basket contains 1 item "A"
 * two items "A" at once - basket contains 2 items "A"
 * two items, "A" and "B" - basket contains 1 item "A"
 * Empty basket - total price 0
 * "A" costs $10, basket contains one "A" - total $10
 * "A" costs $10, basket contains two "A" - total $20
 * "D" costs $160, basket contains one "D" - total $152 (5% discount)
 * "E" costs $250, basket contains one "E" - total $225 (10% discount)
 * Then remove the "Ignore" marking on the test that's here and hopefully it will pass!
 */

struct ShoppingBasketATests {

    @Test(.enabled(if: false))
    func test_total_over_100_gives_five_percent_discount() throws {
        
        let basket = ShoppingBasketA()
        
        let itemA = BasketItem(name: "A", price: 10.0)
        let itemB = BasketItem(name: "B", price: 25.0)
        let itemC = BasketItem(name: "C", price: 9.99)
        
        basket.add(item: itemA, quantity: 5)
        basket.add(item: itemB, quantity: 2)
        basket.add(item: itemC, quantity: 6)
        
        #expect(
            basket.getQuantity(of: itemC.name) == 6,
            "Quantity of item 'C' should be 6"
        )
        
        #expect(
            basket.calculateTotal().isApproximatelyEqual(to: 151.94, tolerance: 0.01),
            "Total should be approximately 151.94"
        )
        
    }
}

extension Decimal {
    func isApproximatelyEqual(to other: Decimal, tolerance: Decimal = 0.01) -> Bool {
        return abs(self - other) <= tolerance
    }
}
