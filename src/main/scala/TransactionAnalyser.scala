package com.clairedl.scala

import scala.math.BigDecimal.RoundingMode

abstract class AnalysisPrep(loader: TransactionLoader, filter: TransactionsFilter) {
  val transactions = loader.load()
  val filtered = filter.filter(transactions)
}

class SumByAccountId(loader: TransactionLoader, filter: TransactionsFilter)
  extends AnalysisPrep(loader, filter) {

    def analyse(): Map[String, Double] = {
      filtered
        .groupBy(_.accountId) // Same as .groupBy(tr => tr.accountId)
        .mapValues { trs =>
          BigDecimal(
            trs.map(tr =>
              tr.amount)
              .sum)
            .setScale(2, RoundingMode.HALF_EVEN)
            .toDouble
        }
        .toMap
    }
}

class AverageByAccountId(loader: TransactionLoader, filter: TransactionsFilter)
  extends AnalysisPrep(loader, filter) {

    def analyse(): Map[String, Double] = {
      filtered
        .groupBy(_.accountId)
        .mapValues { trs =>
          BigDecimal(
            trs.map(tr =>
              tr.amount / trs.size)
              .sum)
            .setScale(2, RoundingMode.HALF_EVEN)
            .toDouble
        }
        .toMap
    }
}

class AverageByAccountIdByDay(loader: TransactionLoader, filter: TransactionsFilter)
  extends AnalysisPrep(loader, filter) {

    def analyse(): Map[(String, Int), Double] = {
      filtered
        .groupBy(tr => (tr.accountId, tr.day))
        .mapValues { trs =>
          BigDecimal(
            trs.map(tr =>
              tr.amount / trs.size)
              .sum)
            .setScale(2, RoundingMode.HALF_EVEN)
            .toDouble
        }
        .toMap
    }
}
