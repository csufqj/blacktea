package fqj.csu;


import fqj.csu.dao.ImageDAO;
import fqj.csu.dao.LoginTicketDAO;
import fqj.csu.dao.UserDAO;
import fqj.csu.model.Image;
import fqj.csu.model.LoginTicket;
import fqj.csu.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BlackTeaApplication.class)
//@Sql("/init-schema.sql")
public class InitDatabaseTests {


    @Autowired
    UserDAO userDAO;

    @Autowired
    ImageDAO imageDAO;

    @Autowired
    LoginTicketDAO loginTicketDAO;

    @Test
    public void initDatabase() {
//        Random random = new Random();
//        for(int i= 0;i<5;i++) {
//            Image image = new Image();
//            image.setUserId(0);
//            image.setOldName("1.jpg");
//            image.setImagePath(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
//            imageDAO.addImage(image);
//        Image image = imageDAO.selectById(1);
//        System.out.println(image.getImagePath());

//            Random random = new Random();
//            LoginTicket ticket = new LoginTicket();
//            ticket.setUserId(0);
//            Date date = new Date();
//            ticket.setLoginTime(date);
//            Date date2 = new Date();
//            date2.setTime(date.getTime() + 1000*3600*24);
//            ticket.setExpired(date2);
//            ticket.setStatus(0);
//            ticket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
//            loginTicketDAO.addTicket(ticket);

//            Image image = new Image();
//            image.setName("1.jpg");
//            image.setPath("/xxx");
//            image.setUserId(0);
//            image.setPredict(0);
//            Date date = new Date();
//            image.setCreatedDate(date);
//            imageDAO.addImage(image);
//                    Random random = new Random();
////                    for(int i= 0;i<11;i++) {
//                        User user = new User();
//                        user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
//                        user.setName(String.format("USER"));
//                        user.setPassword("");
//                        user.setSalt("");
//                        userDAO.addUser(user);
//                        user.setPassword("xxx");
//                        userDAO.updatePassword(user);
////                      }



//            question.setCommentCount(i);
//            Date date = new Date();
//            date.setTime(date.getTime() + 1000*3600*i);
//            question.setCreatedDate(date);
//            question.setUserId(i+1);
//            question.setTitle(String.format("TITLE{%d}", i));
//            question.setContent(String.format("Balalalala Content %d", i));
//            questionDAO.addQuestion(question);
    }
}
