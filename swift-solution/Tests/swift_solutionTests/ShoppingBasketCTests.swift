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

struct ShoppingBasketCTests {

    @Test func test_empty_basket_contains_nothing() throws {
        let basket = ShoppingBasketBuilder()
            .build()

        #expect(
            basket.getQuantity(of: "C") == 0, 
            "Quantity of item 'C' should be 0"
        ) 
    }

    @Test func test_one_item() throws {
        let basket = ShoppingBasketBuilder()
            .addItem(item: ItemBuilder("A").withQuantity(1).build())
            .build()

        #expect(
            basket.getQuantity(of: "A") == 1, 
            "Quantity of item 'A' should be 1"
        )  
    }

    @Test func test_two_items() throws {
        let basket = ShoppingBasketBuilder()
            .addItem(item: ItemBuilder("A").withQuantity(2).build())
            .build()

         #expect(
            basket.getQuantity(of: "A") == 2, 
            "Quantity of item 'A' should be 2"
        ) 
    }

    @Test func test_two_items_A_and_B() throws {
        let basket = ShoppingBasketBuilder()
            .addItem(item: ItemBuilder("A").withQuantity(1).build())
            .addItem(item: ItemBuilder("B").withQuantity(1).build())
            .build()

         #expect(
            basket.getQuantity(of: "A") == 1, 
            "Quantity of item 'A' should be 1"
        ) 
    }

    @Test func test_empty_basket_total_price_0() throws {
        let basket = ShoppingBasketBuilder()
            .build()
        #expect(
            basket.calculateTotal() == 0, 
            "Total price should be 0"
        ) 
    }

    @Test func test_itemA_cost_10_basket_total_price_10() throws {
        let basket = ShoppingBasketBuilder()
            .addItem(item: ItemBuilder("A").withQuantity(1).withPrice(10).build())
            .build()

        #expect(
            basket.calculateTotal() == 10, 
            "Total price should be 10"
        ) 
    }

    @Test func test_2_itemA_cost_10_basket_total_price_20() throws {
        let basket = ShoppingBasketBuilder()
            .addItem(item: ItemBuilder("A").withQuantity(2).withPrice(10).build())
            .build()

        #expect(
            basket.calculateTotal() == 20, 
            "Total price should be 20"
        ) 
    }

    @Test func test_itemD_cost_160_basket_total_price_152_5_percent_discount() throws {
        let basket = ShoppingBasketBuilder()
            .addItem(item: ItemBuilder("D").withQuantity(1).withPrice(160).build())
            .build()

        #expect(
            basket.calculateTotal() == 152, 
            "Total price should be 152"
        ) 
    }

    @Test func test_itemE_cost_250_basket_total_price_225_10_percent_discount() throws {
        let basket = ShoppingBasketBuilder()
            .addItem(item: ItemBuilder("E").withQuantity(1).withPrice(250).build())
            .build()

        #expect(
            basket.calculateTotal() == 225, 
            "Total price should be 225"
        ) 
    }

    // @Test(.enabled(if: false))   
    @Test
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
            // basket.calculateTotal().isApproximatelyEqual(to: 151.94, absoluteTolerance: 0.01),
            basket.calculateTotal().isApproximatelyEqual(to: 151.94),
            "Total should be approximately 151.94"
        )
    }
}


