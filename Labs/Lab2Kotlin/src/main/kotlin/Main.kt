//Note: Did not implement scanner object and do-while loop.
//Just tested StockItem class methods and resulting outputs.
fun main() {
    val milk = StockItem("One Gallon of Milk", 3.60, 15)
    println(milk)
    val bread = StockItem("One Loaf of Bread", 1.98, 1)
    println(bread)
    bread.lowerQuantity()
    println("Bread Quantity: ${bread.getQuantity()}.")
    bread.lowerQuantity()
    bread.raiseQuantity()
    println("Bread Quantity: ${bread.getQuantity()}.")
    bread.setPrice(-1.00)
    println("Bread Price: ${bread.getPrice()}.")
}