package de.marcusjanke.examples.springrest.repo;

import de.marcusjanke.examples.springrest.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}