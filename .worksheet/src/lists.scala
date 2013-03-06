object lists {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(39); 
	 val oneTwo = List(1,2);System.out.println("""oneTwo  : List[Int] = """ + $show(oneTwo ));$skip(27); 
	val threeFour = List(3,4);System.out.println("""threeFour  : List[Int] = """ + $show(threeFour ));$skip(43); 
	val oneTwoThreeFour = oneTwo :: threeFour;System.out.println("""oneTwoThreeFour  : List[Any] = """ + $show(oneTwoThreeFour ));$skip(56); 
	println(oneTwo+" and "+threeFour+" were not mutated.");$skip(53); 
	println("Thus, "+oneTwoThreeFour+" is a new list.");$skip(10); val res$0 = 
	
	List();System.out.println("""res0: List[Nothing] = """ + $show(res$0));$skip(5); val res$1 = 
	Nil;System.out.println("""res1: scala.collection.immutable.Nil.type = """ + $show(res$1));$skip(31); val res$2 = 
	List("Cool", "tools", "rule");System.out.println("""res2: List[String] = """ + $show(res$2));$skip(49); 
	val thrill = "Will" :: "fill" :: "until" :: Nil;System.out.println("""thrill  : List[String] = """ + $show(thrill ));$skip(34); val res$3 = 
	List("a","b") ::: List ("c","d");System.out.println("""res3: List[String] = """ + $show(res$3));$skip(11); val res$4 = 
	thrill(2);System.out.println("""res4: String = """ + $show(res$4));$skip(30); val res$5 = 
	thrill.count(s=>s.length==4);System.out.println("""res5: Int = """ + $show(res$5));$skip(16); val res$6 = 
	thrill.drop(2);System.out.println("""res6: List[String] = """ + $show(res$6));$skip(21); val res$7 = 
	thrill.dropRight(2);System.out.println("""res7: List[String] = """ + $show(res$7));$skip(31); val res$8 = 
	thrill.exists(s=> s=="until");System.out.println("""res8: Boolean = """ + $show(res$8));$skip(31); val res$9 = 
	thrill.filter(s=>s.length==4);System.out.println("""res9: List[String] = """ + $show(res$9));$skip(35); val res$10 = 
	thrill.forall(s=>s.endsWith("1"));System.out.println("""res10: Boolean = """ + $show(res$10));$skip(29); 
	thrill.foreach(s=>print(s));$skip(23); 
	thrill.foreach(print);$skip(13); val res$11 = 
	thrill.head;System.out.println("""res11: String = """ + $show(res$11));$skip(13); val res$12 = 
	thrill.init;System.out.println("""res12: List[String] = """ + $show(res$12));$skip(13); val res$13 = 
	thrill.last;System.out.println("""res13: String = """ + $show(res$13));$skip(15); val res$14 = 
	thrill.length;System.out.println("""res14: Int = """ + $show(res$14));$skip(24); val res$15 = 
	thrill.mkString(" , ");System.out.println("""res15: String = """ + $show(res$15));$skip(16); val res$16 = 
	thrill.reverse;System.out.println("""res16: List[String] = """ + $show(res$16));$skip(13); val res$17 = 
	thrill.tail;System.out.println("""res17: List[String] = """ + $show(res$17));$skip(48); 
	
	// TUPLES
	
	val pair = (99 , "Luftballons");System.out.println("""pair  : (Int, String) = """ + $show(pair ));$skip(18); 
	println(pair._1);$skip(18); 
	println(pair._2)}

	
	}
