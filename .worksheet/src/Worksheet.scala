object Worksheet {
	object Calculator {
		def add(x: Int, y: Int) = x + y
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(99); val res$0 = 
	
	Calculator.add(2,3);System.out.println("""res0: Int = """ + $show(res$0));$skip(72); 
	
	// Variable zeigt auf Funktion
	val add1 = (x: Int, y: Int) => x + y;System.out.println("""add1  : (Int, Int) => Int = """ + $show(add1 ));$skip(132); 
	// oder wir zeigen direkt auf die im Object definierte, wir machen sozusagen aus Funktion eine Methode
	val add = Calculator.add _;System.out.println("""add  : (Int, Int) => Int = """ + $show(add ));$skip(10); val res$1 = 
	add(2,3);System.out.println("""res1: Int = """ + $show(res$1));$skip(24); 
	val oneToFour = 1 to 4;System.out.println("""oneToFour  : scala.collection.immutable.Range.Inclusive = """ + $show(oneToFour ));$skip(119); val res$2 = 
	// Methode reduceLeft wird auf oneToFour aufgerufen und Methode add als Parameter übergeben
	oneToFour reduceLeft add;System.out.println("""res2: Int = """ + $show(res$2));$skip(129); 

	// jetzt überschreiben wir nur einen Parameter, d.h. erster Parameter wird auf 1 fixiert
	val addOne = Calculator.add(1,_:Int);System.out.println("""addOne  : Int => Int = """ + $show(addOne ));$skip(22); val res$3 = 
	oneToFour map addOne
	
	// Loan Pattern
	import java.io._;System.out.println("""res3: scala.collection.immutable.IndexedSeq[Int] = """ + $show(res$3));$skip(196); 
	
	def withPrintWriter(file: String)(write: PrintWriter => Unit) {
		val out = new PrintWriter(file)
		try {
			write(out)
		} finally {
			out.close()
		}
	};System.out.println("""withPrintWriter: (file: String)(write: java.io.PrintWriter => Unit)Unit""");$skip(61); 
	
	withPrintWriter("test.txt") { out => out.println("TEST")};$skip(97); 
	
	
	// alle Collections erben von Traversable, die können tolle Sachen
	oneToFour foreach print;$skip(37); val res$4 = 
	
	oneToFour filter {x => x% 2 == 0};System.out.println("""res4: scala.collection.immutable.IndexedSeq[Int] = """ + $show(res$4))}
}
