object Worksheet {
	object Calculator {
		def add(x: Int, y: Int) = x + y
	}
	
	Calculator.add(2,3)                       //> res0: Int = 5
	
	// Variable zeigt auf Funktion
	val add1 = (x: Int, y: Int) => x + y      //> add1  : (Int, Int) => Int = <function2>
	// oder wir zeigen direkt auf die im Object definierte, wir machen sozusagen aus Funktion eine Methode
	val add = Calculator.add _                //> add  : (Int, Int) => Int = <function2>
	add(2,3)                                  //> res1: Int = 5
	val oneToFour = 1 to 4                    //> oneToFour  : scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4)
	// Methode reduceLeft wird auf oneToFour aufgerufen und Methode add als Parameter übergeben
	oneToFour reduceLeft add                  //> res2: Int = 10

	// jetzt überschreiben wir nur einen Parameter, d.h. erster Parameter wird auf 1 fixiert
	val addOne = Calculator.add(1,_:Int)      //> addOne  : Int => Int = <function1>
	oneToFour map addOne                      //> res3: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 3, 4, 5)
	
	// Loan Pattern
	import java.io._
	
	def withPrintWriter(file: String)(write: PrintWriter => Unit) {
		val out = new PrintWriter(file)
		try {
			write(out)
		} finally {
			out.close()
		}
	}                                         //> withPrintWriter: (file: String)(write: java.io.PrintWriter => Unit)Unit
	
	withPrintWriter("test.txt") { out => out.println("TEST")}
	
	
	// alle Collections erben von Traversable, die können tolle Sachen
	oneToFour foreach print                   //> 1234
	
	oneToFour filter {x => x% 2 == 0}         //> res4: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4)
}