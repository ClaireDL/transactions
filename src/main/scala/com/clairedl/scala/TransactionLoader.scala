package com.clairedl.scala

import scala.io._
import scala.util.Random

trait TransactionLoader {
  def load(): List[Transaction]
}

class FileTransactionLoader(val filePath: String) extends TransactionLoader {

  def load(): List[Transaction] = {
    Source
      .fromFile(filePath)
      .getLines()
      .drop(1)
      .map { line =>
        val split = line.split(",")
        Transaction(split(0), split(1), split(2).toInt, split(3), split(4).toDouble)
      }
    .toList
  }
}

class RandomTransactionLoader() extends TransactionLoader {

  def load(): List[Transaction] = {
    List.tabulate(Random.between(50, 500)) { i =>
      Transaction(
        s"A${String.format("%04d", i + 1)}",
        randomAccount,
        randomDay,
        randomCategory,
        randomAmount
      )
    }
  }

  private def randomAccount = s"A${Random.between(20, 50)}"

  private def randomDay = Random.between(1, 50)

  private def randomCategory = {
    val categories = "AA" :: "BB" :: "CC" :: "DD" :: "EE" :: "FF" :: Nil
    categories(Random.nextInt(categories.length))
    // val letter = Random.alphanumeric.filter(_.isLetter).head.toUpper
    // s"$letter$letter"
  }

  private def randomAmount = {
    val unit = Random.between(10, 999)
    val decimals = Random.between(0, 99)
    s"$unit.$decimals".toDouble
  }
}
