package org.stlyouthjobs.models.data;

import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.stlyouthjobs.models.Education;
import org.stlyouthjobs.models.Job;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface JobDao extends CrudRepository<Job, Integer>{

}
