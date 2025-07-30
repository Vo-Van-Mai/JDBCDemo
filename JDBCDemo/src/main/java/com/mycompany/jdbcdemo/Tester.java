/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jdbcdemo;

import com.vvm.services.QuestionService;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Tester {
    public static void main(String[] args) throws SQLException {
        QuestionService s = new QuestionService();
        
        
        System.out.println(s.countQuestion());
        System.out.println(s.countQuestionByCate(4));

    }
}
