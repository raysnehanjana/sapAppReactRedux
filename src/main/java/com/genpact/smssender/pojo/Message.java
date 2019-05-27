/**
 * 
 */
package com.genpact.smssender.pojo;


/**
 * @author sneray
 *
 */
public class Message {

	private String message;

	private String senderName;

	private String receiverNumber;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the senderName
	 */
	public String getSenderName() {
		return senderName;
	}

	/**
	 * @param senderName the senderName to set
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	/**
	 * @return the receiverNumber
	 */
	public String getReceiverNumber() {
		return receiverNumber;
	}

	/**
	 * @param receiverNumber the receiverNumber to set
	 */
	public void setReceiverNumber(String receiverNumber) {
		this.receiverNumber = receiverNumber;
	}

}
