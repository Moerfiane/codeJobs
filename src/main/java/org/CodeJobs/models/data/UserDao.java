package org.CodeJobs.models.data;

import org.CodeJobs.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    User findByUsername(String username);

    List<String> findByAccess(String access);

    User findByUid(Integer uid);

}
