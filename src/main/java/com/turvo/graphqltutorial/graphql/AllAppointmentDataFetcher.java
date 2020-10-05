package com.turvo.graphqltutorial.graphql;

import com.turvo.graphqltutorial.model.Appointment;
import com.turvo.graphqltutorial.persistence.AppointmentRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import io.leangen.graphql.annotations.GraphQLQuery;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AllAppointmentDataFetcher {

  private final AppointmentRepository repository;

  @GraphQLQuery(name = "findAll")
  public List<Appointment> get() {
    return repository.findAll();
  }
}
