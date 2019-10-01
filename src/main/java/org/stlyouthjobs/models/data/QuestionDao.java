package org.stlyouthjobs.models.data;

import org.stlyouthjobs.models.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by LaunchCode
 */
@Repository
@Transactional
public interface QuestionDao extends CrudRepository<Question, Integer> {
}