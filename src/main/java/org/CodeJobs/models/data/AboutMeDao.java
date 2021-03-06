package org.CodeJobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.CodeJobs.models.AboutMe;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AboutMeDao extends CrudRepository<AboutMe, Integer> {
}
