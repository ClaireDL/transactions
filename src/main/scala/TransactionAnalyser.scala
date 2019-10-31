package com.clairedl.scala

import scala.math.BigDecimal.RoundingMode

<<<<<<< HEAD
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
=======
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
>>>>>>> f618dbe2ef1665489b61ded5895cbe556f39266f
}
