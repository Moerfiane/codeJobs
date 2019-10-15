package org.stlyouthjobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.stlyouthjobs.models.NewApplicant;

public interface NewApplicantDao  extends CrudRepository<NewApplicant, Integer> {
}
