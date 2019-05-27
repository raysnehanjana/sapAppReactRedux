/**
 * 
 */
package com.genpact.smssender.service;

import com.genpact.smssender.pojo.Message;
import com.genpact.smssender.pojo.MessageResponse;

/**
 * @author sneray
 *
 */
public interface SmsSenderService {
	
	public void sendSmsGateway(Message message, MessageResponse response) throws Exception;

}
