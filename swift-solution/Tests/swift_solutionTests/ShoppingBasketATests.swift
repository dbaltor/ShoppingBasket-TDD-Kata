// import Numerics
import Testing
import Foundation

@testable import swift_solution 

/*
 * Implement tests in this order:
 *
 * x Empty basket - basket contains no items
 * x one item "A" - basket contains 1 item "A"
 * x two items "A" at once - basket contains 2 items "A"
 * x two items, "A" and "B" - basket contains 1 item "A"
 * x Empty basket - total price 0
 * x "A" costs $10, basket contains one "A" - total $10
 * x "A" costs $10, basket contains two "A" - total $20
 * x "D" costs $160, basket contains one "D" - total $152 (5% discount)
 * x "E" costs $250, basket contains one "E" - total $225 (10% discount)
 * x Then remove the "Ignore" marking on the test that's here and hopefully it will pass!
 */

struct ShoppingBasketATests {

    @Test func test_empty_basket_contains_nothing() throws {
        let basket = ShoppingBasketA()

        #expect(
            basket.getQuantity(of: "C") == 0, 
            "Quantity of item 'C' should be 0"
        ) 
    }

    @Test func test_one_item() throws {
        let basket = ShoppingBasketA()
        let itemA = BasketItem(name: "A", price: 10.0)
        
        basket.add(item: itemA, quantity: 1)

        #expect(
            basket.getQuantity(of: itemA.name) == 1, 
            "Quantity of item '\(itemA.name)' should be 1"
        )  
    }

    @Test func test_two_items_added() throws {
        let basket = ShoppingBasketA()
        let itemA = BasketItem(name: "A", price: 10.0)
        
        basket.add(item: itemA, quantity: 2)

        #expect(
            basket.getQuantity(of: itemA.name) == 2, 
            "Quantity of item '\(itemA.name)' should be 2"
        )  
    }


    @Test func test_two_items_A_and_B() throws {
        let basket = ShoppingBasketA()
        let itemA = BasketItem(name: "A", price: 10.0)
        let itemB = BasketItem(name: "B", price: 20.0)
        
        basket.add(item: itemA, quantity: 1)
        basket.add(item: itemB, quantity: 1)

        #expect(
            basket.getQuantity(of: itemA.name) == 1, 
            "Quantity of item '\(itemA.name)' should be 1"
        )  
    }

    @Test func test_empty_basket_total_price_0() throws {
        let basket = ShoppingBasketA()

        #expect(
            basket.calculateTotal() == 0, 
            "Total price should be 0"
        ) 
    }

    @Test func test_itemA_cost_10_basket_total_price_10() throws {
        let basket = ShoppingBasketA()
        let itemA = BasketItem(name: "A", price: 10.0)
        
        basket.add(item: itemA, quantity: 1)

        #expect(
            basket.calculateTotal() == 10, 
            "Total price should be 10"
        ) 
    }

    @Test func test_2_itemA_cost_10_basket_total_price_20() throws {
        let basket = ShoppingBasketA()
        let itemA = BasketItem(name: "A", price: 10.0)
        
        basket.add(item: itemA, quantity: 2)

        #expect(
            basket.calculateTotal() == 20, 
            "Total price should be 20"
        ) 
    }

    @Test func test_itemD_cost_160_basket_total_price_152_5_percent_discount() throws {
        let basket = ShoppingBasketA()
        let itemD = BasketItem(name: "D", price: 160.0)
        
        basket.add(item: itemD, quantity: 1)

        #expect(
            basket.calculateTotal() == 152, 
            "Total price should be 152"
        ) 
    }

    @Test func test_itemE_cost_250_basket_total_price_225_10_percent_discount() throws {
        let basket = ShoppingBasketA()
        let itemE = BasketItem(name: "D", price: 250.0)
        
        basket.add(item: itemE, quantity: 1)

        #expect(
            basket.calculateTotal() == 225, 
            "Total price should be 225"
        ) 
    }

    // @Test(.enabled(if: false))
    @Test
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
