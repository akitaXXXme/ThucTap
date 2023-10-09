package backendauth.services.implement;

import backendauth.models.Payment;
import backendauth.repository.PaymentRepository;
import backendauth.services.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImp implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public List<Payment> All() {
        return paymentRepository.findAll();
    }

    @Override
    public String NewPayment(Payment newPayment) {
        paymentRepository.save(newPayment);
        return "Them thanh cong phuong thuc thanh toan";
    }

    @Override
    public String RemakePayment(Payment rePayment) {
        int id_remake = rePayment.getPayment_id();
        Optional<Payment> optional = paymentRepository.findById(id_remake);
        if(optional.isEmpty()){
            return "khong co de sua";
        }
        else{
            Payment oldPayment = paymentRepository.findById(id_remake).get();
            oldPayment= rePayment;
            paymentRepository.save(oldPayment);
            return "Sua thanh cong";
        }

    }

    @Override
    public String DeleteType(int idPayment) {
        Optional<Payment> optional = paymentRepository.findById(idPayment);
        if(optional.isEmpty()){
            return "khong co de xoa";
        }else{
            paymentRepository.deleteById(idPayment);
            return "Xoa thanh cong";
        }

    }
}
