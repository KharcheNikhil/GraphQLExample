package com.turvo.graphqltutorial.graphql;

import com.turvo.graphqltutorial.model.Appointment;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import io.leangen.graphql.GraphQLSchemaGenerator;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GraphQLConfiguration {

  private final AppointmentDataFetcher appointmentDataFetcher;
  private final AllAppointmentDataFetcher allAppointmentDataFetcher;

  @Bean
  public GraphQL getGraphQL() {
    GraphQLSchema schema = new GraphQLSchemaGenerator()
        .withBasePackages("com.turvo.graphqltutorial.model")
        .withOperationsFromSingleton(allAppointmentDataFetcher)
        .withOperationsFromSingleton(appointmentDataFetcher).generate();
    return GraphQL.newGraphQL(schema).build();
  }
}
