package com.turvo.graphqltutorial.graphql;

import com.turvo.graphqltutorial.persistence.AppointmentRepository;
import com.turvo.graphqltutorial.model.Appointment;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AllAppointmentDataFetcher implements DataFetcher<List<Appointment>> {

  private final AppointmentRepository repository;

  @Override
  public List<Appointment> get(DataFetchingEnvironment environment) throws Exception {
    return repository.findAll();
  }
}
