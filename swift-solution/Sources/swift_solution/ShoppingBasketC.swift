import Foundation

class ShoppingBasketBuilder {
    var basket = ShoppingBasketC()

    func addItem(item: Item) -> ShoppingBasketBuilder{
        basket.addItem(item)
        return self
    }

    func build() -> ShoppingBasketC {
        return basket
    }
}

class ShoppingBasketC {
    var items: [String: Item] = [:]   

    func addItem(_ item: Item){
        self.items[item.name] = item
    }

    func getQuantity(of item: String) -> Int {
        return items[item]?.quantity ?? 0
    }

    func calculateTotal() -> Double {
        let total = items.map{(_, item) in item.price * Double(item.quantity)}
                                .reduce(0, +)
        if total > 200 {
            return total - total * 0.1
        }
        if total > 100 {
            return total - total * 0.05
        }
        return total
    }
}

class ItemBuilder {
    var item: Item
    
    init(_ name: String) {
        self.item = Item(name)
    }

    func withPrice(_ price: Double) -> ItemBuilder {
        self.item.price = price
        return self
    }

    func withQuantity(_ quantity: Int) -> ItemBuilder {
        self.item.quantity = quantity
        return self
    }

    func build() -> Item {
        return item 
    }
}

class Item {
    var name: String
    var price: Double = 0
    var quantity: Int = 0

    init(_ name: String) {
        self.name = name
    }
}