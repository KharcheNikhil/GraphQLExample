package com.turvo.graphqltutorial.graphql;

import com.turvo.graphqltutorial.model.UserDocument;
import com.turvo.graphqltutorial.model.UserDocumentVO;
import com.turvo.graphqltutorial.persistence.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public class UserDynamicFetcher extends AbstractDynamicFetcher<UserDocumentVO, String> {

  private final UserRepository userRepository;

  @Autowired
  public UserDynamicFetcher(
      UserRepository userRepository,
      CacheManager cacheManager) {
    super(userRepository, cacheManager);
    this.userRepository = userRepository;
  }

  @Override
  public Optional<UserDocumentVO> retriveFromDB(String id) {
    //Hack!!!!
    List<UserDocumentVO> userDocumentVOList = userRepository.findByValueUserId(Long.valueOf(id));
    if (userDocumentVOList == null || userDocumentVOList.size() == 0) {
      return Optional.empty();
    }
    return Optional.ofNullable(userDocumentVOList.get(0));
  }
}
