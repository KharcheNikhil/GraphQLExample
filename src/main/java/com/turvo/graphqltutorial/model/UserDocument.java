package com.turvo.graphqltutorial.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class UserDocument {

  @Field
  private Long userId;

  @Field("full_name")
  private String fullName;
}
