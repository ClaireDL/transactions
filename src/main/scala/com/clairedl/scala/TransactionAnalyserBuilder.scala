package com.clairedl.scala

abstract class TransactionAnalyserBuilder {
  protected def loader: TransactionLoader
  protected def filter: TransactionsFilter
}

/**
  * Loads random transactions
  * Applies specific filter
  */
class DefaultBuilder extends TransactionAnalyserBuilder {
  protected def loader: RandomTransactionLoader = new RandomTransactionLoader

  protected def filter: TransactionsFilter = new NoFilter

  def build(): TransactionAnalyser = {
    new TransactionAnalyser(loader, filter)
  }
}
