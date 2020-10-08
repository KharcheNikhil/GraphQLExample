package com.turvo.graphqltutorial.model;

import com.turvo.graphqltutorial.graphql.UserFetcher;
import io.leangen.graphql.annotations.GraphQLId;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLTypeResolver;
import io.leangen.graphql.annotations.types.GraphQLType;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@GraphQLType(name = "AppointmentDocument")
@Document(collection = "appointmentFormFieldData")
public class Appointment {

    @Id
    @Field("_id")
    @GraphQLId
    private String id;

    @Field("appointment_id")
    @GraphQLQuery(name = "appointmentId")
    private UUID appointmentId;

    @Field("confirmation_number")
    @GraphQLQuery(name = "confirmationNumber")
    private String confirmationNumber;

    @GraphQLQuery(name = "createdBy")
    @Field
    private UserFragment createdBy;

}
