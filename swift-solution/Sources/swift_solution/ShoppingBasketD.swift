import Foundation

class ShoppingBasketFactory {

    var items: [String: ItemD] = [:]
    private init(items: [String: ItemD]) {
        self.items = items
    }
 
    func getQuantity(of itemName: String) -> Int {
        return items[itemName]?.quantity ?? 0
    }

    func calculateTotal() -> Decimal {
        let total = items.map({ (_, item) in Decimal(item.quantity) * item.price })
                                .reduce(0, +)
        if total > 200 {
            return total - total * 0.1
        }
        if total > 150 {
            return total - total * 0.05
        }
        return total
    }
    
    static func fromJson(json: String) throws -> ShoppingBasketFactory{
        if let jsonData = json.data(using: .utf8) {
            if let itemsList = try? JSONDecoder().decode(BasketD.self, from: jsonData) {
                let itemsMap = itemsList.items.reduce(
                    into: [String: ItemD](), 
                    { partialResult, item in partialResult[item.name] = item}
                )
                return ShoppingBasketFactory(items: itemsMap)
            }
        }
        return ShoppingBasketFactory(items: [:]) 
    }
}

struct BasketD: Decodable {
    let items: [ItemD]
}

struct ItemD: Decodable {
    let name: String
    let price: Decimal
    let quantity: Int
}

