package ex005.services;

import ex005.entities.Contract;
import ex005.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer month){
        double basicQuotation = contract.getTotalValue() / month;

        for (int i = 1; i <= month; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);
            double interest = onlinePaymentService.interest(basicQuotation, i);
            double fee = onlinePaymentService.paymentFee(basicQuotation + interest);
            double quotation = basicQuotation + interest + fee;
            contract.getInstallments().add(new Installment(dueDate, quotation));
        }


    }
}
