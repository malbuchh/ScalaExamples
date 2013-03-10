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
	
	// SETS
	// immuatable version, += yields new Set
	var jetSet = Set("Boeing", "Airbus")      //> jetSet  : scala.collection.immutable.Set[String] = Set(Boeing, Airbus)
	jetSet += "Lear"
	println(jetSet.contains("Cessna"))        //> false
	// mutable version with explicit name
	val movieSet = scala.collection.mutable.Set("Hitch","Poltergeist")
                                                  //> movieSet  : scala.collection.mutable.Set[String] = Set(Poltergeist, Hitch)
	movieSet += "Shrek"                       //> res18: lists.movieSet.type = Set(Poltergeist, Shrek, Hitch)
	println(movieSet)                         //> Set(Poltergeist, Shrek, Hitch)
	
	
	// MAPS
	import scala.collection.mutable.Map
	val treasureMap = Map[Int, String]()      //> treasureMap  : scala.collection.mutable.Map[Int,String] = Map()
	treasureMap += (1 -> "Go to island.")     //> res19: lists.treasureMap.type = Map(1 -> Go to island.)
	treasureMap += (2 -> "Find big X on ground")
                                                  //> res20: lists.treasureMap.type = Map(2 -> Find big X on ground, 1 -> Go to i
                                                  //| sland.)
	treasureMap += (3 -> "Dig")               //> res21: lists.treasureMap.type = Map(2 -> Find big X on ground, 1 -> Go to i
                                                  //| sland., 3 -> Dig)
	println(treasureMap(2))                   //> Find big X on ground

	
	}