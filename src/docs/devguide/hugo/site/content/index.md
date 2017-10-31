---
title: Money Transfer Retailer Interface
type: index
---

[Electrum Payments](http://electrum.io) connects businesses together to transact with each other easily and robustly. This Money Transfer Retailer Interface documents the messaging interface used by Electrum to connect acquirers, processors, and money transfer service providers together for performing money transfers.

Money transfer service providers allow individuals to send funds to each other by managing the process by which a "sender" creates an order to send funds and a "recipient" accepts receipt of those funds. The creation of such orders and the paying of funds in by the sender or out to the recipient can occur at many different channels e.g. mobile, internet, POS etc. The Money Transfer Retailer Interface focuses on the POS channel.

The process of money transfers between individuals is a multi-step process consisting of the following steps:
1. The sender creates an order to send funds.
2. The details of the order are communicated to the recipient.
3. The recipient redeems the money transfer order and accepts the funds.

Prior to the sender being allowed to place money transfer orders they must be vetted as per FICA legislation (and any other applicable legislation). This typically requires the sender to be registered on the money transfer service provider's system. Their suitability to place money transfer orders can then be tracked and verified before an order is placed.

Retailers and money transfer service providers subsequently perform settlement and reconciliation operations to ensure that funds are correctly transferred between the retailer and the service provider for money transfer orders which have been placed and/or redeemed by the retailer's customers. This settlement and reconciliation process is outside the scope of the Money Transfer Retailer Interface.
