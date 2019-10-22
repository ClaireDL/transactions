package com.clairedl.scala

import scala.math.BigDecimal.RoundingMode

trait TransactionAnalyser {

  def analyse(): String
}

class sumByAccountId(data: List[Transaction])
  extends TransactionAnalyser {

    def analyse(): String = {
      data
        .groupBy(tr => tr.accountId)
        .mapValues { trs =>
          trs.map(tr => tr.amount)
            .sum
            .setScale(2, RoundingMode.HALF_UP)
        }
        .mkString("\n")
      }
}
