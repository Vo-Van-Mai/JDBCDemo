/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.jdbcdemo;

import com.vvm.pojo.Question;
import com.vvm.services.QuestionService;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class JDBCDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        QuestionService s = new QuestionService();
        
//        s.getQuestions("").forEach(q -> System.out.println(q.getContent()));
        List<Question> questions = s.getQuestions("");
        for (var q: questions ){
            System.out.println(q.getContent());
            q.setChoice(s.getChoiceById(q.getId()));
            
            for (int i = 0; i < q.getChoice().size(); i++)
                System.out.printf("%d - %s\n", i+1, q.getChoice().get(i).getContent());
            
            System.out.print("Your choice (1 - 4): ");
            int c = sc.nextInt();
            
            if (q.getChoice().get(c-1).isCorrect())
                System.out.println("EXACTLY");
            else
                System.out.println("WRONGLY");
        }
    }
}
