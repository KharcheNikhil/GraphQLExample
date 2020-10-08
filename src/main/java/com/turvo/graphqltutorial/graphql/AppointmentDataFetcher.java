package com.turvo.graphqltutorial.graphql;

import com.turvo.graphqltutorial.model.Appointment;
import com.turvo.graphqltutorial.persistence.AppointmentRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AppointmentDataFetcher {

  private final AppointmentRepository repository;

  @GraphQLQuery(name = "findById")
  public Appointment get(@GraphQLArgument(name = "id", description = "AppointmentId") String appointmentId){
    List<Appointment> appointmentList = repository.findByAppointmentId(UUID.fromString(appointmentId));
    if(appointmentList == null || appointmentList.size() == 0){
      return null;
    }
    return appointmentList.get(0);
  }

  @GraphQLQuery(name = "findByConfirmationNumber")
  public Appointment getByConfirmationNumber(@GraphQLArgument(name = "confirmationNumber", description = "Appointment Confirmation Number") String confirmationNumber){
    List<Appointment> appointmentList = repository.findByConfirmationNumber(confirmationNumber);
    if(appointmentList == null || appointmentList.size() == 0){
      return null;
    }
    return appointmentList.get(0);
  }
}
