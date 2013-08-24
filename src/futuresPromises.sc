  import concurrent.Future
  import concurrent.future
  import concurrent.ExecutionContext.Implicits.global
  import concurrent.Promise
object futuresPromises {
  case class TaxCut(reduction: Int)
  val f: Future[String] = future("hello")         //> f  : scala.concurrent.Future[String] = scala.concurrent.impl.Promise$Default
                                                  //| Promise@3b0def13

  // either give the type as a type parameter to the factory method:
  val taxcut = Promise[TaxCut]()                  //> taxcut  : scala.concurrent.Promise[futuresPromises.TaxCut] = scala.concurren
                                                  //| t.impl.Promise$DefaultPromise@5316d7bd
  // or give the compiler a hint by specifying the type of your val:
  val taxcut2: Promise[TaxCut] = Promise()        //> taxcut2  : scala.concurrent.Promise[futuresPromises.TaxCut] = scala.concurre
                                                  //| nt.impl.Promise$DefaultPromise@ade3e9
  taxcut.success(TaxCut(20))                      //> res0: futuresPromises.taxcut.type = scala.concurrent.impl.Promise$DefaultPro
                                                  //| mise@5316d7bd
  import scala.util.{Success, Failure}
	val taxCutF: Future[TaxCut] = Government.redeemCampaignPledge()
                                                  //> taxCutF  : scala.concurrent.Future[futuresPromises.TaxCut] = scala.concurren
                                                  //| t.impl.Promise$DefaultPromise@725d9aa7
  println("Now that they're elected, let's see if they remember their promises...")
                                                  //> Starting the new legislative period.
                                                  //| Now that they're elected, let's see if they remember their promises...
  taxCutF.onComplete {
    case Success(TaxCut(reduction)) =>
      println(s"A miracle! They really cut our taxes by $reduction percentage points!")
    case Failure(ex) =>
      println(s"They broke their promises! Again! Because of a ${ex.getMessage}")
  }
      
}

object Government {

  def redeemCampaignPledge(): Future[futuresPromises.TaxCut] = {
    val p = Promise[futuresPromises.TaxCut]()
    future {
      println("Starting the new legislative period.")
      Thread.sleep(2000)
      p.success(futuresPromises.TaxCut(20))
      println("We reduced the taxes! You must reelect us!!!!1111")
    }
    p.future
  }
}