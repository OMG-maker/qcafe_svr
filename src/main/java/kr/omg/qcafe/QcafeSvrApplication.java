package kr.omg.qcafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class QcafeSvrApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(QcafeSvrApplication.class, args);
    }
}
