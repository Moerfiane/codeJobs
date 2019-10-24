package org.stlyouthjobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.stlyouthjobs.models.WorkExperience;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface WorkExperienceDao extends CrudRepository<WorkExperience, Integer> {
}
