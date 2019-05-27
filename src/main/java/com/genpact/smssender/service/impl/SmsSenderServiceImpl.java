/**
 * 
 */
package com.genpact.smssender.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import com.genpact.smssender.pojo.Message;
import com.genpact.smssender.pojo.MessageResponse;
import com.genpact.smssender.service.SmsSenderService;

/**
 * @author sneray
 *
 */
@Service
@EnableAutoConfiguration
public class SmsSenderServiceImpl implements SmsSenderService {
	
	//resding from property file
	@Value("${app.apiKey}")
    public String smsgatewayApiKey;
	

	@Override
	public void sendSmsGateway(Message message,MessageResponse response) throws Exception {
		
		//Trying to check If could able to fetch value from properties file
		response.setStatusCode(smsgatewayApiKey);
		
		try {
			// Construct data
			String apiKey = "apikey=" + "RYhTA3nBA/E-ZjQmd6lkmSxLR0V2l4Jn6srPMsunit";
			String tesmpMessage = "&message=" + message.getMessage();
			String sender = "&sender=" + message.getSenderName();
			String numbers = "&numbers=" + message.getReceiverNumber();
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + tesmpMessage + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
				//JOptionPane.showMessageDialog(null, "message"+line);
			}
			rd.close();
			
			response.setStatus(stringBuffer.toString());
			
		} catch (Exception exception) {
			//JOptionPane.showMessageDialog(null, e);
			response.setStatus("Error SMS From Service : "+exception);
		}
	}

}
