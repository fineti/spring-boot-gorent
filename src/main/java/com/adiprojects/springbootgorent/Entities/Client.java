package com.adiprojects.springbootgorent.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "client")
@Getter
@Setter
public class Client extends User {

    @Column(name = "enable_notifications")
    private boolean enableNotifications;
}
