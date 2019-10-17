package com.clairedl.scala

case class TransactionAnalyser() {

  def sumByAccountId(data: List[Transaction]): String = {
    data
      .groupBy(tr => tr.accountId)
      .mapValues { trs =>
        trs.map(tr => tr.amount).sum
      }
      .mkString("\n")
    }
}
