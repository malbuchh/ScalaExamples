object patternMatchernAnom {
  // get all words with freqh in a certain range
  val wordFrequencies = ("habitual", 6) :: ("and", 56) :: ("consuetudinary", 2) ::
    ("additionally", 27) :: ("homely", 5) :: ("society", 13) :: Nil
                                                  //> wordFrequencies  : List[(String, Int)] = List((habitual,6), (and,56), (consu
                                                  //| etudinary,2), (additionally,27), (homely,5), (society,13))

  def wordsWithoutOutliers(wordFrequencies: Seq[(String, Int)]): Seq[String] =
    wordFrequencies.filter { case (_, f) => f > 3 && f < 25 } map { case (w, _) => w }
                                                  //> wordsWithoutOutliers: (wordFrequencies: Seq[(String, Int)])Seq[String]

  wordsWithoutOutliers(wordFrequencies)           //> res0: Seq[String] = List(habitual, homely, society)

  val pf: PartialFunction[(String, Int), String] = {
    case (word, freq) if freq > 3 && freq < 25 => word
  }                                               //> pf  : PartialFunction[(String, Int),String] = <function1>
  
  wordFrequencies.collect(pf)                     //> res1: List[String] = List(habitual, homely, society)
  
  def wordsWithoutOutliersREWRITE(wordFrequencies: Seq[(String, Int)]): Seq[String] =
    wordFrequencies.collect { case (word, freq) if freq > 3 && freq < 25 => word}
                                                  //> wordsWithoutOutliersREWRITE: (wordFrequencies: Seq[(String, Int)])Seq[String
                                                  //| ]
   wordsWithoutOutliersREWRITE(wordFrequencies)   //> res2: Seq[String] = List(habitual, homely, society)
  
}