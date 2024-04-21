//ProcessorLogOut.java

package cv.conroller.processors;

import cv.model.ProcessorResult;
import jakarta.servlet.http.HttpServletRequest;

public class ProcessorLogOut extends Processor{

    public ProcessorLogOut(){
        actionToPerform="logout";
    }



    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        request.getSession().invalidate();
        return new ProcessorResult("pages/welcome.jsp", true, null);
    }
}
