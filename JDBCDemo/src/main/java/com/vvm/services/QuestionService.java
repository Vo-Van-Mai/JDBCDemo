/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vvm.services;

import com.mycompany.jdbcdemo.JDBCUtils;
import com.vvm.pojo.Choice;
import com.vvm.pojo.Question;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionService {
    public List<Question> getQuestions(String kw) throws SQLException {
        try (Connection conn = JDBCUtils.getConn()) {
            CallableStatement stm = conn.prepareCall("{CALL gwtQuestions(?)}");
            stm.setString(1, kw);
            
            ResultSet rs = stm.executeQuery();
            
            List<Question> ques = new ArrayList<>();
            
            while(rs.next()) {
                String id = rs.getString("id");
                String content = rs.getString("content");
                
                ques.add(new Question(id, content));
            }
            return ques;
        }
    }
    
    public List<Choice> getChoiceById(String questionId) throws SQLException{
        try (Connection conn = JDBCUtils.getConn()) {
            CallableStatement stm = conn.prepareCall("{CALL getChoiceByQuestionId(?)}");
            stm.setString(1, questionId);
            
            ResultSet rs = stm.executeQuery();
            
            List<Choice> choices = new ArrayList<>();
            
            while(rs.next()) {
                String id = rs.getString("id");
                String content = rs.getString("content");
                boolean corrent = rs.getBoolean("is_correct");
                
                choices.add(new Choice(id, content, corrent));
            }
            return choices;
        }
    }
    
    public int countQuestion() throws SQLException{
        try(Connection conn = JDBCUtils.getConn()) {
            CallableStatement stm = conn.prepareCall("{CALL countQuestion(?)}");
            stm.registerOutParameter(1, Types.INTEGER);
            
            stm.execute();
            return stm.getInt(1);
        }
    }
    
    public int countQuestionByCate(int cateId) throws SQLException{
        try(Connection conn = JDBCUtils.getConn()) {
            CallableStatement stm = conn.prepareCall("{CALL countQuestionByCate(?, ?)}");
            stm.setInt(1, cateId);
            stm.registerOutParameter(2, Types.INTEGER);
            
            stm.execute();
            return stm.getInt(2);
        }
    }

}
