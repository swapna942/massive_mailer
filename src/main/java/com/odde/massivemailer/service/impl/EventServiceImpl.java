package com.odde.massivemailer.service.impl;

import com.odde.massivemailer.exception.EventAlreadyExistsException;
import com.odde.massivemailer.model.Event;
import com.odde.massivemailer.service.EventService;

import java.util.*;

public class EventServiceImpl implements EventService {
    private Map<Integer, Event> events = new LinkedHashMap<>();

    public int addEvent(Event event)
            throws EventAlreadyExistsException {

        if (event.getTitle() == null ||
                event.getTitle().isEmpty())
            throw new IllegalArgumentException("Event title is mandatory");

        if (events.containsValue(event))
            throw new EventAlreadyExistsException(
                    String.format("Event '%s' is already exist", event.getTitle()));

        events.put(events.size() + 1, event);
        return events.size();
    }

    @Override
    public List<Event> getAll() {
        return new ArrayList<>(events.values());
    }
}