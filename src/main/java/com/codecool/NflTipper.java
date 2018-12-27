package com.codecool;

import com.codecool.mock.Mock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@SpringBootApplication
public class NflTipper {
    public static void main(String[] args) {
        SpringApplication.run(NflTipper.class, args);
    }
}
