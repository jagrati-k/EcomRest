package com.example.demo.service;

import org.springframework.stereotype.Service;



import java.io.File;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.mail.Authenticator;
@Service
public class EmailService {
	

	//this is responsible to send email..
	public boolean sendEmail(String message, String subject, String to) {
		boolean flag =false;
		//Variable for gmail
		String host="smtp.gmail.com";
		String from="jagratikhatri98@gmail.com";
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//Step 1: to get the session object..
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("jagratikhatri98@gmail.com", "bnjqsvyhuxerlcvr");
			}
			
			
			
		});
		
		session.setDebug(true);
		
		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
		
		//from email
		m.setFrom(new InternetAddress(from));
		
		//adding recipient to message
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		m.setSubject(subject);
	
		
		//adding text to message
		m.setText(message);
		
		//send 
		m.setContent(message, "text/html");
		//Step 3 : send the message using Transport class
		Transport.send(m);
		
		System.out.println("Sent success...................");
		flag=true;
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
			
	}

}
