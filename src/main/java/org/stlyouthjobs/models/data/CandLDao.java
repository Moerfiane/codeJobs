package org.stlyouthjobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.stlyouthjobs.models.CandL;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface CandLDao extends CrudRepository<CandL, Integer> {
}
