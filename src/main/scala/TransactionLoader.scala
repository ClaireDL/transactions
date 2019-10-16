package com.clairedl.scala

import scala.io._
import scala.util.Random

trait TransactionLoader {
  def load(): List[Transaction]
}

class FileTransactionLoader(val filepath: String)
  extends TransactionLoader {

    def load(): List[Transaction] = {
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
}

class RandomTransactionLoader()
  extends TransactionLoader {

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

  protected def randomAccount = s"A${Random.between(20, 50)}"

  protected def randomDay = Random.between(1, 50)

  protected def randomCategory = {
    val categories = "AA" :: "BB" :: "CC" :: "DD" :: "EE" :: "FF" :: Nil
    categories(Random.nextInt(categories.length))
    // val letter = Random.alphanumeric.filter(_.isLetter).head.toUpper
    // s"$letter$letter"
  }

  protected def randomAmount = {
    val unit = Random.between(100, 999)
    val decimals = Random.between(0, 99)
    s"$unit.$decimals".toDouble
  }
}
