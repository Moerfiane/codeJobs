package org.stlyouthjobs.models.data;

import org.stlyouthjobs.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
    
    User findByUsername(String username);
    List<Object> findByUsername(Object username);

//    User findOne(String name);
}
