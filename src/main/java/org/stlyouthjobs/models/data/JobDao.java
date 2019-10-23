package org.stlyouthjobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.stlyouthjobs.models.Job;
import org.stlyouthjobs.models.User;


import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface JobDao extends CrudRepository<Job, Integer> {

    Integer findAll(Integer userId);

}
