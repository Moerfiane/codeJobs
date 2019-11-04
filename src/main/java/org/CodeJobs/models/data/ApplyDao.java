package org.CodeJobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.CodeJobs.models.Apply;

@Repository
@Transactional
public interface ApplyDao extends CrudRepository <Apply, Integer> {
}
