package com.turvo.graphqltutorial.model;

import io.leangen.graphql.annotations.GraphQLId;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.tomcat.jni.Time;
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

    @GraphQLQuery(name = "longString")
    private String longString;


    @SneakyThrows
    public String getLongString(){
        Thread.sleep(10000);
        return "Some Long string after caculated too much CPU intensive operation,";
    }

}
