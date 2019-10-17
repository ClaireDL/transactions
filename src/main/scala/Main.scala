package com.clairedl.scala

object Main extends App {

  // val chosenLoader = new FileTransactionLoader("transactions.txt")
  val chosenLoader = new RandomTransactionLoader()

  val service = new TransactionsService(chosenLoader).process()
}

class TransactionsService(loader: TransactionLoader) {

    def process(): Unit = {
      val transactions = loader.load()
    }
  }
