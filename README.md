# How to use the configuration file

The configuration file enables to choose the transaction loader and the type of filter one wants to
apply.
Below you will find the information that needs to be provided in application.conf

## Loaders

For random transactions:
  loader = "random"

To load from a file:
  loader = "file"
  fileName = "transactions.txt"
(or any other formatted .txt file)

## Available analyses

A set of filters has been implemented. Some require the corresponding name and parameter.

No filter is applied:
  filter = "NoFilter"

Filtering in transactions below a certain amount:
  filter = "LowTransactionsFilter"
  amount = Int

Filtering in transactions above a certain amount:
  filter = "HighTransactionsFilter"
  amount = Int

Filtering in transactions belonging to a specific category
  filter = "CategoryTransactionsFilter"
  category = String (e.g. "AA", "DD")

Filtering for a specific account ID
  filter = "AccountIdTransactionsFilter"
  accountId = String (e.g., "C27", "C5")
