package com.scaler.lecture.observer;

public class Client {

    public static void main(String[] args) {
        Flipkart flipkart = Flipkart.getInstance();
        EmailSender emailSender = new EmailSender();
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        AnalyticsSender analyticsSender = new AnalyticsSender();

        flipkart.orderPlaced();
    }
}
