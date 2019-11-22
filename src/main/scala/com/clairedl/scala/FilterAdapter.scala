package com.clairedl.scala

import com.colofabrix.scala.designpatterns.filters._

abstract class FilterAdapter extends TransactionsFilter

class NoopFilterAdapter() extends FilterAdapter {
  def filter(transactions: List[Transaction]): List[Transaction] = {
    GenericTransactionListFilter
      .noopFilter(transactions)
      .getFilteredList()
  }
}

class DayFilterAdapter(day: Int) extends FilterAdapter {
  def filter(transactions: List[Transaction]): List[Transaction] = {
    GenericTransactionListFilter
      .dayFilter(transactions, day)
      .getFilteredList()
  }
}

class AmountRangeFilter(min: Double, max: Double) extends FilterAdapter {
  def filter(transactions: List[Transaction]): List[Transaction] = {
    GenericTransactionListFilter
      .amountRangeFilter(transactions, min, max)
      .getFilteredList()
  }
}