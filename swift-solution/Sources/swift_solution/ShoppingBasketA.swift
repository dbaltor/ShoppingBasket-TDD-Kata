import Foundation


class ShoppingBasketA {

    var items: [String: (BasketItem, Int)] = [:]

    func add(item: BasketItem, quantity: Int) {
        items[item.name] = (item, quantity)
    }

    func getQuantity(of item: String) -> Int? {
        items[item]?.1 ?? 0
    }

    func calculateTotal() -> Decimal {
        let basketTotal = items.map{ (_, item) in Decimal(item.0.price) * Decimal(item.1)}
                                        .reduce(0, +)

        if basketTotal > 200 {
            return basketTotal - basketTotal * 0.1
        }
        if basketTotal > 100 {
            return basketTotal - basketTotal * 0.05
        }
        return basketTotal
    }
}
