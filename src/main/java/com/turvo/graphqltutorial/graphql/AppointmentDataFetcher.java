package com.turvo.graphqltutorial.graphql;

import com.turvo.graphqltutorial.model.Appointment;
import com.turvo.graphqltutorial.persistence.AppointmentRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.Collections;
import java.util.List;
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
    List<Appointment> appointmentList = repository.findByAppointmentId(UUID.fromString(appointmentId));
    if(appointmentList == null || appointmentList.size() == 0){
      return null;
    }
    return appointmentList.get(0);
  }
}
