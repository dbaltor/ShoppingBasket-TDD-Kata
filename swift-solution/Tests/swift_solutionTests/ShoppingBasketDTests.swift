import Testing
import Foundation
@testable import swift_solution

/*
 * Implement tests in this order:
 *
 * x Empty basket - basket contains no items
 * x one item "A" - basket contains 1 item "A"
 * x two items "A" - basket contains 2 items "A"
 * x two items, "A" and "B" - basket contains 1 item "A"
 * x Empty basket - total price 0
 * x "A" costs $10, basket contains one "A" - total $10
 * x "A" costs $10, basket contains two "A" - total $20 
 * x "D" costs $160, basket contains one "D" - total $152 (5% discount)
 * x "E" costs $250, basket contains one "E" - total $225 (10% discount)
 * x Then remove the "Ignore" marking on the test that's here and hopefully it will pass!
 */

struct ShoppingBasketDTests {
    
    @Test(.enabled(if: false))
    func test_total_over_100_gives_five_percent_discount() throws {
        
        let jsonString = """
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
      let basket = try ShoppingBasketFactory.fromJson(json: jsonString)
        
      #expect(
          basket.getQuantity(of: "C") == 6,
          "Quantity of item 'C' should be 6"
      )
      #expect(
          // basket.calculateTotal() == Decimal(151.94),
          basket.calculateTotal().isApproximatelyEqual(to: 151.94, tolerance: 0.01),
          "Total should be approximately 151.94"
      )
    }
    
}
