case class Footballer(name: String, age: Int, position: String)

def categorizeAge(futbolists: List[Footballer]): Map[String, Int] = {
  val categories = Map(
    "до 20" -> (f: Footballer) => f.age < 20,
    "от 20 до 30" -> (f: Footballer) => f.age >= 20 && f.age < 30,
    "от 30 до 36" -> (f: Footballer) => f.age >= 30 && f.age < 36,
    "старше 36" -> (f: Footballer) => f.age >= 36
  )

  val categorized = futbolists.groupBy { futbolist =>
    categories.collectFirst { case (category, predicate) if predicate(futbolist) => category }.getOrElse("Unknown")
  }

  categorized.mapValues(_.size)
}

val futbolists = List(
  Footballer("Иван", 18, "Нападающий"),
  Footballer("Петр", 25, "Полузащитник"),
  Footballer("Сергей", 32, "Защитник"),
  Footballer("Александр", 40, "Вратарь")
)

val categorizedFutbolists = categorizeAge(futbolists)
categorizedFutbolists.foreach { case (category, count) =>
  println(s"Количество футболистов в категории $category: $count")
}