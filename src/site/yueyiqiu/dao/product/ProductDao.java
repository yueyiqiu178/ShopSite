package site.yueyiqiu.dao.product;

import java.util.List;

import site.yueyiqiu.dao.BaseDao;
import site.yueyiqiu.model.product.ProductInfo;

public interface ProductDao extends BaseDao<ProductInfo>{
	
	
	public List<ProductInfo> findCommend();
	public List<ProductInfo> findClickCount();
	public List<ProductInfo> findSellCount();
	
}
