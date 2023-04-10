package co.shop.repository;

import co.shop.model.entity.Branch;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BranchRepository extends PagingAndSortingRepository<Branch, Integer> {

    @Query("select b from Branch b where b.branchCode = ?1")
    Optional<Branch> findByBranchCode(Integer branchCode);

    @Modifying
    @Query(value = "delete from Branch  where branchCode = ?1" )
    void deleteByCode(Integer code);

}
