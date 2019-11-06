package com.clairedl.scala

abstract class TransactionAnalyserBuilder {
  protected def loader: TransactionLoader
  protected def filter: TransactionsFilter
}

class DefaultBuilder extends TransactionAnalyserBuilder {
  /**
    * Loads random transactions
    * Applies specific filter
    */
  protected def loader: TransactionLoader = new RandomTransactionLoader

  protected def filter: TransactionsFilter = new NoFilter

  def build(): TransactionAnalyser = {
   new TransactionAnalyser(loader, filter)
  }
}
