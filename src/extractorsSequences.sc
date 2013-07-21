object extractorsSequences {
  object GivenNames {
    def unapplySeq(name: String): Option[Seq[String]] = {
      val names = name.trim.split(" ")
      if (names.forall(_.isEmpty)) None else Some(names)
    }
  }

  def greetWithFirstName(name: String) = name match {
    case GivenNames(firstName, _*) => "Good morning, " + firstName + "!"
    case _ => "Welcome! Please make sure to fill in your name!"
  }                                               //> greetWithFirstName: (name: String)String
  greetWithFirstName("Malte Buchholz")            //> res0: String = Good morning, Malte!
  greetWithFirstName("Rosa")                      //> res1: String = Good morning, Rosa!

  object Names {
    def unapplySeq(name: String): Option[(String, String, Seq[String])] = {
      val names = name.trim.split(" ")
      if (names.size < 2) None
      else Some((names.last, names.head, names.drop(1).dropRight(1)))
    }
  }

  def greet(fullName: String) = fullName match {
    case Names(lastName, firstName, _*) => "Good morning, " + firstName + " " + lastName + "!"
    case _ => "Welcome! Please make sure to fill in your name!"
  }                                               //> greet: (fullName: String)String
  
  greet("checker123")                             //> res2: String = Welcome! Please make sure to fill in your name!
  greet("Jan Malte Buchholz")                     //> res3: String = Good morning, Jan Buchholz!
}