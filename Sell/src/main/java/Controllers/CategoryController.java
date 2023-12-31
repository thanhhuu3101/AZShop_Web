package Controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Services.ICategoryServices;
import Services.IcategoryServicesIMPL;
import entity.Category;
import utils.Constant;
import utils.UploadUtils;

@MultipartConfig(fileSizeThreshold = 1*1*10,maxFileSize = 1024*2024*100,maxRequestSize = 1024*2024*100)

@WebServlet(urlPatterns = { "/admin-category", "/admin-category/create", "/admin-category/update",

"/admin-category/edit", "/admin-category/delete", "/admin-category/reset" })

public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
		
	ICategoryServices categoryService = new IcategoryServicesIMPL() ;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// kiểm tra url rồi chuyển đến hàm tương ứng
		
		// lấy url
		String url = request.getRequestURL().toString();
		
		Category category = null;
		
		if (url.contains("create")) {
		
			request.getRequestDispatcher("/views/admin/category/list.jsp").forward(request, response);
		
		} else if (url.contains("delete")) {
		
			delete(request, response);
			
			category = new Category();
			
			request.setAttribute("category", category);
		
		} else if (url.contains("edit")) {
		
			edit(request, response);
		
		
		
		} else if (url.contains("reset")) {
		
			category = new Category();
		
			request.setAttribute("category", category);
		
		}
		
		// gọi hàm findAll để lấy thông tin từ entity
		
		findAll(request, response);
		
		request.setAttribute("categorys", category);
		
		request.getRequestDispatcher("/views/admin/category/list.jsp").forward(request, response);
		
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// lấy url
		
		String url = request.getRequestURL().toString();
		
		// kiểm tra url rồi chuyển đến hàm tương ứng
		
		if (url.contains("create")) {
		
			insert(request, response);
		
		} else if (url.contains("update")) {
		
			update(request, response);
		
		} else if (url.contains("delete")) {
		
			delete(request, response);
		
		} else if (url.contains("reset")) {
		
			request.setAttribute("category", new Category());
		
		}
		
		// gọi hàm findAll để lấy thông tin từ entity
		
		findAll(request, response);
		
		request.getRequestDispatcher("/views/admin/category/list.jsp").forward(request, response);
	
	}
	
	
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
		
			request.setCharacterEncoding("UTF-8");
			
			response.setCharacterEncoding("UTF-8");
			
			// khỏi tạo đối tượng Model
			
			Category category = new Category();

			
			// sử dụng BeanUtils để tự lấy các name Field trên form
			
			// tên field phải trùng với entity
			
			BeanUtils.populate(category, request.getParameterMap());
			
			// xử lý hình ảnh
			
			String fileName = "" + System.currentTimeMillis();
			
			category.setIcon(UploadUtils.processUpload("icon", request, Constant.DIR+"\\category\\", fileName));
			
			// gọi hàm insert để thêm dữ liệu
			
			// category.setStatus(true);
			
			categoryService.insert(category);
			
			// thông báo
			
			request.setAttribute("message", "Đã thêm thành công");
		
		
		
		} catch (Exception e) {
		
			e.printStackTrace();
			
			request.setAttribute("error", "Eror: " + e.getMessage());
		
		}
		
		
	
	}
	
	
	
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
		
		
		
			// khởi tạo DAO
			
			// UserDao dao = new UserDao();
			
			// khai báo danh sách và gọi hàm findAll() trong dao
			
			List<Category> list = categoryService.findAll();
			
			// thông báo
			
			request.setAttribute("categorys", list);
			
			} catch (Exception e) {
			
			e.printStackTrace();
			
			request.setAttribute("error", "Eror: " + e.getMessage());
		
		}
		
	}
		
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
		
			// khai báo biến userId
			
			String categoryId = request.getParameter("categoryId");
			
			// khởi tạo DAO
			
			// UserDao dao = new UserDao();
			
			// gọi hàm insert để thêm dữ liệu
			
			Category category = categoryService.findById(Integer.parseInt(categoryId));
			
			// thông báo
			
			request.setAttribute("category", category);
			
			
			
			} catch (Exception e) {
			
			e.printStackTrace();
			
			request.setAttribute("error", "Eror: " + e.getMessage());
		
		}
		
		
		
	}
	
	
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
		
			// lấy dữ liệu trong jsp
			
			String categoryId = request.getParameter("categoryId");
			
			// khởi tạo DAO
			
			// UserDao dao = new UserDao();
			
			// khai báo danh sách và gọi hàm findAll() trong dao
			
			categoryService.delete(Integer.parseInt(categoryId));
			
			
			
			// thông báo
			
			request.setAttribute("message", "Đã xóa thành công");
			
			
			
			} catch (Exception e) {
			
			e.printStackTrace();
			
			request.setAttribute("error", "Eror: " + e.getMessage());
			
			}
		
		
		
	}
	
	
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
		
			request.setCharacterEncoding("UTF-8");
			
			response.setCharacterEncoding("UTF-8");
			
			// lấy dữ liệu từ jsp bằng BeanUtils
			
			Category category = new Category();
			
			BeanUtils.populate(category, request.getParameterMap());
			
			// khởi tạo DAO
			
			Category oldcate = categoryService.findById(category.getCategoryID());
			
			// xử lý hình ảnh
			
			if (request.getPart("icon").getSize() == 0) {
			
				category.setIcon(oldcate.getIcon());
			
			} else {
			
			if (oldcate.getIcon() != null) {
			
				// XOA ANH CU DI
				
				String fileName = oldcate.getIcon();
				
				File file = new File(Constant.DIR+"\\category\\" + fileName);
				
				if (file.delete()) {
				
					System.out.println("Đã xóa thành công");
				
				}else {
				
					System.out.println(Constant.DIR+"\\category\\" + fileName);
				
				}
		
			}
			
			String fileName = "" + System.currentTimeMillis();
			
			category.setIcon(UploadUtils.processUpload("icon", request, Constant.DIR+"\\category\\", fileName));
			
			}
			
			// khai báo danh sách và gọi hàm update trong service
			
			
			
			categoryService.update(category);
			
			
			
			// thông báo
			
			request.setAttribute("category", category);
			
			request.setAttribute("message", "Cập nhật thành công!");
			
			
		
		} catch (Exception e) {
		
			e.printStackTrace();
			
			request.setAttribute("error", "Eror: " + e.getMessage());
		
		}
		
	
	}

}
