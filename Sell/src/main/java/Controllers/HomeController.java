package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Category;
import Models.Product;
import Services.CateServices;
import Services.IProductService;
import Services.CateServiceImpl;
import Services.ProductServiceIMPL;


@WebServlet(urlPatterns = {"/user-Sell/home","/user-listprocate","/user-detail"})
public class HomeController extends HttpServlet{

	CateServices cateService =new CateServiceImpl();
	IProductService proService =new ProductServiceIMPL();
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("home")){
			List<Product> list1 = proService.findAll();
			req.setAttribute("listpro", list1);
			
		}else if(url.contains("listprocate")) {
			int id = Integer.parseInt(req.getParameter("cateid"));
			List<Product> list2 = proService.findProductByCategory(id);
			req.setAttribute("listpro", list2);
			req.setAttribute("setactive", id);

		}else if(url.contains("detail")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Product pro = proService.findOne(id);
			req.setAttribute("product", pro);
			RequestDispatcher rd = req.getRequestDispatcher("/views/user/detail.jsp");
			
		}
		
		List<Category> list = cateService.findAll();
		req.setAttribute("listcate", list);
		
		List<Product> countCID = proService.count();
		req.setAttribute("countCID", countCID);
		
		req.getRequestDispatcher("/views/user/home.jsp").forward(req, resp);
	}

}
