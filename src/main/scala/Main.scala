package com.clairedl.scala

object Main extends App {
  val loader = new FileTransactionLoader("transactions.txt")
//  val filter = new LowTransactionsFilter(400)
  val filter = new NoFilter()

  val sumAccount = new SumByAccountId(loader, filter).analyse()

  val averageAccount = new AverageByAccountId(loader, filter).analyse()

  val averageAccountDay = new AverageByAccountIdByDay(loader, filter).analyse()
//  println(sumAccount)
//  println(averageAccount)

  println(averageAccountDay.mkString("\n"))

}
