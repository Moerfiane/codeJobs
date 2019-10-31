package org.CodeJobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.CodeJobs.models.Skills;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SkillsDao extends CrudRepository<Skills, Integer> {
}
