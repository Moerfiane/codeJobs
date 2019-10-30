package org.CodeJobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.CodeJobs.models.WorkExperience;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface WorkExperienceDao extends CrudRepository<WorkExperience, Integer> {
}
