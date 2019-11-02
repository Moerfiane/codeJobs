package org.CodeJobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.CodeJobs.models.Job;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public interface JobDao extends CrudRepository<Job, Integer> {
    //List<Job> jobs = new ArrayList<>();

    //public List<Job> getAll(int id);
}
