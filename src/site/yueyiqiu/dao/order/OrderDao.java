package site.yueyiqiu.dao.order;

import site.yueyiqiu.dao.BaseDao;
import site.yueyiqiu.model.order.Order;


public interface OrderDao extends BaseDao<Order>{
	public Order findByCustomer(int customerId);
}
