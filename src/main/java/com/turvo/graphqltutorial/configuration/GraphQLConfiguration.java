package com.turvo.graphqltutorial.configuration;

import com.turvo.graphqltutorial.graphql.AllAppointmentDataFetcher;
import com.turvo.graphqltutorial.graphql.AppointmentDataFetcher;
import com.turvo.graphqltutorial.graphql.AppointmentMutations;
import com.turvo.graphqltutorial.model.Appointment;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.servlet.SimpleGraphQLHttpServlet;
import io.leangen.graphql.GraphQLSchemaGenerator;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GraphQLConfiguration {

  @Bean
  public GraphQL getGraphQL(GraphQLSchema schema) {
    return GraphQL.newGraphQL(schema).build();
  }

  @Bean
  public GraphQLSchema schema(AppointmentDataFetcher appointmentDataFetcher, AllAppointmentDataFetcher allAppointmentDataFetcher, AppointmentMutations appointmentMutations) {
    return new GraphQLSchemaGenerator()
        .withBasePackages("com.turvo.graphqltutorial.model")
        .withOperationsFromSingleton(allAppointmentDataFetcher)
        .withOperationsFromSingleton(appointmentDataFetcher)
        .withOperationsFromSingleton(appointmentMutations)
        .generate();
  }

  @Bean
  public ServletRegistrationBean graphQLServlet(GraphQLSchema schema) {
    return new ServletRegistrationBean(SimpleGraphQLHttpServlet.newBuilder(schema).build(),"/graphql");
  }

  @Bean
  public CacheManager cacheManager(){
    return new ConcurrentMapCacheManager();
  }
}
