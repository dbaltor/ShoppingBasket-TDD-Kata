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

struct ShoppingBasketBTests {

    @Test func test_empty_basket_contains_nothing() throws {
        let basket: ShoppingBasketAsDict = [:]
                
            #expect(
                findQuantity(basket: basket, of: "C") == 0, 
                "Quantity of item 'C' should be 0"
            ) 
    }

    @Test func test_one_item() throws {
        let basket: ShoppingBasketAsDict = [
            "A":["quantity":1]
        ]

        #expect(
            findQuantity(basket: basket, of: "A") == 1, 
            "Quantity of item 'A' should be 1"
        ) 

    }

    @Test func test_two_items_added_at_once() throws {
        let basket: ShoppingBasketAsDict = [
            "A":["quantity":2]
        ]

        #expect(
            findQuantity(basket: basket, of: "A") == 2, 
            "Quantity of item 'A' should be 2"
        ) 
    }

    @Test func test_two_items_A_and_B() throws {
        let basket: ShoppingBasketAsDict = [
            "A":["quantity":1 ],
            "B":["quantity":1 ],
        ]

        #expect(
            findQuantity(basket: basket, of: "A") == 1, 
            "Quantity of item 'A' should be 1"
        ) 
    }

    @Test func test_empty_basket_total_price_0() throws {
        let basket: ShoppingBasketAsDict = [:] 

        #expect(
            calculateTotal(basket: basket) == 0, 
            "Total price should be 0"
        ) 
    }

    @Test func test_itemA_cost_10_basket_total_price_10() throws {
        let basket: ShoppingBasketAsDict = [
            "A": ["quantity": 1, "price": 10],
        ]

         #expect(
            calculateTotal(basket: basket) == 10.0, 
            "Total price should be 10"
        ) 
    }

    @Test func test_2_itemA_cost_10_basket_total_price_20() throws {
        let basket: ShoppingBasketAsDict = [
            "A": ["quantity": 2, "price": 10],
        ]

         #expect(
            calculateTotal(basket: basket) == 20.0, 
            "Total price should be 20"
        ) 
    }

    @Test func test_itemD_cost_160_basket_total_price_152_5_percent_discount() throws {
        let basket: ShoppingBasketAsDict = [
            "D": ["quantity": 1, "price": 160],
        ]

         #expect(
            calculateTotal(basket: basket) == 152, 
            "Total price should be 152"
        )  
    }

    @Test func test_itemE_cost_250_basket_total_price_225_10_percent_discount() throws {
        let basket: ShoppingBasketAsDict = [
            "E": ["quantity": 1, "price": 250],
        ]

         #expect(
            calculateTotal(basket: basket) == 225, 
            "Total price should be 225"
        )  
    }

    // @Test(.enabled(if: false))  
    @Test
    func test_total_over_100_gives_five_percent_discount() throws {
        
        let basket: ShoppingBasketAsDict = [
            "A": ["quantity": 5, "price": 10],
            "B": ["quantity": 2, "price": 25],
            "C": ["quantity": 6, "price": 9.99],
        ]

        #expect(
            findQuantity( basket: basket, of: "C") == 6,
            "Quantity of item 'C' should be 6"
        )
        
        #expect(
            calculateTotal( basket: basket).isApproximatelyEqual(to: 151.94),
            "Total should be approximately 151.94"
        )
    }
}

extension Double{
    func isApproximatelyEqual(to other: Double, tolerance: Double = 0.01) -> Bool {
        return abs(self - other) <= tolerance
    }
}
