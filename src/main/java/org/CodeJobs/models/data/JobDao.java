package org.CodeJobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.CodeJobs.models.Job;


import javax.transaction.Transactional;


@Repository
@Transactional
public interface JobDao extends CrudRepository<Job, Integer> {

    Iterable<Integer> session(Integer username);
}
