package com.niit.Collaboration.DAO;

import java.util.List;

import com.niit.Collaboration.model.Event;



public interface EventDAO {

	public boolean save(Event event);
	public boolean update(Event event);
	public Event getEventById(String event_id);
	public List<Event> listEvent();
	public boolean saveOrupdate(com.niit.Collaboration.model.Event event);
}

