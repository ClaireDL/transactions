package com.clairedl.scala

object Main extends App {
  val loader = new FileTransactionLoader("transactions.txt")
//  val filter = new LowTransactionsFilter(400)
  val filter = new NoFilter()

  val data = new DataAnalyser(loader, filter)
  val averageByAccountId = data.averageByAccountId()
  println(averageByAccountId.mkString("\n"))
//  val averageByAccountIdByDay = data.averageByAccountIdByDay()
//  println(averageByAccountIdByDay.mkString("\n"))
}
