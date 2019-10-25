package org.stlyouthjobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.stlyouthjobs.models.Job;


import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;


@Repository
@Transactional
public interface JobDao extends CrudRepository<Job, Integer> {

}
