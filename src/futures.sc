object futures {
  import scala.util.Try
  import scala.concurrent.future
  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.duration._
  import scala.util.Random
  import scala.util.{Success, Failure}
  
  // Some type aliases, just for getting more meaningful method signatures:
  type CoffeeBeans = String
  type GroundCoffee = String
  case class Water(temperature: Int)
  type Milk = String
  type FrothedMilk = String
  type Espresso = String
  type Cappuccino = String

  // some exceptions for things that might go wrong in the individual steps
  // (we'll need some of them later, use the others when experimenting
  // with the code):
  case class GrindingException(msg: String) extends Exception(msg)
  case class FrothingException(msg: String) extends Exception(msg)
  case class WaterBoilingException(msg: String) extends Exception(msg)
  case class BrewingException(msg: String) extends Exception(msg)

  // FUTURES
  def grind(beans: CoffeeBeans): Future[GroundCoffee] = future {
    println("start grinding...")
    Thread.sleep(Random.nextInt(2000))
    if (beans == "baked beans") throw GrindingException("are you joking?")
    println("finished grinding...")
    s"ground coffee of $beans"
  }                                               //> grind: (beans: futures.CoffeeBeans)scala.concurrent.Future[futures.GroundCo
                                                  //| ffee]

  def heatWater(water: Water): Future[Water] = future {
    println("heating the water now")
    Thread.sleep(Random.nextInt(2000))
    println("hot, it's hot!")
    water.copy(temperature = 85)
  }                                               //> heatWater: (water: futures.Water)scala.concurrent.Future[futures.Water]

  def frothMilk(milk: Milk): Future[FrothedMilk] = future {
    println("milk frothing system engaged!")
    Thread.sleep(Random.nextInt(2000))
    println("shutting down milk frothing system")
    s"frothed $milk"
  }                                               //> frothMilk: (milk: futures.Milk)scala.concurrent.Future[futures.FrothedMilk]
                                                  //| 

  def brew(coffee: GroundCoffee, heatedWater: Water): Future[Espresso] = future {
    println("happy brewing :)")
    Thread.sleep(Random.nextInt(2000))
    println("it's brewed!")
    "espresso"
  }                                               //> brew: (coffee: futures.GroundCoffee, heatedWater: futures.Water)scala.concu
                                                  //| rrent.Future[futures.Espresso]
  def combine(espresso: Espresso, frothedMilk: FrothedMilk): Cappuccino = "cappuccino"
                                                  //> combine: (espresso: futures.Espresso, frothedMilk: futures.FrothedMilk)futu
                                                  //| res.Cappuccino

  grind("baked beans").onComplete {
    case Success(ground) => println(s"got my $ground")
    case Failure(ex) => println("This grinder needs a replacement, seriously!")
  }
  def prepareCappuccino(): Future[Cappuccino] = {
  val groundCoffee = grind("arabica beans")
  val heatedWater = heatWater(Water(20))
  val frothedMilk = frothMilk("milk")
  for {
    ground <- groundCoffee
    water <- heatedWater
    foam <- frothedMilk
    espresso <- brew(ground, water)
  } yield combine(espresso, foam)
}                                                 //> prepareCappuccino: ()scala.concurrent.Future[futures.Cappuccino]
}