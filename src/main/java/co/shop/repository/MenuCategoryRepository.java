package co.shop.repository;

import co.shop.model.entity.menu.MenuCategory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuCategoryRepository extends PagingAndSortingRepository<MenuCategory, Integer> {
}
