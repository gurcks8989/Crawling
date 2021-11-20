package com.spring.crawling;

import java.util.List;
import java.util.Properties;


import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
 
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.spring.crawling.*; 

public class EmailServiceImpl implements EmailService {
 
	
	
	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	Properties prop = new Properties();
 
    @Override
    public void sendMail(List<CrawlingParamVO> crawlingvo) {
        try {
        	EmailDTO email = new EmailDTO();
        	String keyword = "";
        	mailSender.setHost("smtp.gmail.com");
        	mailSender.setPort(587);
        	mailSender.setUsername("khnemu11@gmail.com");
        	mailSender.setPassword("ehrtnfl03@@");
        	
        	prop.setProperty("mail.transport.protocol", "smtp");
        	prop.setProperty("mail.smtp.auth", "true");
        	prop.setProperty("mail.smtp.starttls.enable", "true");
        	prop.setProperty("mail.debug", "true");
        	prop.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        	prop.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        	
        	mailSender.setJavaMailProperties(prop);
        	
        	for(int i=0;i<crawlingvo.size();i++) {
        		System.out.println("email loop start");
        		email.setSenderMail("khnemu11@gmail.com");
            	email.setReceiveMail(crawlingvo.get(i).getEmail());
            	email.setSenderName("Keyword");
            	
        		if(crawlingvo.get(i).getKeyword1()!=null && 
        				crawlingvo.get(i).getTitle().contains(crawlingvo.get(i).getKeyword1())==true)
        		{
        			keyword = crawlingvo.get(i).getKeyword1();
        		}
        		else if(crawlingvo.get(i).getKeyword2()!=null && 
        				crawlingvo.get(i).getTitle().contains(crawlingvo.get(i).getKeyword2())==true)
        		{
        			keyword = crawlingvo.get(i).getKeyword2();
        		}
        		else if(crawlingvo.get(i).getKeyword3()!=null && 
        				crawlingvo.get(i).getTitle().contains(crawlingvo.get(i).getKeyword3())==true)
        		{
        			keyword = crawlingvo.get(i).getKeyword3();
        		}
        		else if(crawlingvo.get(i).getKeyword4()!=null && 
        				crawlingvo.get(i).getTitle().contains(crawlingvo.get(i).getKeyword4())==true)
        		{
        			keyword = crawlingvo.get(i).getKeyword4();
        		}
        		else if(crawlingvo.get(i).getKeyword5()!=null && 
        				crawlingvo.get(i).getTitle().contains(crawlingvo.get(i).getKeyword5())==true)
        		{
        			keyword = crawlingvo.get(i).getKeyword5();
        		}
            	email.setSubject("[" + keyword +"] " + crawlingvo.get(i).getTitle());
            	email.setMessage("[" +keyword+"] 가 포함된 공지가 올라왔습니다.\n\n 공지번호 : ["+
            			crawlingvo.get(i).getNoticeNum()+"]\n제목 : [" + crawlingvo.get(i).getTitle() +
            			"] \n ["+ crawlingvo.get(i).getLink()+"] ");
            	MimeMessage msg = mailSender.createMimeMessage();
            	 msg.addRecipient(RecipientType.TO, new InternetAddress(email.getReceiveMail()));
            	  msg.addFrom(new InternetAddress[] { new InternetAddress(email.getSenderMail(), email.getSenderName()) });
                  msg.setSubject(email.getSubject(), "utf-8");
                  msg.setText(email.getMessage(), "utf-8");
                  mailSender.send(msg);
                  System.out.println("email send");
        	}
        	System.out.println("email finish");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
