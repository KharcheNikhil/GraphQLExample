package com.turvo.graphqltutorial.persistence;

import com.turvo.graphqltutorial.model.UserDocumentVO;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDocumentVO, String> {
  List<UserDocumentVO> findByValueUserId(Long userId);
}
