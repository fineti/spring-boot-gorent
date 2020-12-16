package com.adiprojects.springbootgorent.config;

import com.adiprojects.springbootgorent.Entities.Apartment;
import com.adiprojects.springbootgorent.Entities.Client;
import com.adiprojects.springbootgorent.Entities.Host;
import com.adiprojects.springbootgorent.Entities.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;


@Configuration
public class ExposeEntityIdRestConfiguration implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Apartment.class, User.class, Host.class, Client.class);
    }
}
