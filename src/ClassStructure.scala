abstract class Animal {
  // name of animal can maybe change, wedding of birds
  def name: String
  override def toString = name
}

// default class for animals, all other animals inherit, gets name which cannot be changed (val)
class DefaultAnimal(override val name: String) extends Animal

class Bird(name: String) extends DefaultAnimal(name) {
  def fly = "I am flying"
}

// fish is swimmer
class Fish(name: String) extends DefaultAnimal(name) with Swimmer 

// for a duck we would swimming and flying feature, we introduce a trait
trait Swimmer {
  def swim = "I am swimmming"
}

// duck can fly and swim now
class Duck(name: String) extends Bird(name) with Swimmer

// another trait to add features to special birds
trait MichaelBuble extends Bird {
  override def fly = "I feel good and " + super.fly
}


/* Examples:

scala> val michael = new Bird(“Michael“) with MichaelBuble
scala> michael.fly
scala> val donald = new Duck(“Donald“)
scala> donald.fly
scala> donald.swim

*/