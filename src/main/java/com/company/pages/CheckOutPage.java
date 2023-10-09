package com.company.pages;

import org.openqa.selenium.By;

public class CheckOutPage {

    public static By BILLING_ADDRESS = By.xpath("//li[@id='opc-billing' and contains(@class,'active')]");
    public static By FIRSTNAME = By.id("BillingNewAddress_FirstName");
    public static By LASTNAME = By.id("BillingNewAddress_LastName");
    public static By EMAIL = By.id("BillingNewAddress_Email");

    public static By COUNTRY = By.id("BillingNewAddress_CountryId");

    public static By CITY = By.id("BillingNewAddress_City");
    public static By ADDRESS = By.id("BillingNewAddress_Address1");
    public static By ZIP = By.id("BillingNewAddress_ZipPostalCode");
    public static By PHONE = By.id("BillingNewAddress_PhoneNumber");
    public static By CONTINUE_BUTTON = By.xpath("//input[@onclick='Billing.save()']");

    public static By PAYMENT_METHOD = By.xpath("//li[@id='opc-payment_method' and contains(@class,'active')]");

    public static By METHOD = By.xpath("(//div[@class='payment-details'])[1]/label");
}
