package main

import scala.io._
import scala.util.Random

object Main extends App {

  val transactions = GetData.getData("transactions.txt")

  // println(DataAnalysis.sumByAccountId(transactions).toMap)
  // println(GetData.randomTransactions(100))
  // println(GetData.randomAccount)
  // println(GetData.randomDay)
  // println(GetData.randomCategory)
  println(GetData.randomAmount)
}

case class Transaction(
  id: String,
  accountId: String,
  day: Int,
  category: String,
  amount: Double
)

object GetData {
  def getData(filepath: String): List[Transaction] = {
    Source
      .fromFile(filepath)
      .getLines()
      .drop(1)
      .map { line =>
        val split = line.split(",")
        Transaction(split(0), split(1), split(2).toInt, split(3), split(4).toDouble)
      }
    .toList
  }

  def randomTransactions(size: Int) = {
    def trId = {
      // To Do: add custom prefix T000, T00 etc.
      List.tabulate(size) (n => s"T${n+1}")
    }
    trId
  }

  val randomAccount = s"A${Random.between(20, 50)}"

  val randomDay = Random.between(1, 50)

  def randomCategory = {
    val letter = Random.alphanumeric.filter(_.isLetter).head.toUpper
    s"${letter}${letter}"
  }

  def randomAmount = {
    val unit = Random.between(100, 999)
    val decimals = Random.between(0, 99)
    s"$unit.$decimals".toDouble
  }
}

object DataAnalysis {
  def sumByAccountId(data: List[Transaction]) = data
    .groupBy(tr => tr.accountId)
    .mapValues { trs =>
    trs.map(tr => tr.amount).sum
  }
}
