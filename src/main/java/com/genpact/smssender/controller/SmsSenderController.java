/**
 * 
 */
package com.genpact.smssender.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.genpact.smssender.pojo.Message;
import com.genpact.smssender.pojo.MessageResponse;
import com.genpact.smssender.service.SmsSenderService;
import com.genpact.smssender.service.impl.SmsSenderServiceImpl;


/**
 * @author sneray
 *
 */
@RestController
@EnableAutoConfiguration
public class SmsSenderController {
	
	

	@RequestMapping(method = RequestMethod.POST, value="/sendSmsService/sendMessage")
	@ResponseBody
	public MessageResponse sendSMS(@RequestBody Message message) {
		
		MessageResponse response = new MessageResponse();
		

		if (!(message.getReceiverNumber().isEmpty() && message.getMessage().isEmpty())) {

			SmsSenderService smsSenderService = new SmsSenderServiceImpl();
			try {

				smsSenderService.sendSmsGateway(message, response);

			} catch (Exception exception) {
				response.setStatus("Error In Controller : " + exception);
			}

		}

		return response;

	}

}
