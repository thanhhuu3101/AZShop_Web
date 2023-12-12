package DAO;

import java.util.List;

import entity.Category;

public interface ICategoryDAO {
	List<Category> findAll();
	void insert (Category category);
	void update(Category category);
	void delete(int cateid) throws Exception;
	Category findById(int categoryId);
	List<Category> findByCategoryname(String catname);
	int count();
}
