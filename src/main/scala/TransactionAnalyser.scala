package com.clairedl.scala

trait TransactionAnalyser {

  def analyse(): String
}

class sumByAccountId(data: List[Transaction])
  extends TransactionAnalyser {

    def analyse(): String = {
      data
        .groupBy(tr => tr.accountId)
        .mapValues { trs =>
          trs.map(tr => tr.amount).sum
        }
        .mkString("\n")
      }
}
