import Foundation

class ShoppingBasketBuilder {

    func addItem(item: BasketItem) -> ShoppingBasketBuilder{
        fatalError("NotImplementedError: addItem function not implemented")
    }

    func build() -> ShoppingBasketC {
        fatalError("NotImplementedError: build function not implemented")
    }
}

class ShoppingBasketC {
    
    func addItem(_ item: Item){
        fatalError("NotImplementedError: addItem function not implemented")
    }

    func getQuantity(of item: String) -> Int {
        fatalError("NotImplementedError: getQuantity function not implemented")
    }

    func calculateTotal() -> Double {
        fatalError("NotImplementedError: calculateTotal function not implemented")
    }
}

class ItemBuilder {
    
    init(_ name: String) {
        fatalError("NotImplementedError: ItemBuilder initializer not implemented")
    }

    func withPrice(_ price: Double) -> ItemBuilder {
        fatalError("NotImplementedError: withPrice function not implemented")
    }

    func withQuantity(_ quantity: Int) -> ItemBuilder {
        fatalError("NotImplementedError: withQuantity function not implemented")
    }

    func build() -> BasketItem {
        fatalError("NotImplementedError: build function not implemented")
    }
}

struct Item {

    let name: String

    init(_ name: String) {
        fatalError("NotImplementedError: Item initializer not implemented")
    }
}