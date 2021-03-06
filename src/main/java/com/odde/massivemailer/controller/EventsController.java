package com.odde.massivemailer.controller;

import com.odde.massivemailer.model.Event;
import com.odde.massivemailer.serialiser.AppGson;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/events")
public class EventsController extends AppController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String convertedContactToJSON = AppGson.getGson().toJson(Event.findAll());
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.print(convertedContactToJSON);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String resultMsg = "";

        Event event = buildEventObject(req);
        try {
            event.saveIt();
            resultMsg = "status=success&msg=Add event successfully";
        } catch (Exception e) {
            resultMsg = "status=failed&msg=" + e.getMessage();
        }

        resp.sendRedirect("eventlist.jsp?" + resultMsg);
    }

    private Event buildEventObject(HttpServletRequest req) {
        String title = req.getParameter("evtTitle");
        String content = req.getParameter("content");
        String location = req.getParameter("location");

        return new Event(title, content,location);
    }
}
