package com.clairedl.scala

object DataAnalysis {

  def sumByAccountId(data: List[Transaction]) =
    data
      .groupBy(tr => tr.accountId)
      .mapValues { trs =>
        trs.map(tr => tr.amount).sum
      }
      .mkString("\n")
}
