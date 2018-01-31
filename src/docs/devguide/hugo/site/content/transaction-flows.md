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

The sequence diagram below shows a successful Get Customer Info operation. The response contains information regarding the customer.

Please note that a decline (which will occur in cases such as where the requested customer does not exist) will follow the same flow. 

![Successful Get Customer Info](/images/sequence-successful-get-customer-info.png "Successful Get Customer Info")

### Get Customer Info not supported

If the Get Customer Info call is not supported by the upstream entity, this call will return a 501 (Not Implemented) status code.

![Get Customer Info Not Supported](/images/sequence-get-customer-info-not-supported.png "Get Customer Info Not Supported")

## Create Or Update Customer

A Create Or Update Customer call will create a new or update an existing customer with the provided information.

### Successful Create Or Update Customer transaction

The sequence diagram below shows a successful createOrUpdateCustomer operation. The response contains information regarding the success of the requested operation.

![Successful Create Or Update Customer](/images/sequence-successful-create-or-update-customer.png "Successful Create Or Update Customer")

### Create Or Update Customer not supported

If the Create Or Update Customer call is not supported by the upstream entity, this call will return a 501 (Not Implemented) status code.

![Create Or Update Customer Not Supported](/images/sequence-not-supported-create-or-update-customer.png "Create Or Update Customer Not Supported")

# Financial Transactions

Financial transactions are so named because they have a financial impact. They will always consist of (at least) a request leg, followed by a confirmation / reversal leg to advise on the completion or failure of the transaction. This kind of flow is commonly referred to as "dual messaging", since the confirmation is always required, even for positive completions.

In some cases (such as with a [Redeem Order](/transaction-flows/#RedeemOrder)) an initial lookup message is also required as part of the flow.
                              
In order to maintain system consistency, it is important that all advice messages are queued in persistent storage and repeated until a _final_ response is received from the service. Refer to the section on [store-and-forward](/protocol-basics/#store-and-forward) for more details.

## Create Order

A Create Order operation will open an order in the upstream entity's system which may be redeemed at a later stage. An Order should not be considered redeemable until such time tender has been taken and the confirmation has been successfully processed.

### Successful Create Order

The below diagram depicts the normal flow of a Create Order operation.

Initially, the downstream entity generates a request to notify the upstream entity that an order should be created. Upon successful response from the upstream entity, the downstream entity will take tender and send a confirmation advice to notify the upstream entity of the successful payment. Once the upstream entity has received and processed the confirmation advice, the order will become redeemable.

![Successful Create Order](/images/sequence-successful-create-order.png "Successful Create Order")

### Declined Create Order

The below diagram depicts the flow of an upstream decline of a Create Order operation.

In this case, the initial request from the downstream entity is processed and the upstream entity declines the request. Since no order has been created, there is no need for the downstream entity to confirm or reverse the order.

![Declined Create Order](/images/sequence-declined-create-order.png "Declined Create Order")

### Reversed Create Order

The below diagram depicts the flow both a cancellation and a timeout reversal.

A Cancellation is a manual process that occurs when the downstream entity initiates a reversal despite receiving a successful response to their original request. A Timeout is an automatic process that occurs when the Money Transfer Service does not receive a response to the request in the configured time limit. The Money Transfer Service will notify both the downstream and upstream entities that the transaction was not completed.

A Reversal must be processed before the downstream entity may re-attempt the order creation.

![Reversed Create Order](/images/sequence-reversed-create-order.png "Reversed Create Order")

## Redeem Order

A Redeem Order is used when a recipient attempts to retrieve the order that the sender deposited. In a typical Redeem flow, a lookup is used, followed by a dual-message Redemption. The lookup is not necessary, but usefully serves as a validation step to ensure the recipient has the correct details, and their requested Order exists on the upstream entity. A lookup has no effect on the upstream entity, and can thus be performed multiple times for the same order without issue. 

The effect of the Redeem Order operation is that the Order will be marked as redeemed on the upstream entity's system, and the downstream entity will be required to hand the recipient the payable amount.

### Successful Lookup and Successful Redeem

The below diagram depicts the normal flow of a Redeem Order operation.

Initially, the downstream entity sends a lookup which returns a positive response. The downstream entity then initiates a Redemption, which consists of both a Redeem Order and Confirm Redeem.

![Successful Lookup and Successful Redeem](/images/sequence-successful-redeem-order.png "Successful Lookup and Successful Redeem")

### Declined Lookup Order

The below diagram depicts the flow when the lookup step successfully completes, but the response is a decline, implying that the order does not exist.

![Declined Lookup Order](/images/sequence-declined-lookup-order.png "Declined Lookup Order")

### Initial Lookup Fail

The below diagram depicts the flow when the initial lookup does not complete, but the following attempt is successful, followed by a Redeem operation. Please note that the Lookup failure may occur multiple times - the downstream entity should repeat the action until such time that a successful response (positive or negative) is received.

![Initial Lookup Order Fail](/images/sequence-initial-lookup-fail-successful-redeem-order.png "Initial Lookup Order Fail")

### Successful Lookup and Declined Redeem

The below diagram depicts the flow when the lookup is successful but the initial Redeem request receives a negative response.

![Successful Lookup and Declined Redeem](/images/sequence-declined-redeem-order.png "Successful Lookup and Declined Redeem")

### Successful Lookup and Reversed Redeem

The below diagrams depict the case where a negative advice (Reversal) is sent from the downstream entity to ensure that the previously requested redeem is not confirmed. As with a [Reversed Create Order](/transaction-flows/#ReversedCreateOrder), both an automatic (timeout) and manual (cancellation) reversal are shown.

![Successful Lookup and Reversed Redeem](/images/sequence-reversed-redeem-order.png "Successful Lookup and Reversed Redeem")