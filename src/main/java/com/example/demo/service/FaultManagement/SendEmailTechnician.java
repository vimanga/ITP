package com.example.demo.service.FaultManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.FaultManagement.Fault;
import com.example.demo.model.FaultManagement.Technicianfault;

@Service
public class SendEmailTechnician {
	
	private JavaMailSender mailsender;
	
	@Autowired
	public SendEmailTechnician(JavaMailSender mailsender) {
		this.mailsender=mailsender;
	}

	public void sendTechEmail(Fault fault, Technicianfault tech) throws MailException {
		
		String mm = null;
		String fname= null;
		
		try{
				
				String sql = "select firstName,email from employee where empID="+tech.getEmpid()+"";
				System.out.println(sql);
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false", "root", "root");
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				
				while (rs.next()){
					
					fname=rs.getString("firstName");
					mm = rs.getString("email");
					System.out.println(mm);
				}
				
				
				
			}
		
			catch(Exception e){
				
				e.printStackTrace();
				System.out.println("Error : " + e.getMessage());
			}
	
		System.out.println(mm);
		
		SimpleMailMessage simplemail = new SimpleMailMessage();
		simplemail.setTo(mm);
		simplemail.setFrom("abslpvt123@gmail.com");
		simplemail.setSubject("New Case");
		simplemail.setText("Hello " + fname+ ",\n"+"Below are the details of the case you are assigned\nJob ID\t"+fault.getFaID()+"\nNature of job\t"+fault.getNature()+"\n"+fault.getDescrip()+"\n"+fault.getCliID()+"\nGood Luck!\n");

		mailsender.send(simplemail);
	}

}
