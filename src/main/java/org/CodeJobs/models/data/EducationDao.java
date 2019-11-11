package org.CodeJobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.CodeJobs.models.Education;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EducationDao extends CrudRepository<Education, Integer> {

}
