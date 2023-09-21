package ex005.services;

public class PayPalService implements OnlinePaymentService {
    @Override
    public Double paymentFee(Double amount) {
        return null;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        return null;
    }
}
