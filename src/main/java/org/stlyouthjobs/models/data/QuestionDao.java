//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.stlyouthjobs.models.data;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.stlyouthjobs.models.Question;

@Repository
@Transactional
public interface QuestionDao extends CrudRepository<Question, Integer> {
}