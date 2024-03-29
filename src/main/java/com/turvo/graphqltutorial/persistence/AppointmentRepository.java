package com.turvo.graphqltutorial.persistence;

import com.turvo.graphqltutorial.model.Appointment;
import java.util.List;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, String> {
  List<Appointment> findByAppointmentId(UUID appointmentId);
}
