package com.clairedl.scala

import com.colofabrix.scala.designpatterns.filters.GenericTransactionListFilter
import org.slf4j.LoggerFactory

object Main extends App {

  val loader = new FileTransactionLoader("transactions.txt")
  //one type of filtering
  //val filter = new LowTransactionsFilter(400)

  // another type of filtering, using the Adapter pattern
  val filter = new DayFilterAdapter(3)
  val filter2 = new FilterAdapter3(
    loader,
    GenericTransactionListFilter
      .dayFilter(loader.load(), 4)
  )

  // creates an object with the transactions ready for analysis
  val data = new TransactionAnalyser(loader, filter2)

  // logging
  val logger = LoggerFactory.getLogger(getClass.getSimpleName)
  logger.info("New object created: {}", data)

  // one type of data analysis
  val averageByAccountId = data.averageByAccountId()
  println(averageByAccountId.mkString("\n"))

  // val averageByAccountIdByDay = data.averageByAccountIdByDay()
  // //println(averageByAccountIdByDay.mkString("\n"))

  // using the Builder pattern to create instances of data to analyse
  // val default = new DefaultBuilder
  // val buildTransaction = default.build()
  // println(buildTransaction.sumByAccountId().mkString("\n")
}