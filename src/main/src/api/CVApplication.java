// CVApplication.java
package api;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

/**
 * Клас, що налаштовує шлях для API.
 */
@ApplicationPath("/api")
public class CVApplication extends Application {

    /**
     * Повертає множину класів-ресурсів для API.
     * @return Множина класів-ресурсів.
     */
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(CVResource.class);
        return classes;
    }
}


