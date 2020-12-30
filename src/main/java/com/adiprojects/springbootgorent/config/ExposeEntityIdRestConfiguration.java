package com.adiprojects.springbootgorent.config;

import com.adiprojects.springbootgorent.Entities.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;


@Configuration
public class ExposeEntityIdRestConfiguration implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Apartment.class, User.class, Host.class, Client.class, Booking.class
        );
    }
}
