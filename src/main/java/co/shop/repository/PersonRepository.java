package co.shop.repository;

import co.shop.model.entity.user.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

//    @Query("select a from Person a where a.userName = :username")
    Optional<Person> findByUserName(String userName);
}
