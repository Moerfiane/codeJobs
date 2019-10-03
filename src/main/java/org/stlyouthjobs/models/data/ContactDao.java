package org.stlyouthjobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.stlyouthjobs.models.ContactInfo;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ContactDao extends CrudRepository<ContactInfo, Integer> {
}