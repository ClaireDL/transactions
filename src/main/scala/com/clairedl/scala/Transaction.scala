package com.clairedl.scala

case class Transaction(
    id: String,
    accountId: String,
    day: Int,
    category: String,
    amount: Double
    ) {

  override def toString(): String = {
    s"\nTransaction $id: account $accountId, day: $day, " +
      s"category: $category, amount: $amount"
  }
}
