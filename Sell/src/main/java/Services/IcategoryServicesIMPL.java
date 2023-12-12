package Services;

import java.util.List;


import DAO.ICategoryDAO;
import DAO.ICategoryDAOIMPL;
import entity.Category;

public class IcategoryServicesIMPL implements ICategoryServices{
	ICategoryDAO cateDao = new ICategoryDAOIMPL();
	

	
	@Override
	public List<Category> findAll() {
	
		return cateDao.findAll();
	}

	

	@Override
	public void insert(Category category) {
		cateDao.insert(category);
		
	}



	@Override
	public void update(Category category) {
		cateDao.update(category);
		
	}



	@Override
	public void delete(int cateid) throws Exception {
		cateDao.delete(cateid);
		
	}



	@Override
	public Category findById(int categoryId) {
		
		return cateDao.findById(categoryId);
	}



	@Override
	public List<Category> findByCategoryname(String catname) {
		
		return cateDao.findByCategoryname(catname);
	}



	@Override
	public int count() {
		
		return cateDao.count();
	}

}
