package codingdojo.exampleC

class ShoppingBasketBuilder {

    val basket = ShoppingBasket()

    fun addItem(item: Item): ShoppingBasketBuilder {
        basket.addItem(item)
        return this
    }

    fun build(): ShoppingBasket {
        return basket
    }
}
