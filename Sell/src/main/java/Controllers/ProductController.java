package Controllers;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Models.Category;
import Models.Product;
import Services.CateServices;
import Services.IProductService;
import Services.CateServiceImpl;
import Services.ProductServiceIMPL;
import utils.Constant;
import utils.UploadUtils;
@MultipartConfig(fileSizeThreshold = 1*1*10,maxFileSize = 1024*1024*50,maxRequestSize = 1024*1024*50)

@WebServlet(urlPatterns = {"/user-Sell/findAll","/user-Sell/findProductByCategory","/admin-insertpro"})
public class ProductController extends HttpServlet{
	private static final long serialVersionUID =1L;
	IProductService pdService = new ProductServiceIMPL();
	CateServices cateService = new CateServiceImpl(); 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("findAll")){
			findAll(req,resp);
		
		}else if(url.contains("findProductByCategory")) {
			int id = Integer.parseInt(req.getParameter("cateid"));
			findProductByCategory(req,resp,id);
			

		}else if(url.contains("admin-insertpro")) {
			List<Category> listcate = cateService.findAll();
			req.setAttribute("listcate", listcate);
			RequestDispatcher rd = req.getRequestDispatcher("/views/product/AddPD.jsp");
			rd.forward(req,resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("admin-insertpro")) {
			insert(req,resp);
		
		}
	}
	
	private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		Product model = new Product();
		try {
			//Lấy dữ liệu từ jsp bằng beanutils
			BeanUtils.populate(model, req.getParameterMap());
			//xử lý trường image
			if(req.getPart("imageLink").getSize() !=0) {
				String fileName = "" + System.currentTimeMillis();
				model.setImageLink(UploadUtils.processUpload("imageLink",req,Constant.DIR + "\\product\\",fileName));
			}
			model.setCategory(cateService.findById(model.getCategoryID()));
			pdService.insert(model);
			//Thông báo
			req.setAttribute("product", model);
			req.setAttribute("message", "Add Successfull");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Add Fail!");
		}
		resp.sendRedirect(req.getContextPath()+"/user-Sell/findAll");
		
		
		
	}
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> listcate = pdService.findAll();
		//Đẩy dữ liệu ra view
		req.setAttribute("list",listcate);
		//View nhận dữ liệu
		RequestDispatcher rd = req.getRequestDispatcher("/views/product/ListPD.jsp");
		rd.forward(req,resp);
	}
	private void findProductByCategory(HttpServletRequest req, HttpServletResponse resp,int id) throws ServletException, IOException {
		List<Product> listcate1 = pdService.findProductByCategory(id);
		//Đẩy dữ liệu ra view
		req.setAttribute("list",listcate1);
		//View nhận dữ liệu
		RequestDispatcher rd = req.getRequestDispatcher("/views/product/ListPD.jsp");
		rd.forward(req,resp);
	}	

}
