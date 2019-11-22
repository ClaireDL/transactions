package com.clairedl.scala

import com.colofabrix.scala.designpatterns.filters._

class FilterAdapter3(loader: TransactionLoader, adaptee: GenericTransactionListFilter)
  extends TransactionsFilter {

  private val adaptee2 = new GenericTransactionListFilter(loader.load, adaptee.condition)

  def filter(transactions: List[Transaction]): List[Transaction] = {
    transactions.filter(adaptee.condition)
  }
}