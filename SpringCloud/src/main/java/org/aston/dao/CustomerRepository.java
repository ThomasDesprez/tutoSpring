
package org.aston.dao;

import org.aston.customerservice.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
