package com.clairedl.scala

class SumByAccountId(loader: TransactionLoader, filter: TransactionsFilter) {

  def analyse(): Map[String, Double] = {
    val transactions = loader.load()
    val filtered = filter.filter(transactions)

    filtered
      .groupBy(_.accountId) // Same as .groupBy(tr => tr.accountId)
      .mapValues { trs =>
        trs.map(tr => tr.amount)
          .sum
      }.toMap
  }
}

class AverageByAccountId(loader: TransactionLoader, filter: TransactionsFilter) {

  def analyse(): Map[String, Double] = {
    val transactions = loader.load()
    val filtered = filter.filter(transactions)

    filtered
      .groupBy(_.accountId)
      .mapValues { trs =>
      trs.map(tr => tr.amount / trs.size)
        .sum
    }.toMap
  }
}
