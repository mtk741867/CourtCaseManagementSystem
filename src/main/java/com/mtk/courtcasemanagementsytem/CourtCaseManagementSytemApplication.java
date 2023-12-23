package com.mtk.courtcasemanagementsytem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@SpringBootApplication
@ComponentScan(basePackageClasses = com.mtk.courtcasemanagementsytem.controller.homeController.class)
public class CourtCaseManagementSytemApplication {
    private static void openHomePage() throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080/");
    }
    public static void main(String[] args) {

        SpringApplication.run(CourtCaseManagementSytemApplication.class, args);
        try {
            openHomePage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
