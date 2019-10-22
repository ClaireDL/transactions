package com.clairedl.scala

class TransactionsService(loader: TransactionLoader) {

    def process(): List[Transaction] = {
      loader.load()
    }

  }

  class FilterService(input: FilterSelector) {

    def filter(): List[Transaction] = {
      input.filter()
    }
  }

  class AnalysisService(data: TransactionAnalyser) {

    def analyse(): String = {
      data.analyse()
    }
  }
