package org.stlyouthjobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.stlyouthjobs.models.EmployerUser;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface EmployerUserDao extends CrudRepository<EmployerUser, Integer> {
}
