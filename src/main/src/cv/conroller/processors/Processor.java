package cv.conroller.processors;

import cv.model.ProcessorResult;
import jakarta.servlet.http.HttpServletRequest;

public abstract class Processor {

    protected String actionToPerform;

    public boolean canHandle(String action){
        return actionToPerform.equals(action);
    }

    public abstract ProcessorResult handle(HttpServletRequest request);
}

