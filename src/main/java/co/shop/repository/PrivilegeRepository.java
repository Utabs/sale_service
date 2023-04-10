package co.shop.repository;

import co.shop.model.entity.user.Privilege;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends PagingAndSortingRepository<Privilege, Long> {
}
