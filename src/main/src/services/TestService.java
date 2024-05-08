package services;

import cv.model.CV;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас, який надає сервісні методи для роботи з резюме.
 */
public class TestService {

    private int lastId = 0;

    // Метод для генерації унікальних ідентифікаторів
    private int generateUniqueId() {
        return ++lastId;
    }

    private List<CV> cvList = new ArrayList<>(); // Список резюме

    /**
     * Отримати всі резюме.
     *
     * @return Список усіх резюме.
     */
    public List<CV> getAllCVs() {
        return cvList;
    }

    /**
     * Створити нове резюме.
     *
     * @param cv Резюме для створення.
     * @return Створене резюме.
     */
    public CV createCV(CV cv) {
        if (cv.getId() == 0) { // Якщо ID резюме не встановлено (0), встановлюємо унікальний ID
            int newId = generateUniqueId();
            cv.setId(newId);
        }
        cvList.add(cv);
        return cv;
    }

    /**
     * Оновити існуюче резюме.
     *
     * @param id Ідентифікатор резюме для оновлення.
     * @param cv Оновлене резюме.
     * @return Відповідь на оновлене резюме.
     */
    public Response updateCV(int id, CV cv) {
        for (int i = 0; i < cvList.size(); i++) {
            if (cvList.get(i).getId() == id) { // Якщо знайдено резюме з вказаним ID, замінюємо його на оновлене
                cvList.set(i, cv);
                return Response.ok(cv).build(); // Повертаємо відповідь з оновленим резюме і статусом ОК
            }
        }
        return Response.status(Response.Status.NOT_FOUND).entity("CV not found").build(); // Повертаємо відповідь з статусом "Не знайдено" та повідомленням про помилку
    }

    /**
     * Видалити резюме за ідентифікатором.
     *
     * @param id Ідентифікатор резюме для видалення.
     */
    public void deleteCV(int id) {
        cvList.removeIf(cv -> cv.getId() == id);
    }

    /**
     * Пошук резюме за ім'ям.
     *
     * @param name Ім'я для пошуку.
     * @return Список знайдених резюме.
     */
    public List<CV> searchCVsByName(String name) {
        List<CV> foundCVs = new ArrayList<>();
        for (CV cv : cvList) {
            if (cv.getName().equalsIgnoreCase(name)) { // Якщо ім'я резюме співпадає з вказаним, додаємо його до списку знайдених
                foundCVs.add(cv);
            }
        }
        return foundCVs;
    }
}
