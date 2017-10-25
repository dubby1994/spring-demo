package hello;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    //where
    List<Customer> findByLastName(String lastName);

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

    //order
    List<Customer> findByLastNameOrderByFirstNameDesc(String lastName);

    List<Customer> findByLastNameOrderByFirstNameAsc(String lastName);



    List<Customer> findAll(Sort sort);

    List<Customer> findAll(Pageable page);

}
