package co.shop.repository;

import co.shop.model.entity.user.RolePrivileges;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePrivilegesRepository extends PagingAndSortingRepository<RolePrivileges, Long> {
    @Override
    @Query("select a from RolePrivileges a JOIN FETCH a.privilege JOIN FETCH  a.role ")
    Iterable<RolePrivileges> findAll();
}
