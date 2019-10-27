package com.clairedl.scala

object Main extends App {
  val loader = new FileTransactionLoader("transactions.txt")
  val filter = new LowTransactionsFilter(400)
  val analysis = new SumByAccountId(loader, filter).sumByAccountId()

  println(analysis)

}
