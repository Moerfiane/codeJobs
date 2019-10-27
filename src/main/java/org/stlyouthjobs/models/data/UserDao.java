package org.stlyouthjobs.models.data;

import org.stlyouthjobs.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.stlyouthjobs.models.User;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    User findByUsername(String username);


//    User findByuid(Integer uid);
}
