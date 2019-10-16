package com.clairedl.scala

class TransactionAnalyser(val data: List[Transaction]) {

  def sumByAccountId() =
    data
      .groupBy(tr => tr.accountId)
      .mapValues { trs =>
        trs.map(tr => tr.amount).sum
      }
}
