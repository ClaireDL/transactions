package com.clairedl.scala

object Main extends App {

  // val chosenLoader = new FileTransactionLoader("transactions.txt")
  val chosenLoader = new RandomTransactionLoader()
  val service = new TransactionsService(chosenLoader).process()

  val chosenFilter = new FilterHigh(service, 50)
  val serviceFiltered = new FilterService(chosenFilter).filter()

  // val chosenCategory = new FilterCategory(serviceFiltered, "BB")
  val chosenCategory = new NoFilter(serviceFiltered)
  val categoryFiltered = new FilterService(chosenCategory).filter()
  println(categoryFiltered)

  val chosenAnalysis = new sumByAccountId(categoryFiltered)
  val analysis1 = new AnalysisService(chosenAnalysis).analyse()

  println(analysis1)
}
