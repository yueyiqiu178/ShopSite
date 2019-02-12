package site.yueyiqiu.dao.order;

import java.util.List;

import org.springframework.stereotype.Repository;

import site.yueyiqiu.dao.DaoSupport;
import site.yueyiqiu.model.order.Order;

@Repository("orderDao")
public class OrderDaoImpl extends DaoSupport<Order> implements OrderDao{

	@Override
	public Order findByCustomer(int customerId) {
		
		
		String where="where customer.id=?";
		Object[] parmas={customerId};
		
		List<Order> list=(List<Order>) this.find(where, parmas, null, -1, -1).getList();
		
		return list.get(0);
	}

}
