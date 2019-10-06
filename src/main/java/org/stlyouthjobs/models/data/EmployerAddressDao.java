package org.stlyouthjobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.stlyouthjobs.models.Address;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EmployerAddressDao extends CrudRepository<EmployerAddressDao, Integer> {

}
