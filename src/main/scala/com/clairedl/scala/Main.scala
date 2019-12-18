package com.clairedl.scala

import com.colofabrix.scala.designpatterns.filters.GenericTransactionListFilter
import org.slf4j.LoggerFactory
import com.typesafe.config.{Config, ConfigFactory}


object Main extends App {

  val loader = ConfigurationSettings.loader
  val filter = ConfigurationSettings.filter

  // other ways to create instances of loaders
  // val loader = new FileTransactionLoader("transactions.txt")

  // other ways to create instances of filters
  // val filter = new LowTransactionsFilter(400)
  // another type of filtering, using the Adapter pattern
  // val filter = new DayFilterAdapter(3)
  // another type of filtering, using a generic Adapter pattern for GenericTransactionListFilter
  // val filter2 = new GenericFilterAdapter(GenericTransactionListFilter.dayFilter(List(), 5))

  // creates an object with the transactions ready for analysis
  val transactions = new TransactionAnalyser(loader, filter)

  // logging
  val logger = LoggerFactory.getLogger(getClass.getSimpleName)
  logger.info("New object created: {}", transactions)

  // one type of transactions analysis
  val averageByAccountId = transactions.averageByAccountId()
  println(averageByAccountId.mkString("\n"))

  //  val averageByAccountIdByDay = transactions.averageByAccountIdByDay()
  //  println(averageByAccountIdByDay.mkString("\n"))

  // using the Builder pattern to create instances of transactions to analyse
  // val default = new DefaultBuilder
  // val buildTransaction = default.build()
  // println(buildTransaction.sumByAccountId().mkString("\n")
}
