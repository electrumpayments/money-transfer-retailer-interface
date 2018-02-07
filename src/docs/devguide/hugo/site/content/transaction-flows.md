---
title: "Transaction Flows"
menu:
  main:
    weight: 20
---

This section depicts some transaction flows. It is not an exhaustive list of all conceivable flows, but does attempt to illustrate typical scenarios.

When developing a client implementation of the Money Transfer Retailer Interface, Electrum hosts the money transfer retailer service and assumes the role of the server. The implementor is then responsible for initiating the money transfer retailer service requests and processing the responses received from Electrum. When developing a server implementation, Electrum assumes the role of the client. The implementor is then responsible for servicing the money transfer retailer service requests sent by Electrum and generating appropriate responses.

## Request vs Advice Messages

There are two basic message types defined in the Money Transfer Retailer Interface: request and advice type messages. Request messages require a response from an upstream entity before processing can continue. If no response is received then the client cannot determine whether the server successfully received the request and also cannot assume an approved response was sent by the upstream entity. Therefore the client is responsible for ensuring that the request is reversed to ensure that both parties agree on the status of the request.

Reversals are an example of an advice type message. Advice type messages inform the server of an action or instruction but do not require the client to wait for a response from the server. Advice type messages are sent at suitable intervals until a definite response is received from the upstream entity.

In order to maintain system consistency, it is important that all advice messages are queued in persistent storage on the money transfer retailer service client implementation and repeated until an acknowledgement of receipt is received from the Money Transfer Retailer Service server implementation. This process is commonly referred to as store-and-forward.
