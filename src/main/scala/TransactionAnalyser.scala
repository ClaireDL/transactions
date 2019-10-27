package com.clairedl.scala

trait TransactionAnalyser {
  def sumByAccountId(): Map[String, Double]
  def averageByAccountId(): Map[String, Double]
}

class SumByAccountId(loader: TransactionLoader, filter: TransactionsFilter)
  extends TransactionAnalyser {

  def sumByAccountId(): Map[String, Double] = {
    val transactions = loader.load()
    val filtered = filter.filter(transactions)

    filtered
      .groupBy(_.accountId)   // Same as .groupBy(tr => tr.accountId)
      .mapValues { trs =>
        trs.map(tr => tr.amount)
          .sum
      }.toMap
  }

class AverageByAccountId(loader: TransactionLoader, filter: TransactionsFilter)
  extends TransactionAnalyser {

  def averageByAccountId(): Map[String, Double] = {
    val transactions = loader.load()
    val filtered = filter.filter(transactions)

    val totalAccountId = filtered.count(x => true)

    filtered
      .groupBy(_.accountId)
      .mapValues { trs =>
        trs.map(tr => tr.amount / totalAccountId)
          .sum
      }.toMap
  }
}
