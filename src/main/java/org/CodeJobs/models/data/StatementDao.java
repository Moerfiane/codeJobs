package org.CodeJobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.CodeJobs.models.Statement;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StatementDao extends CrudRepository<Statement, Integer> {
}
