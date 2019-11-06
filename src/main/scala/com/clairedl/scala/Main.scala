package com.clairedl.scala

import org.slf4j.LoggerFactory

object Main extends App {
  val loader = new FileTransactionLoader("transactions.txt")
  //val filter = new LowTransactionsFilter(400)
  val filter = new NoFilter()

  val data = new TransactionAnalyser(loader, filter)

  val logger = LoggerFactory.getLogger(getClass.getSimpleName)
  logger.info("New object created: {}", data)

  val averageByAccountId = data.averageByAccountId()
  //println(averageByAccountId.mkString("\n"))

  val averageByAccountIdByDay = data.averageByAccountIdByDay()
  //println(averageByAccountIdByDay.mkString("\n"))

  val default = new DefaultBuilder
  val buildTransaction = default.build()

  println(buildTransaction.sumByAccountId().mkString("\n"))

}