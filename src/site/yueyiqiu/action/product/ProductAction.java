package site.yueyiqiu.action.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import site.yueyiqiu.action.BaseAction;
import site.yueyiqiu.model.PageModel;
import site.yueyiqiu.model.product.ProductCategory;
import site.yueyiqiu.model.product.ProductInfo;
import site.yueyiqiu.model.product.UploadFile;
import site.yueyiqiu.util.StringUtil;

@Scope("prototype")
@Controller("productAction")
public class ProductAction extends BaseAction implements ModelDriven<ProductInfo>{
	
	
	public String select(){
		
		if(this.product.getId()>0){
			System.out.println("select productId="+this.product.getId());
			this.product=this.productDao.get(this.product.getId());
			this.product.setClickCount(this.product.getClickCount()+1);
			this.productDao.update(product);
		}
		return this.SELECT;
	}
	
	
	
	public String findByClick(){
		
		Map<String,String> orderby=new HashMap<String,String>();
		
		orderby.put("clickCount", "desc");
		this.pagemodel=this.productDao.find(null, null, orderby, 1, 6);
		
		for(int i=0;i<this.pagemodel.getList().size();i++)
		System.out.println(this.pagemodel.getList().get(i).getName());
		
		return this.CLICKLIST;
		
	}
	
	
	public String findByCommend(){
		System.out.println("enter commend");
		Map<String,String> orderby=new HashMap<String,String>();
		orderby.put("sellCount", "desc");
		String where="where commend=?";
		Object[] params={true};
		
		this.pagemodel=this.productDao.find(where, params, orderby, 1,6);
		//this.pagemodel.setList(this.productDao.findCommend());
		
		for(int i=0;i<this.pagemodel.getList().size();i++)
			System.out.println(this.pagemodel.getList().get(i).getName());
		return this.FINDLIST;
		
	}
	
	
	public String findBySellCount(){
		
		Map<String,String> orderby=new HashMap<String,String>();
		orderby.put("sellCount", "desc");
		
		this.pagemodel=this.productDao.find(null, null, orderby, 1, 6);
		
		
		return this.FINDLIST;
		
	}
	
	public String findByName(){
		
		if(this.product.getName().length()>0){
			
			String where="where name like ?";
			Object[] params={"%"+this.product.getName()+"%"};
			this.pagemodel=this.productDao.find(where, params, null, this.pageNo, pageSize);
			
		}
		
		return this.LIST;
	}
	
	
	public String findNewProduct(){
		
		
		Map<String,String> orderby=new HashMap<String,String>();
		orderby.put("createTime", "desc");
		this.pagemodel=this.productDao.find(null, null, orderby, this.pageNo, pageSize);
		return this.LIST;
	}
	
	public String findSellProduct(){
		
		Map<String,String> orderby=new HashMap<String,String>();
		orderby.put("sellcount", "desc");
		this.pagemodel=this.productDao.find(null, null, orderby,  this.pageNo, pageSize);
		return this.SELL;
	}
	
	
	public String findCommendProduct(){
		
		Map<String,String> orderby=new HashMap<String,String>();
		orderby.put("createTime", "desc");
		String where="where commend=?";
		Object[] parmas={true};
		this.pagemodel=this.productDao.find(where, parmas, orderby,  this.pageNo, pageSize);
		return this.COMMEND;
		
	}
	
	public String findEnjoyProduct(){
		
		Map<String,String> orderby=new HashMap<String,String>();
		orderby.put("clickcount", "desc");
		this.pagemodel=this.productDao.find(null, null, orderby,  this.pageNo, pageSize);
		return this.ENJOY;
		
	}
	
	
	public String getByCategoryId(){
		
		if(this.product.getCategory().getId()>0){
			
			String where="where category.id=?";
			Object[] params={this.product.getCategory().getId()};
			this.pagemodel=this.productDao.find(where, params, null, pageNo, pageSize);
		}
		
		return this.LIST;
	}
	
	
	
	
	public String add(){
		//System.out.println(ServletActionContext.getServletContext().getRealPath("/upload"));
		createCategoryTree();
		
		for(int i=0;i<map.size();i++){
			System.out.println(map.get(i));
		}
		
		for(Entry<Integer, String> entry : map.entrySet()) {
		    int key = entry.getKey();
		    String value = entry.getValue();
		    System.out.println("key="+key);
		    System.out.println("value="+value);
		}
		
		return this.INPUT;
	}
	
	private void createCategoryTree(){
		
		String where="where level=1";
		PageModel<ProductCategory> model=this.categoryDao.find(where, null, null, -1, -1);
		List<ProductCategory> list=model.getList();
		System.out.println(list.get(0).getName());
		map=new LinkedHashMap<Integer,String>();
		
		for(ProductCategory category:list){
			this.setNodeMap(map, category, false);
		}
		
	} 
	
	
	private void setNodeMap(Map<Integer,String> map,ProductCategory node,boolean flag){
		
		if(node==null)
			return;
		
		int level=node.getLevel();
		StringBuffer sb=new StringBuffer();
		if(level>1){
			for(int i=0;i<level;i++)
			sb.append(" ");
			sb.append(flag?"L":"¢u");
		}
		
		map.put(node.getId(), sb.append(node.getName()).toString());
		
		Set<ProductCategory> children=node.getChildren();
		
		if(children!=null&&children.size()>0){
			
			for(ProductCategory child:children){
				boolean b = false;
				
				if(child.getLevel()-1==0)
					b=true;
				
				this.setNodeMap(map, child, b);
			}
			
		}
		
	}
	
	
	public String list(){
		
		this.pagemodel=this.productDao.find(null, null, null, pageNo, pageSize);
		return this.LIST;
	}
	
	
	public String save() throws IOException{
		
		System.out.println("start save....");
		System.out.println("sdsd");
		
		System.out.println(this.product.getSexrequest());
		System.out.println(this.product.getCategory().getId());
		System.out.println(this.product.getCategory().getName());
		
		//System.out.println(this.file.exists());
		
		if(this.file!=null){
			
			//String path=ServletActionContext.getServletContext().getRealPath("/upload");
			String path="D:/JavaEEProject/ShopSite/WebContent/upload";
			File dir=new File(path);		
			
			if(!dir.exists())
				dir.mkdir();
			
			String filename=StringUtil.getStringTime()+".jpg";
			FileInputStream in=null;
			FileOutputStream out=null;
			
			File outputfile=new File(dir,filename);
			
			
			
			try {
				in=new FileInputStream(this.file);
				out=new FileOutputStream(outputfile);
				
				byte[] bs=new byte[1024*4];
				int legth=-1;
				
				while((legth=in.read(bs))!=-1){
					
					out.write(bs, 0, legth);
				}
				if(outputfile.exists()){
				System.out.println("¦s¦b?"+outputfile.exists());
				System.out.println(outputfile.getAbsolutePath());
				System.out.println(path);
				}
				UploadFile uf=new UploadFile();
				uf.setPath(filename);
				System.out.println("enterfilehere");
				this.uploadFileDao.saveOrUpdate(uf);
				
				this.product.setUploadfile(uf);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			finally{
				
				out.flush();
				out.close();
				in.close();
			}
			
		}
		
		if(this.product.getCategory()!=null)
		product.setCategory(this.categoryDao.load(this.product.getCategory().getId()));
		
		if(this.product.getUploadfile()!=null)
		this.product.setUploadfile(this.uploadFileDao.load(this.product.getUploadfile().getId()));
		
		this.productDao.saveOrUpdate(product);
		
		return this.list();
	}
	
	
	public String edit(){
		
		this.product=this.productDao.get(this.product.getId());
		
		this.createCategoryTree();
		
		return this.EDIT;
	}
	
	
	
	private ProductInfo product=new ProductInfo();
	private PageModel<ProductInfo> pagemodel=new PageModel<ProductInfo>();
	private Map<Integer,String> map;
	private File file;
	
	
	@Override
	public ProductInfo getModel() {
		
		return this.product;
	}


	public ProductInfo getProduct() {
		return product;
	}


	public void setProduct(ProductInfo product) {
		this.product = product;
	}


	public PageModel<ProductInfo> getPagemodel() {
		return pagemodel;
	}


	public void setPagemodel(PageModel<ProductInfo> pagemodel) {
		this.pagemodel = pagemodel;
	}


	public Map<Integer, String> getMap() {
		return map;
	}


	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}


	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}


	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	
	
	
	
}
