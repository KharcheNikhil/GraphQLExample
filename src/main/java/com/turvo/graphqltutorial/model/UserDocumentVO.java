package com.turvo.graphqltutorial.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "userFormFieldData")
public class UserDocumentVO implements MyCacheable{

  @Id
  private String id;

  @Field
  private UserDocument value;

  public static String cacheName(){
    return UserDocumentVO.class.getSimpleName();
  }
}
