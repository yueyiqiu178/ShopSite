package site.yueyiqiu.dao.product;

import java.util.*;

import org.springframework.stereotype.Repository;

import site.yueyiqiu.dao.DaoSupport;
import site.yueyiqiu.model.PageModel;
import site.yueyiqiu.model.product.ProductInfo;

@Repository("productInfoDao")
public class ProductDaoImpl extends DaoSupport<ProductInfo> implements ProductDao{

	@Override
	public List<ProductInfo> findCommend() {
		
		String where="where commend=?";
		Object[] params={true};
		
		Map<String,String> orderby=new HashMap<String,String>();
		orderby.put("createTime", "desc");
		
		PageModel<ProductInfo> model=this.find(where, params, orderby, 1, 10);
		
		
		return model.getList();
		
		
	}

	@Override
	public List<ProductInfo> findClickCount() {
		
		Map<String,String> orderby=new HashMap<String,String>();
		orderby.put("clickcount", "desc");
		
		PageModel<ProductInfo> model=this.find(null, null, orderby, 1, 10);
		
		
		
		return model.getList();
	}

	@Override
	public List<ProductInfo> findSellCount() {
		
		Map<String,String> orderby=new HashMap<String,String>();
		orderby.put("sellCount", "desc");
		
		PageModel<ProductInfo> model=this.find(null, null, orderby, 1, 10);
		
		return model.getList();
		
	}

}
