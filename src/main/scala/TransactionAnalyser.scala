package com.clairedl.scala

import org.slf4j.LoggerFactory

class DataAnalyser(loader: TransactionLoader, filter: TransactionsFilter) {

  val transactions = loader.load()
  val filtered = filter.filter(transactions)

  val logger = LoggerFactory.getLogger(getClass.getSimpleName)
  logger.trace("Transactions loaded and filtered")

  def groupedByAccountId: Map[String, List[Transaction]] =
    filtered.groupBy(_.accountId) // Same as .groupBy(tr => tr.accountId)

  def sumByAccountId(): Map[String, Double] = {
    logger.info("Starting analysis")
    groupedByAccountId
      .mapValues { trs =>
        Math.round((trs.map(tr =>
          tr.amount)
          .sum) * 100.00) / 100.00
      }
      .toMap
  }

  def averageByAccountId(): Map[String, Double] = {
    logger.info("Starting analysis")
    groupedByAccountId
      .mapValues { trs =>
        Math.round((trs.map(tr =>
          tr.amount / trs.size)
          .sum) * 100.00) / 100.00
      }
      .toMap
  }

  def averageByAccountIdByDay(): Map[(String, Int), Double] = {
    logger.info("Starting analysis")
    filtered
      .groupBy(tr => (tr.accountId, tr.day))
      .mapValues { trs =>
        Math.round((trs.map(tr =>
          tr.amount / trs.size)
          .sum) * 100.00) / 100.00
      }
      .toMap
  }
}