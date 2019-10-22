package com.clairedl.scala

trait FilterSelector {
  def filter(): List[Transaction]
}

class FilterLow(val toFilter: List[Transaction], val threshold: Double)
  extends FilterSelector {

    def filter(): List[Transaction] = {
      toFilter.filter(_.amount < threshold)
    }
}

class FilterHigh(val toFilter: List[Transaction], val threshold: Double)
  extends FilterSelector {

    def filter(): List[Transaction] = {
      toFilter.filter(_.amount > threshold)
    }
}

class FilterCategory(val toFilter: List[Transaction], val cat: String)
  extends FilterSelector {

    def filter(): List[Transaction] = {
      toFilter.filter(_.category == cat)
    }
}

class NoFilter(val toFilter: List[Transaction])
  extends FilterSelector {

    def filter(): List[Transaction] = {
      toFilter
    }
}
