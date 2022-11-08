package service;

import java.util.*;

import com.paypal.api.payments.*;
import com.paypal.base.rest.*;

import entity.OrderDetail;

public class PaymentServices {
    private static final String CLIENT_ID = "AacQ0Q5c7wRMX2tCwE8AVLPaOQ0rwaQRZhDoXtb78HD17Jba9BoDUNGgKWoFgmgvoTQ6ERQMhdYtwWuh";
    private static final String CLIENT_SECRET = "EOEgqN1jb4xHBJsVzL6fjYSaeMPsT_uKeRb61LibzsWfQIRN4Km_aMDZrfRw8NGgr6V7Y3jU0VNa0lbO";
    private static final String MODE = "sandbox";

    public String authorizePayment(OrderDetail orderDetail)
            throws PayPalRESTException {

        Payer payer = getPayerInformation();
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(orderDetail);

        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setPayer(payer);
        requestPayment.setIntent("authorize");

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        Payment approvedPayment = requestPayment.create(apiContext);

        return getApprovalLink(approvedPayment);

    }

    private Payer getPayerInformation() {
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");
        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("William")
                .setLastName("Peterson").setEmail("ec2-buyer@gmail.com");
        payer.setPayerInfo(payerInfo);
        return payer;
    }

    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("https://sizegone-bookstore.herokuapp.com/cancel.html");
        //redirectUrls.setReturnUrl("http://localhost:8080/BookStore/review_payment");
        redirectUrls.setReturnUrl("https://sizegone-bookstore.herokuapp.com/review_payment");
        return redirectUrls;
    }

    private List<Transaction> getTransactionInformation(OrderDetail orderDetail) {
        Details details = new Details();
        details.setShipping(orderDetail.getShipping());
        details.setSubtotal(orderDetail.getSubtotal());
        details.setTax(orderDetail.getTax());
        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(orderDetail.getTotal());
        amount.setDetails(details);
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(orderDetail.getProductName());

        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<Item>();
        Item item = new Item();
        item.setCurrency("USD")
                .setName(orderDetail.getProductName())
                .setPrice(orderDetail.getSubtotal())
                .setTax(orderDetail.getTax())
                .setQuantity("1");
        items.add(item);
        itemList.setItems(items);
        transaction.setItemList(itemList);
        List<Transaction> listTransaction = new ArrayList<Transaction>();
        listTransaction.add(transaction);
        return listTransaction;

    }

    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return Payment.get(apiContext, paymentId);
    }
    
    public Payment executePayment(String paymentId, String payerId)
            throws PayPalRESTException {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);
     
        Payment payment = new Payment().setId(paymentId);
     
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
     
        return payment.execute(apiContext, paymentExecution);
    }

    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;
        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();

            }
        }
        return approvalLink;
    }
}
