package com.clairedl.scala

object Main extends App {

  val transactions = new FileTransactionLoader("transactions.txt").load()
  val transactionsRand = new RandomTransactionLoader().load()
  println(transactionsRand)

  val sumByAccountId = new TransactionAnalyser(transactionsRand).sumByAccountId()
  println(sumByAccountId.mkString("\n"))

}
