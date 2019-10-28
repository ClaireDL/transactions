package com.clairedl.scala

trait TransactionsFilter {
  def filter(transactions: List[Transaction]): List[Transaction]
}

class NoFilter() extends TransactionsFilter {
  def filter(transactions: List[Transaction]): List[Transaction] = transactions
}

class LowTransactionsFilter(threshold: Double) extends TransactionsFilter {
  def filter(transactions: List[Transaction]): List[Transaction] = {
    transactions.filter(_.amount < threshold)
  }
}

class HighTransactionsFilter(val threshold: Double) extends TransactionsFilter {
  def filter(transactions: List[Transaction]): List[Transaction] = {
    transactions.filter(_.amount > threshold)
  }
}

class CategoryTransactionsFilter(val cat: String) extends TransactionsFilter {
  def filter(transactions: List[Transaction]): List[Transaction] = {
    transactions.filter(_.category == cat)
  }
}

class AccountIdTransactionsFilter(val accId: String) extends TransactionsFilter {
  def filter(transactions: List[Transaction]): List[Transaction] = {
    transactions.filter(_.accountId == accId)
  }
}
