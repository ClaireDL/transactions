package com.clairedl.scala

abstract class TransactionAnalyserBuilder {
  def loader: TransactionLoader
  def filter: TransactionsFilter
}

class DefaultBuilder extends TransactionAnalyserBuilder {
  /**
    * Loads random transactions
    * Applies specific filter
    */
  def loader: TransactionLoader = new RandomTransactionLoader

  def filter: TransactionsFilter = new NoFilter

  def build(): TransactionAnalyser = {
   new TransactionAnalyser(loader, filter)
  }
}
