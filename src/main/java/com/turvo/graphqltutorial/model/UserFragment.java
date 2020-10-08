package com.turvo.graphqltutorial.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@GraphQLType(name = "User")
@AllArgsConstructor
@NoArgsConstructor
public class UserFragment {

  @Field("id")
  @GraphQLQuery(name = "id")
  private Long userId;

  @Field("full_name")
  @GraphQLQuery
  private String name;
}
