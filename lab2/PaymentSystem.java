import java.util.ArrayList;
import java.util.List;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public abstract void processPayment();
}

class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(double amount, String cardNumber, String cardHolder) {
        super(amount);
        this.cardHolder = cardHolder;

        if (validateCardNumber(cardNumber)) {
            this.cardNumber = encryptCardNumber(cardNumber);
        } else {
            throw new IllegalArgumentException("Invalid card number");
        }
    }

    private String encryptCardNumber(String cardNumber) {
        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }

    public boolean validateCardNumber(String cardNumber) {
        return cardNumber.length() == 16; 
    }

    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment of " + getAmount() + " from card holder: " + cardHolder);
    }
}

class PayPalPayment extends Payment {
    private String email;

    public PayPalPayment(double amount, String email) {
        super(amount);
        this.email = email;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing PayPal payment of " + getAmount() + " from email: " + email);
    }
}

class BankTransferPayment extends Payment {
    private String bankAccount;

    public BankTransferPayment(double amount, String bankAccount) {
        super(amount);
        this.bankAccount = bankAccount;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing bank transfer payment of " + getAmount() + " from account: " + bankAccount);
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        List<Payment> payments = new ArrayList<>();

        payments.add(new CreditCardPayment(100.0, "1234567812345678", "Mykyta Shchedrin"));
        payments.add(new PayPalPayment(50.0, "mykyta@bigpen.dild"));
        payments.add(new BankTransferPayment(75.0, "UA123456789012345678901234567890"));

        for (Payment payment : payments) {
            payment.processPayment();
        }
    }
}
