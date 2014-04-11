/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.inosoft.dev.javaeejms;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author debiandev
 */
@MessageDriven(mappedName = "jms/queue/myqueue") 
public class Consumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            BusinessObject payload = message.getBody(BusinessObject.class);
            System.out.println("Message received: " + payload + " . " + payload.getText());
        } catch (JMSException e) {
            System.err.println("Error while fetching message payload: " + e.getMessage());
        }
    }
}