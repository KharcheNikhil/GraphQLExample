package com.turvo.graphqltutorial.persistence;

import com.turvo.graphqltutorial.model.Appointment;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, String> {
  Appointment findByAppointmentId(String appointmentId);
}
