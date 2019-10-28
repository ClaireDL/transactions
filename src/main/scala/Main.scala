package com.clairedl.scala

object Main extends App {
  val loader = new FileTransactionLoader("transactions.txt")
  val filter = new LowTransactionsFilter(400)
  val sum = new SumByAccountId(loader, filter).analyse()

  val average = new AverageByAccountId(loader, filter).analyse()

  println(sum)
  println(average)

}
