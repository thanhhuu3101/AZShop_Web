package Services;

import java.util.List;

import entity.Category;

public interface ICategoryServices {
	List<Category> findAll();
	void insert (Category category);
	void update(Category category);
	void delete(int cateid) throws Exception;
	Category findById(int categoryId);
	List<Category> findByCategoryname(String catname);
	int count();
}
