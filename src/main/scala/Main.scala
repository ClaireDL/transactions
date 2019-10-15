package com.clairedl.scala

object Main extends App {

  val transactions = GetData.getData("transactions.txt")
  // println(transactions)
  val transactions_day5 = transactions.filter(_.day == 5)
  // println(transactions_day5)
  val transactions_over400 = transactions.filter(_.amount >= 400)
  // println(transactions_over400)

  val randTransactions = GetData.getRandomData
  println(randTransactions)
  val analysis1 = DataAnalysis.sumByAccountId(randTransactions)
  println(analysis1)

}
