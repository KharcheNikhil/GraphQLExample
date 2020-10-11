package com.turvo.graphqltutorial.graphql;

import com.turvo.graphqltutorial.model.Appointment;
import com.turvo.graphqltutorial.persistence.AppointmentRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLInputField;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AppointmentMutations {

  private final AppointmentRepository appointmentRepository;

  @GraphQLMutation(name = "appointmentMutate")
  public Appointment patch(
      @GraphQLArgument(name = "id", description = "appointmentId") String appointmentId,
      @GraphQLArgument(name = "confirmationNumber") String confirmationNumber) {
    log.info("opration:{}", "appointmentMutate");
    List<Appointment> appointments = appointmentRepository
        .findByAppointmentId(UUID.fromString(appointmentId));
    if (appointments == null || appointments.size() == 0) {
      return null;
    }
    Appointment appointment = appointments.get(0);
    appointment.setConfirmationNumber(confirmationNumber);
    return appointmentRepository.save(appointment);
  }
}
