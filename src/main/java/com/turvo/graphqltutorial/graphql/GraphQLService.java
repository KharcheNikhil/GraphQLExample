package com.turvo.graphqltutorial.graphql;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import java.io.File;
import java.io.IOException;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GraphQLService {

    private GraphQL graphQL;

    private final AppointmentDataFetcher appointmentDataFetcher;
    private final AllAppointmentDataFetcher allAppointmentDataFetcher;

    @Value("classpath:appointment.graphql")
    private Resource appointmentSchema;

    @PostConstruct
    private void postContruct() throws IOException {
        File schemaFile = appointmentSchema.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
            return RuntimeWiring.newRuntimeWiring()
                .type("Query", wiring ->
                    wiring.dataFetcher("findAll", allAppointmentDataFetcher)
                        .dataFetcher("findById", appointmentDataFetcher)
                ).build();
    }

    public GraphQL getGraphQL(){
        return this.graphQL;
    }
}
