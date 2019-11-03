package org.CodeJobs.models.data;

import org.CodeJobs.models.App;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface AppDao extends CrudRepository <App, Integer> {
}
