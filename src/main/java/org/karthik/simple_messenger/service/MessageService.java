package org.karthik.simple_messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.karthik.simple_messenger.database.DatabaseClass;
import org.karthik.simple_messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService()
	{
		messages.put(1L, new Message(1,"Hello World","Karthik"));
		messages.put(2L, new Message(2,"Hello Jerse","Karthik"));
	}
	public List<Message> getAllMessages()
	{
		return new ArrayList<Message>(messages.values());
		/*
		Message m1 = new Message(1L,"Hello World","Karthik");
		Message m2 = new Message(1L,"Hello Jerse","Karthik");
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
		*/
	}
	
	public Message getMessage(long id)
	{
		return messages.get(id);
	}
	
	public Message addMessage(Message message)
	{
		message.setId(messages.size()+1);
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message updateMessage(Message message)
	{
		if(message.getId()<=0)
		{
			return null;
		}
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message removeMessage(long id)
	{
		return messages.remove(id);
	}

}
