package com.turvo.graphqltutorial.graphql;

import com.turvo.graphqltutorial.model.Appointment;
import com.turvo.graphqltutorial.model.UserDocumentVO;
import com.turvo.graphqltutorial.model.UserFragment;
import com.turvo.graphqltutorial.persistence.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLObjectType;
import io.leangen.graphql.annotations.GraphQLTypeResolver;
import io.leangen.graphql.execution.TypeResolutionEnvironment;
import io.leangen.graphql.execution.TypeResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserFetcher implements DataFetcher<UserFragment> {

  private final UserRepository userRepository;

  @Override
  public UserFragment get(DataFetchingEnvironment environment) throws Exception {
    Appointment appointment = environment.getSource();
    UserDocumentVO userDocumentVO = userRepository.findByValueUserId(appointment.getCreatedBy().getUserId()).get(0);
    return new UserFragment(userDocumentVO.getValue().getUserId(), userDocumentVO.getValue().getFullName());
  }
}
