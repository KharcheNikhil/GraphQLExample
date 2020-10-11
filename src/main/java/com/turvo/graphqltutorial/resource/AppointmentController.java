package com.turvo.graphqltutorial.resource;

import com.turvo.graphqltutorial.persistence.AppointmentRepository;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/appointments"})
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AppointmentController {

  private final GraphQL graphQL;

  private final AppointmentRepository appointmentRepository;

  @PostMapping
  public ResponseEntity<Object> find(@RequestBody  String query){
      ExecutionResult executionResult = graphQL.execute(query);
      return  ResponseEntity.ok(executionResult);
  }
}
