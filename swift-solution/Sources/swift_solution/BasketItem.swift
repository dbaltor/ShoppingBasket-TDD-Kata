import Foundation

// struct BasketItem: Hashable{
struct BasketItem {
    let name: String
    let price: Double
    
    init(name: String, price: Double) {
        self.name = name
        self.price = price
    }

    // func hash(into hasher: inout Hasher) {
    //     hasher.combine(name)
    //     hasher.combine(price)
    // }
}

