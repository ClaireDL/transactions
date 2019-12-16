package com.clairedl.scala

import com.typesafe.config.{Config, ConfigFactory}

class TransactionConfig(
    val transactionSettings: String = "file",
    val filterSettings: String,
    val transactionSettingsConf: String = "transactionSettings.conf",
    val filterSettingsConf: String = "filterSettings.conf"
) {

  def loader: TransactionLoader = {
    val settings: Config = ConfigFactory.load(transactionSettingsConf).getConfig(transactionSettings)
    transactionSettings match {
      case "file" => new FileTransactionLoader(settings.getString("name"))
      case "random" => new RandomTransactionLoader()
    }
  }

  def filter: TransactionsFilter = {
    val filterType: Config = ConfigFactory.load(filterSettingsConf).getConfig(filterSettings)
    filterSettings match {
      case "NoFilter" => new NoFilter()
      case "LowTransactionsFilter" => new LowTransactionsFilter(filterType.getInt("threshold"))
      case "HighTransactionsFilter" =>new HighTransactionsFilter(filterType.getInt("threshold"))
      case "CategoryTransactionsFilter" => new CategoryTransactionsFilter(filterType.getString("category"))
      case "AccountIdTransactionsFilter" =>new AccountIdTransactionsFilter(filterType.getString("accountId"))
    }
  }
}
