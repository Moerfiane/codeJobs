package org.stlyouthjobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.stlyouthjobs.models.Compare;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CompareDao extends CrudRepository<Compare, Integer> {
}