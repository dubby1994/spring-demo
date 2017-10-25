/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package hello;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customers;

    @Ignore
    public void testFindByLastName() {
        Customer customer = new Customer("first", "last");
        entityManager.persist(customer);

        List<Customer> findByLastName = customers.findByLastName(customer.getLastName());

        assertThat(findByLastName).extracting(Customer::getLastName).containsOnly(customer.getLastName());
    }

    @Ignore
    public void testFindByFirstName() {

        System.out.println("==========================================");

        List<Customer> findByLastName = customers.findByFirstName("Jack");

        findByLastName.forEach( c -> System.out.println(c.toString()));
        System.out.println("==========================================");
    }

    @Ignore
    public void findByLastNameOrderByFirstNameDesc() {
        System.out.println("findByLastNameOrderByFirstNameDesc==========================================");

        List<Customer> findByLastName = customers.findByLastNameOrderByFirstNameDesc("Bauer");

        findByLastName.forEach( c -> System.out.println(c.toString()));
        System.out.println("findByLastNameOrderByFirstNameDesc==========================================");
    }

    @Ignore
    public void findByLastNameOrderByFirstNameAsc() {
        System.out.println("findByLastNameOrderByFirstNameAsc==========================================");

        List<Customer> findByLastName = customers.findByLastNameOrderByFirstNameAsc("Bauer");

        findByLastName.forEach( c -> System.out.println(c.toString()));
        System.out.println("findByLastNameOrderByFirstNameAsc==========================================");
    }

    @Ignore
     public void findByFirstNameAndLastName() {
        System.out.println("findByFirstNameAndLastName==========================================");

        List<Customer> findByLastName = customers.findByFirstNameAndLastName("Jack", "Bauer");

        findByLastName.forEach( c -> System.out.println(c.toString()));
        System.out.println("findByFirstNameAndLastName==========================================");
    }

    @Test
    public void findAllSort() {
        System.out.println("findByFirstNameAndLastName==========================================");

        List<Sort.Order> orderList = new ArrayList<>();
        orderList.add(new Sort.Order(Sort.Direction.DESC, "id"));

        Sort sort = new Sort(orderList);

        List<Customer> findByLastName = customers.findAll(sort);

        findByLastName.forEach( c -> System.out.println(c.toString()));
        System.out.println("findByFirstNameAndLastName==========================================");
    }

}