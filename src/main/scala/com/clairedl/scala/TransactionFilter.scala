package com.clairedl.scala

trait TransactionsFilter {
  def filter(transactions: List[Transaction]): List[Transaction]
}

class NoFilter() extends TransactionsFilter {
  def filter(transactions: List[Transaction]): List[Transaction] = transactions
}

class LowTransactionsFilter(amount: Double) extends TransactionsFilter {
  def filter(transactions: List[Transaction]): List[Transaction] =
    transactions.filter(_.amount < amount)
}

class HighTransactionsFilter(val amount: Double) extends TransactionsFilter {
  def filter(transactions: List[Transaction]): List[Transaction] =
    transactions.filter(_.amount > amount)
}

class CategoryTransactionsFilter(val cat: String) extends TransactionsFilter {
  def filter(transactions: List[Transaction]): List[Transaction] =
    transactions.filter(_.category == cat)
}

class AccountIdTransactionsFilter(val accId: String) extends TransactionsFilter {
  def filter(transactions: List[Transaction]): List[Transaction] =
    transactions.filter(_.accountId == accId)
}
