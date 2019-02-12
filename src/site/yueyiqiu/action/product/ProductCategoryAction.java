package site.yueyiqiu.action.product;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import site.yueyiqiu.action.BaseAction;
import site.yueyiqiu.model.PageModel;
import site.yueyiqiu.model.product.ProductCategory;
import site.yueyiqiu.model.product.ProductInfo;

import com.opensymphony.xwork2.ModelDriven;

@Scope("prototype")
@Controller("productCategoryAction")
public class ProductCategoryAction extends BaseAction implements ModelDriven<ProductCategory>{
	
	
	
	
	
	public String add(){
		System.out.println("pid="+this.pid);
		if(this.pid>0){
			
			ProductCategory parent=this.categoryDao.load(this.pid);
			
			this.category.setLevel(parent.getLevel()+1);
		}
			
		return this.INPUT;
		
	}
	
	
	
	public String list(){
		System.out.println("pid="+this.pid);
		Object[] params=null;
		String where;
		if(this.pid>0){
			where="where parent.id=?";
			params=new Integer[]{pid};
		}else{
			where="where parent is null";
		}
		
		this.pagemodel=this.categoryDao.find(where, params, null, this.pageNo, this.pageSize);
		System.out.println("current page"+this.pageNo);
		for(int i=0;i<pagemodel.getList().size();i++){
		System.out.println(pagemodel.getList().get(i).getName()+" ");
		if(pagemodel.getList().get(i).getParent()!=null)
		System.out.println("parent="+pagemodel.getList().get(i).getParent().getName());
		
		}
		return this.LIST;
	}
	
	
	
	public String save(){
		System.out.println("rrrr");
		if(this.pid>0){
			this.category.setParent(this.categoryDao.load(pid));
		}
		System.out.println(this.category.getId());
		System.out.println("save"+this.category.getName());
		System.out.println(this.category.getLevel());
		//System.out.println(this.category.getParent().getId());
		this.categoryDao.saveOrUpdate(category);
		return this.list();
	}
	
	
	public String del(){
		return null;
		
		
	}
	
	
	public String edit(){
		
		
		System.out.println(this.category.getName());
		System.out.println(this.category.getId());
		//System.out.println(this.category.getParent().getId());
		System.out.println(this.pid);
		if(this.category.getId()>0)
		this.category=this.categoryDao.load(this.category.getId());
		
		return this.EDIT;
	}
	
	
	

	private ProductCategory category=new ProductCategory();
	private PageModel<ProductCategory> pagemodel;
	private int pid;
	
	@Override
	public ProductCategory getModel() {
		
		return this.category;
	}

	/**
	 * @return the category
	 */
	public ProductCategory getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	/**
	 * @return the pid
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}


	public PageModel<ProductCategory> getPagemodel() {
		return pagemodel;
	}


	public void setPagemodel(PageModel<ProductCategory> pagemodel) {
		this.pagemodel = pagemodel;
	}

	
	
	
	

}
