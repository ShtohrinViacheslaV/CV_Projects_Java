package cv.conroller;

import cv.conroller.processors.*;
import cv.model.ProcessorResult;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CVServlet", urlPatterns = "/cvservlet")
public class CVServlet extends HttpServlet {

    private List<Processor> processorList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Init method .......");
        processorList.add(new ProcessorMainPage());
        processorList.add(new ProcessorIT());
        processorList.add(new ProcessorMarketing());
        processorList.add(new ProcessorFinance());
        // Додайте сюди інші процесори, якщо потрібно
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null || action.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "index.jsp");
            return;
        }

        System.out.println("In servlet for action: " + action);

        for (Processor processor : processorList) {
            if (processor.canHandle(action)) {
                ProcessorResult processorResult = processor.handle(req);
                if (processorResult.getIncludedPage() != null) {
                    req.getSession().setAttribute("includedPage", processorResult.getIncludedPage());
                }
                if (processorResult.isForward()) {
                    req.getRequestDispatcher(processorResult.getUrl()).forward(req, resp);
                } else {
                    // Перевіряємо чи існує параметр id та перенаправляємо на сторінку cv.jsp з відповідним id
                    String id = req.getParameter("id");
                    if (id != null && !id.isEmpty()) {
                        resp.sendRedirect("cv.jsp?id=" + id);
                    } else {
                        resp.sendRedirect(processorResult.getUrl());
                    }
                }
                return;
            }
        }

        // Якщо не знайдено відповідний процесор, перенаправляємо на головну сторінку
        resp.sendRedirect(req.getContextPath() + "index.jsp");
    }
}



