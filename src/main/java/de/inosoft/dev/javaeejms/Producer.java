/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.inosoft.dev.javaeejms;

import java.util.UUID;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author debiandev
 */
@Stateless
@Path("/jms20")
public class Producer {
    @Resource(lookup = "jms/queue/myqueue")
    private Queue queue;

    @Inject
    private JMSContext jmsContext;

    
    @GET
    public String produce() {
        
        for (int i = 0 ; i < 10; i ++){
            BusinessObject payload = new BusinessObject("msg: " + i + " " +UUID.randomUUID().toString());
            System.out.println("sending message " + payload.getText());
            jmsContext.createProducer().send(queue, payload);
        }
        return "OK";
    }
}
