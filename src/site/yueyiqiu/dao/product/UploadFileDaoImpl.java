package site.yueyiqiu.dao.product;

import org.springframework.stereotype.Repository;

import site.yueyiqiu.dao.DaoSupport;
import site.yueyiqiu.model.product.UploadFile;

@Repository("uploadFileDao")
public class UploadFileDaoImpl extends DaoSupport<UploadFile> implements UploadFileDao{

}
