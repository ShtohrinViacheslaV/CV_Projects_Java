package cv.conroller.processors;

import cv.model.ProcessorResult;
import jakarta.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ProcessorRegistration extends Processor {

    private Properties properties;

    public ProcessorRegistration(Properties properties) {
        actionToPerform = "registration";
        this.properties = properties;
    }

    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        System.out.println("Registration processor.....");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Перевірка наявності користувача
        if (properties.containsKey(username)) {
            String errorMessage = "User '" + username + "' already exists";
            return new ProcessorResult("/pages/welcome.jsp", true, errorMessage);
        }

        // Додаємо нового користувача до властивостей
        properties.setProperty(username, password);

        try (FileOutputStream out = new FileOutputStream("F:\\СумДУ\\3 курс\\2 семестр\\Корпоративна версія Java J2EE\\CV_Projects_Java\\src\\main\\resources\\cv.properties")) {
            properties.store(out, null);
            System.out.println("Registration successful");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to register user");
            // Обробка помилок, якщо файл не може бути записаний
        }

        // Повертаємо результат процесу реєстрації
        return new ProcessorResult("/pages/welcome.jsp", true, null);
    }
}
