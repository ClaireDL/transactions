package com.clairedl.scala

object Main extends App {

  val chosenLoader = new FileTransactionLoader("transactions.txt")
  // val chosenLoader = new RandomTransactionLoader()
  val service = new TransactionsService(chosenLoader).process()


  // Analysis 1: filters expenses higher than 50 and in the "BB" cat.
  val chosenThreshold = new FilterHigh(service, 50)
  val thresholdFiltered = new FilterService(chosenThreshold).filter()

  val chosenCategory = new FilterCategory(thresholdFiltered, "BB")
  val categoryFiltered = new FilterService(chosenCategory).filter()

  val amountCategoryFilter = new sumByAccountId(categoryFiltered)
  val analysis1 = new AnalysisService(amountCategoryFilter).analyse()


  // Analysis 2: no filtering
  val noFilter = new sumByAccountId(service)
  val analysis2 = new AnalysisService(noFilter).analyse()


  println(analysis1)
  println(analysis2)
}
