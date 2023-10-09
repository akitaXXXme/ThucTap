package backendauth.services.service;

import backendauth.models.Payment;
import backendauth.models.ProductType;

import java.util.List;

public interface PaymentService {
    public List<Payment> All();

    public String NewPayment(Payment newPayment);

    public String RemakePayment(Payment rePayment);
    public String DeleteType(int idPayment);
}
