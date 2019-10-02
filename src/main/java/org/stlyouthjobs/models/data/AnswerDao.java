package org.stlyouthjobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.stlyouthjobs.models.Answer;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AnswerDao extends CrudRepository<Answer, Integer> {
}