package com.mody;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class App {
    public static void main(String[] args) throws Exception {
        new OrderService().run(args);
    }

    @Override
    public void run(OrderServiceConfiguration configuration, Environment environment) {
        environment.jersey().register(new OrderResource());
        environment.jersey().register(new JsonProcessingExceptionMapper(true));
    }

    public static class OrderServiceConfiguration extends Configuration {
        @Valid
        @NotNull
        private String apiKey;

        @JsonProperty
        public String getApiKey() {
            return apiKey;
        }

        @JsonProperty
        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }
    }

    @Path("/orders")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public static class OrderResource {
        @POST
        public Response createOrder(Order order) {
            // Stubbed out database insertion
            System.out.println("Inserting order into database: " + order);

            return Response.ok("Order created successfully").build();
        }
    }
}