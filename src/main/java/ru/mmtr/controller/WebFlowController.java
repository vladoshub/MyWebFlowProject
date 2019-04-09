package ru.mmtr.controller;
import org.springframework.stereotype.Controller;
import org.springframework.webflow.execution.Action;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

@Controller("setMessageController")
public class WebFlowController implements Action {

@Override
public Event execute(RequestContext req) throws Exception {
        String name = req.getRequestParameters().get("inputName");
        req.getFlowScope().put("message", "Hello "+name);
        return new Event(this, "ok");
        }

        }