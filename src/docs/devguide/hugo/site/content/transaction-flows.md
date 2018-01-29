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

In order to maintain system consistency, it is important that all advice messages are queued in persistent storage on the money transfer retailer service client implementation and repeated until an acknowledgement of receipt is received from the Money Transfer Retailer Service server implementation. This process is commonly referred to as [store-and-forward](/protocol-basics/#store-and-forward).

# Admin Transactions

Admin transactions are always processed as request type messages, and should be considered complete only on receipt of a corresponding response (be it an approval or a decline). Admin transactions should thus be re-sent by the downstream party until a response is received.

Admin transactions are optional, and have no financial impact for either the downstream or upstream entities. They are also not required to be followed by a financial transaction.


## Get Customer Info

A Get Customer Info request retrieves customer information.

### Successful Get Customer Info transaction

// FIXME: include link to getCustInfo

The sequence diagram below shows a successful getCustomerInfo operation. The response contains information regarding the customer.

// TODO: flow diag

### Get Customer Info not supported

If the Get Customer Info call is not supported by the upstream entity, this call will return a 501 (Not Implemented) status code.

// TODO: flow diag

## Create Or Update Customer

A Create Or Update Customer call will create a new or update an existing customer with the provided information.

### Successful Create Or Update Customer transaction

The sequence diagram below shows a successful createOrUpdateCustomer operation. The response contains information regarding the success of the requested operation.

// TODO: flow diag

### Create Or Update Customer not supported

If the Create Or Update Customer call is not supported by the upstream entity, this call will return a 501 (Not Implemented) status code.

// TODO: flow diag

# Financial Transactions

Financial transactions are so named because they have a financial impact. They will always consist of (at least) a request leg, followed by a confirmation / reversal leg to advise on the completion or failure of the transaction. This kind of flow is commonly referred to as "dual messaging", since the confirmation is always required, even for positive completions.

In some cases (such as with a [Redeem Order](/transaction-flows/#RedeemOrder)) an initial lookup message is also required as part of the flow.
                              
In order to maintain system consistency, it is important that all advice messages are queued in persistent storage and repeated until a _final_ response is received from the service. Refer to the section on [store-and-forward](/protocol-basics/#store-and-forward) for more details.

## Create Order

A Create Order operation will open an order in the upstream entity's system which may be redeemed at a later stage. An Order should not be considered redeemable until such time tender has been taken and the confirmation has been successfully processed.

### Successful Create Order

The below diagram depicts the normal flow of a Create Order operation.

Initially, the downstream entity generates a request to notify the upstream entity that an order should be created. Upon successful response from the upstream entity, the downstream entity will take tender and send a confirmation advice to notify the upstream entity of the successful payment. Once the upstream entity has received and processed the confirmation advice, the order will become redeemable.

// TODO: flow diag

### Declined Create Order

The below diagram depicts the flow of an upstream decline of a Create Order operation.

In this case, the initial request from the downstream entity is processed and the upstream entity declines the request. Since no order has been created, there is no need for the downstream entity to confirm or reverse the order.

### Reversed Create Order