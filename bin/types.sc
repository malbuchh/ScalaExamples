object types {
	class Person(val name: String)
	class Animal(val name: String)
	class Duck(name: String) extends Animal(name)
  // only Animals in Cage
  // the + in Front of Generic adds covariance
  class Cage[+A <: Animal](val animal: A)
  
  val donaldsCage = new Cage(new Duck("Donald"))  //> donaldsCage  : types.Cage[types.Duck] = types$Cage@145c38c1
  // yields error since cannot put person in cage
  // val merkelsCage = new Cage(new Person("Angela")))
 
 def operationFreedom(cage: Cage[Animal]) {
 	println(cage.animal + "is free now")
 }                                                //> operationFreedom: (cage: types.Cage[types.Animal])Unit
// error if we dont have + in front a in class def
 operationFreedom(donaldsCage)                    //> types$Duck@67591ba4is free now
 
 // case classes automatically offer equals, hashCode, toString and given accompanying object with apply method
 case class CaseCage[+A <: Animal](animal: A)
}