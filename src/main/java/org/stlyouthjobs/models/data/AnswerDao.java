package org.stlyouthjobs.models.data;

import org.stlyouthjobs.models.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AnswerDao extends CrudRepository<Answer, Integer> {
}