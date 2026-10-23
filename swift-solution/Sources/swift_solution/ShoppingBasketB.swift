import Foundation

typealias ShoppingBasketAsDict = [String: [String: Double]]

func findQuantity(basket: ShoppingBasketAsDict,
    of itemName: String) -> Int? { // Added method with optional return
    return Int(basket[itemName]?["quantity"] ?? 0)
}

func calculateTotal(basket: ShoppingBasketAsDict) -> Double {
    let basketTotal = basket.map{ (_, item) in  (item["quantity"] ?? 0) * (item["price"] ?? 0)}
    .reduce(0,+)

    if basketTotal > 200 {
        return basketTotal - basketTotal * 0.1
    }
    if basketTotal > 100 {
        return basketTotal - basketTotal * 0.05
    }
    return basketTotal
}
