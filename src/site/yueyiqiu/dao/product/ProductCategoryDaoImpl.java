package site.yueyiqiu.dao.product;

import org.springframework.stereotype.Repository;

import site.yueyiqiu.dao.DaoSupport;
import site.yueyiqiu.model.product.ProductCategory;

@Repository("productCategoryDao")
public class ProductCategoryDaoImpl extends DaoSupport<ProductCategory> implements ProductCategoryDao{

}
