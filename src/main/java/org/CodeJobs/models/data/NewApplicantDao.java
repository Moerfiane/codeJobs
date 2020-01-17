package org.CodeJobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.CodeJobs.models.NewApplicant;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface NewApplicantDao extends CrudRepository<NewApplicant, Integer> {

    Iterable<Integer> session(Integer identify);
}
