object lists {
	 val oneTwo = List(1,2)                   //> oneTwo  : List[Int] = List(1, 2)
	val threeFour = List(3,4)                 //> threeFour  : List[Int] = List(3, 4)
	val oneTwoThreeFour = oneTwo :: threeFour //> oneTwoThreeFour  : List[Any] = List(List(1, 2), 3, 4)
	println(oneTwo+" and "+threeFour+" were not mutated.")
                                                  //> List(1, 2) and List(3, 4) were not mutated.
	println("Thus, "+oneTwoThreeFour+" is a new list.")
                                                  //> Thus, List(List(1, 2), 3, 4) is a new list.
	
	List()                                    //> res0: List[Nothing] = List()
	Nil                                       //> res1: scala.collection.immutable.Nil.type = List()
	List("Cool", "tools", "rule")             //> res2: List[String] = List(Cool, tools, rule)
	val thrill = "Will" :: "fill" :: "until" :: Nil
                                                  //> thrill  : List[String] = List(Will, fill, until)
	List("a","b") ::: List ("c","d")          //> res3: List[String] = List(a, b, c, d)
	thrill(2)                                 //> res4: String = until
	thrill.count(s=>s.length==4)              //> res5: Int = 2
	thrill.drop(2)                            //> res6: List[String] = List(until)
	thrill.dropRight(2)                       //> res7: List[String] = List(Will)
	thrill.exists(s=> s=="until")             //> res8: Boolean = true
	thrill.filter(s=>s.length==4)             //> res9: List[String] = List(Will, fill)
	thrill.forall(s=>s.endsWith("1"))         //> res10: Boolean = false
	thrill.foreach(s=>print(s))               //> Willfilluntil
	thrill.foreach(print)                     //> Willfilluntil
	thrill.head                               //> res11: String = Will
	thrill.init                               //> res12: List[String] = List(Will, fill)
	thrill.last                               //> res13: String = until
	thrill.length                             //> res14: Int = 3
	thrill.mkString(" , ")                    //> res15: String = Will , fill , until
	thrill.reverse                            //> res16: List[String] = List(until, fill, Will)
	thrill.tail                               //> res17: List[String] = List(fill, until)
	
	// TUPLES
	
	val pair = (99 , "Luftballons")           //> pair  : (Int, String) = (99,Luftballons)
	println(pair._1)                          //> 99
	println(pair._2)                          //> Luftballons

	
	}