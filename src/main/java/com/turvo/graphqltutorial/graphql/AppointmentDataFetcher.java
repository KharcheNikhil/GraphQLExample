package com.turvo.graphqltutorial.graphql;

import com.turvo.graphqltutorial.persistence.AppointmentRepository;
import com.turvo.graphqltutorial.model.Appointment;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AppointmentDataFetcher implements DataFetcher<Appointment> {

  private final AppointmentRepository repository;

  @Override
  public Appointment get(DataFetchingEnvironment environment) throws Exception {
    String appointmentId = (String) environment.getArguments().get("id");
    return repository.findByAppointmentId(appointmentId);
  }
}
