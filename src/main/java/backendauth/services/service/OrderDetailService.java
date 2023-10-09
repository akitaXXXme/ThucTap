package backendauth.services.service;



import backendauth.models.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    public List<OrderDetail> AllByOrder(int idO);

    public String NewDetail(OrderDetail newDetail);

    public String RemakeDetail(OrderDetail reDetail);
    public String DeleteDetail(int idDetail);
}
