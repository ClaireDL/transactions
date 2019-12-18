package com.clairedl.scala

import com.typesafe.config.{Config, ConfigFactory}

object ConfigurationSettings {

  private val config = ConfigFactory.load("application.conf").getConfig("configuration")

  def loader: TransactionLoader = {
    config.getString("loader") match {
      case "file" => new FileTransactionLoader(config.getString("fileName"))
      case "random" => new RandomTransactionLoader()
    }
  }

  def filter: TransactionsFilter = {
    config.getString("filter") match {
      case "NoFilter" => new NoFilter()
      case "LowTransactionsFilter" => new LowTransactionsFilter(config.getInt("amount"))
      case "HighTransactionsFilter" =>new HighTransactionsFilter(config.getInt("amount"))
      case "CategoryTransactionsFilter" => new CategoryTransactionsFilter(config.getString("category"))
      case "AccountIdTransactionsFilter" =>new AccountIdTransactionsFilter(config.getString("accountId"))
    }
  }

}
