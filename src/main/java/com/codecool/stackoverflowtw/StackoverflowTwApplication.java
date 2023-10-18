package com.codecool.stackoverflowtw;

//import com.codecool.stackoverflowtw.questions.dao.QuestionsDAO;
//import com.codecool.stackoverflowtw.questions.dao.QuestionsDaoJdbc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class StackoverflowTwApplication {

    public static void main(String[] args) {
        SpringApplication.run(StackoverflowTwApplication.class, args);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    /*public QuestionsDAO questionsDAO() {
        return new QuestionsDaoJdbc();
    }*/
}
