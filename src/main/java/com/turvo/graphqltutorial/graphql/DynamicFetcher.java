package com.turvo.graphqltutorial.graphql;

import com.turvo.graphqltutorial.model.MyCacheable;
import com.turvo.graphqltutorial.persistence.AppointmentRepository;
import com.turvo.graphqltutorial.persistence.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public interface DynamicFetcher<T extends MyCacheable, ID> {
    Optional<T> retrieve(ID id, DynamicallyUpdatedSource source);
}

