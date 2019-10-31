package com.clairedl.scala

class DataAnalyser(loader: TransactionLoader, filter: TransactionsFilter) {

  val transactions = loader.load()
  val filtered = filter.filter(transactions)

  def groupedByAccountId: Map[String, List[Transaction]] =
    filtered.groupBy(_.accountId) // Same as .groupBy(tr => tr.accountId)

  def sumByAccountId(): Map[String, Double] = {
    groupedByAccountId
      .mapValues { trs =>
        trs.map(tr =>
          tr.amount)
          .sum
      }
      .toMap
  }

  def averageByAccountId(): Map[String, Double] = {
    groupedByAccountId
      .mapValues { trs =>
        trs.map(tr =>
          Math.round((tr.amount / trs.size)) * 100 / 100)
          .sum
          .toDouble
      }
      .toMap
  }

  def averageByAccountIdByDay(): Map[(String, Int), Double] = {
    filtered
      .groupBy(tr => (tr.accountId, tr.day))
      .mapValues { trs =>
        trs.map(tr =>
          tr.amount / trs.size)
          .sum
      }
      .toMap
  }
}