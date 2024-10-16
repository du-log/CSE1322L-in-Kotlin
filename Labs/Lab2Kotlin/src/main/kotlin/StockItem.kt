class StockItem() {
    private var description = ""
    private var id = 0

    private companion object {
        var newId = 0
    }

    private var price = 0.00
    private var quantity = 0

    constructor(description: String, price: Double, quantity: Int) : this() {
        this.description = description
        this.id = newId
        newId++
        this.price = price
        this.quantity = quantity
    }

    fun setPrice(price: Double) {
        if (price < 0.00) {
            println("Price Cannot Be Negative")
        } else {
            val newPrice = "%.2f".format(price)
            this.price = newPrice.toDouble()
        }
    }

    fun getDescription(): String {
        return this.description
    }

    fun getPrice(): String {
        return "$${String.format("%.2f", this.price)}"
    }

    fun getId(): Int {
        return this.id
    }

    fun getQuantity(): Int {
        return this.quantity
    }

    fun lowerQuantity() {
        if (this.quantity == 0) {
            println("Can't Lower Further")
        } else {
            this.quantity -= 1
        }
    }

    fun raiseQuantity() {
        this.quantity += 1
    }

    override fun toString(): String {
        return "${this.getDescription()}, ID: ${this.getId()}, Price: ${this.getPrice()}, Quantity: ${this.getQuantity()}"
    }
}