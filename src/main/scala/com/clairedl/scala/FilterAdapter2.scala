package com.clairedl.scala

import com.colofabrix.scala.designpatterns.filters._

class FilterAdapter2 extends TransactionsFilter {

  var genericTransactionListFilter: GenericTransactionListFilter = _

  def filter(transactions: List[Transaction]): List[Transaction] = {
    genericTransactionListFilter.getFilteredList()
  }

  def getFilterType(name: String): TransactionsFilter = {
    genericTransactionListFilter = new GenericTransactionListFilter()
  }
}