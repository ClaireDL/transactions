package com.clairedl.scala

import com.colofabrix.scala.designpatterns.filters._

class FilterAdapter2(loader: TransactionLoader, condition: Transaction => Boolean)
    extends TransactionsFilter {

  private val adaptee = new GenericTransactionListFilter(
    loader.load(),
    condition
  )

  def filter(transactions: List[Transaction]): List[Transaction] =
    adaptee.getFilteredList()

}
