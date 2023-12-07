// Реляционная модель данных

case class Phone(
  id: Int,
  brand: String,
  model: String,
  price: Double,
  stock: Int
)

case class Customer(
  id: Int,
  name: String,
  email: String,
  address: String
)

case class Order(
  id: Int,
  customerId: Int,
  phoneId: Int,
  quantity: Int,
  orderDate: String
)

// Иерархическая модель данных

sealed trait Phone

case class Smartphone(brand: String, model: String, price: Double, stock: Int) extends Phone

case class FeaturePhone(brand: String, model: String, price: Double, stock: Int) extends Phone

case class Customer(name: String, email: String, address: String)

case class Order(customer: Customer, phones: List[Phone], quantity: List[Int], orderDate: String)