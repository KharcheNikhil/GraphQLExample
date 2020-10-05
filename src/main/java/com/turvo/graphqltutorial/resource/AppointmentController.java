package com.turvo.graphqltutorial.resource;

import com.turvo.graphqltutorial.graphql.GraphQLService;
import com.turvo.graphqltutorial.model.Appointment;
import com.turvo.graphqltutorial.persistence.AppointmentRepository;
import graphql.ExecutionResult;
import graphql.GraphQL;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/appointments"})
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AppointmentController {

  private final GraphQLService graphQLService;
  private final AppointmentRepository appointmentRepository;

  @PostMapping
  public ResponseEntity<Object> find(@RequestBody  String query){
      ExecutionResult executionResult = graphQLService.getGraphQL().execute(query);
      return  ResponseEntity.ok(executionResult.getData());
  }
}
