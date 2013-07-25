object errorHandling {
  import scala.util.Try
  import java.net.URL
  import java.io.InputStream

  def parseURL(url: String): Try[URL] = Try(new URL(url))
                                                  //> parseURL: (url: String)scala.util.Try[java.net.URL]

  def parseHttpUrl(url: String) = parseURL(url).filter(_.getProtocol() == "http")
                                                  //> parseHttpUrl: (url: String)scala.util.Try[java.net.URL]
  parseHttpUrl("http://apache.openmirror.de")     //> res0: scala.util.Try[java.net.URL] = Success(http://apache.openmirror.de)
  parseHttpUrl("ftp://mirror.netcologne.de/apache.org")
                                                  //> res1: scala.util.Try[java.net.URL] = Failure(java.util.NoSuchElementExceptio
                                                  //| n: Predicate does not hold for ftp://mirror.netcologne.de/apache.org)

  parseURL("karl")                                //> res2: scala.util.Try[java.net.URL] = Failure(java.net.MalformedURLException:
                                                  //|  no protocol: karl)
  parseURL("http:\\www.maltebuchholz.com")        //> res3: scala.util.Try[java.net.URL] = Success(http:\www.maltebuchholz.com)

  parseURL("http:\\www.maltebuchholz.com").map(_.getProtocol)
                                                  //> res4: scala.util.Try[String] = Success(http)

  parseURL("garbage").map(_.getProtocol)          //> res5: scala.util.Try[String] = Failure(java.net.MalformedURLException: no pr
                                                  //| otocol: garbage)

  def inputStreamForURL(url: String): Try[InputStream] = parseURL(url).flatMap { u =>
    Try(u.openConnection()).flatMap(conn => Try(conn.getInputStream))
  }                                               //> inputStreamForURL: (url: String)scala.util.Try[java.io.InputStream]

  import scala.io.Source
  def getURLContent(url: String): Try[Iterator[String]] =
    for {
      url <- parseURL(url)
      connection <- Try(url.openConnection())
      is <- Try(connection.getInputStream)
      source = Source.fromInputStream(is)
    } yield source.getLines()                     //> getURLContent: (url: String)scala.util.Try[Iterator[String]]

  import scala.util.Success
  import scala.util.Failure
  getURLContent("http://maltebuchholz.com/foobar") match {
    case Success(lines) => lines.foreach(println)
    case Failure(ex) => println(s"Problem rendering URL content: ${ex.getMessage}")
  }                                               //> Problem rendering URL content: http://maltebuchholz.com/foobar

  import java.net.MalformedURLException
  import java.io.FileNotFoundException
  val content = getURLContent("garbage") recover {
    case e: FileNotFoundException => Iterator("Requested page does not exist")
    case e: MalformedURLException => Iterator("Please make sure to enter a valid URL")
    case _ => Iterator("An unexpected error has occurred. We are so sorry!")
  }                                               //> content  : scala.util.Try[Iterator[String]] = Success(non-empty iterator)
}