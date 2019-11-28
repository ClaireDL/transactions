package com.clairedl.scala

import com.colofabrix.scala.designpatterns.filters._

/**
  * methods from GenericTransactionListFilter requires a List of Transactions.
  * Please put an empty list instead.
  */
class GenericFilterAdapter(newFilter: GenericTransactionListFilter) extends TransactionsFilter {

  def filter(transactions: List[Transaction]): List[Transaction] = {
    transactions.filter(newFilter.condition)
  }
}
