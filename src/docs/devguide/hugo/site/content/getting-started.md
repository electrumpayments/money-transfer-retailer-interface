---
title: "Getting Started"
menu:
  main:
    weight: 0
---

The Money Transfer Retailer Interface is an [Apache-licensed](https://www.apache.org/licenses/LICENSE-2.0) RESTful HTTP based messaging protocol, intended to enable interoperability between money transfer service providers and retailers.

Using the Money Transfer Retailer Interface enables retailers to access an established and growing group of money transfer service providers who support the interface. At the same time, the Money Transfer Retailer Interface is made available to allow money transfer service providers a quick, well defined route towards integrating into retailers.

## Supported languages

### Java

The Electrum implementation of the Money Transfer Retailer Interface is written in Java. It is highly recommended that if you are planning a Java implementation of the Money Transfer Retailer Interface you include the [Money Transfer Retailer Interface](https://github.com/electrumpayments/money-transfer-retailer-interface) dependency in your project to save you from having to re-implement the interface. You can find instructions in the project [readme](https://github.com/electrumpayments/money-transfer-retailer-interface).

### Other languages

The Money Transfer Retailer Interface is described as a [swagger (OpenApi) document](/specification/swagger). It is highly recommended that widely available swagger tooling is used to generate a project in your preferred language as a starting point to a new integration project.
