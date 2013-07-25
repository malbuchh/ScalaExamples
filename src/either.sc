object either {
  case class Customer(age: Int)
  class Cigarettes
  case class UnderAgeFailure(age: Int, required: Int)
  def buyCigarettes(customer: Customer): Either[UnderAgeFailure, Cigarettes] =
    if (customer.age < 16) Left(UnderAgeFailure(customer.age, 16))
    else Right(new Cigarettes)                    //> buyCigarettes: (customer: either.Customer)Either[either.UnderAgeFailure,eith
                                                  //| er.Cigarettes]
}