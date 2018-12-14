# Money Transfer Retailer Interface

The Money Transfer Retailer Interface documents the messaging interface used by Electrum to connect acquirers, processors, and money transfer service providers together for performing money transfers.

You can find documentation for this project [here](https://electrumpayments.github.io/money-transfer-retailer-interface-docs/).

## Java Projects

To include the service interface into your maven project, include the below dependency.

```xml
<dependency>
    <groupId>io.electrum</groupId>
    <artifactId>money-transfer-retailer-interface</artifactId>
    <version>2.4.1</version>
</dependency>
<dependency>
  <groupId>io.electrum</groupId>
  <artifactId>service-interface-base</artifactId>
  <version>3.9.0</version>
  <scope>provided</scope>
</dependency>
```

Alternatively, you can download the Money Transfer Retailer Interface jar from [Bintray](https://bintray.com/electrumpayments/java-open-source/money-transfer-retailer-interface) and the Service Interface Base jar from [Bintray](https://bintray.com/electrumpayments/java-open-source/service-interface-base).

## Other languages

The interface is also available as a swagger (OpenApi) definition, which can be used to generate starter projects in many languages. See more info [here](https://electrumpayments.github.io/money-transfer-retailer-interface-docs/specification/swagger).
