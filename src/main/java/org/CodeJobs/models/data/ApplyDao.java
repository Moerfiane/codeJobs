package org.CodeJobs.models.data;

import org.CodeJobs.models.Apply;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface ApplyDao extends CrudRepository <Apply, Integer> {

    Iterable<Integer> jobId(Integer identify);

}
