package com.clairedl.scala

object Main extends App {
  val loader = new FileTransactionLoader("transactions.txt")
//  val filter = new LowTransactionsFilter(400)
  val filter = new NoFilter()

<<<<<<< HEAD
  val data = new DataAnalyser(loader, filter)
  val averageByAccountId = data.averageByAccountId()
  println(averageByAccountId.mkString("\n"))
//  val averageByAccountIdByDay = data.averageByAccountIdByDay()
//  println(averageByAccountIdByDay.mkString("\n"))
=======
  val sumAccount = new SumByAccountId(loader, filter).analyse()

  val averageAccount = new AverageByAccountId(loader, filter).analyse()

  val averageAccountDay = new AverageByAccountIdByDay(loader, filter).analyse()
//  println(sumAccount)
//  println(averageAccount)

  println(averageAccountDay.mkString("\n"))

>>>>>>> f618dbe2ef1665489b61ded5895cbe556f39266f
}
