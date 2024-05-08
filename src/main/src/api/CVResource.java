package api;

import cv.model.CV;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import services.TestService;

import java.util.List;

/**
 * Клас, що представляє ресурс CV та надає методи для роботи з ним.
 */
@Path("/cvresource")
public class CVResource {

    private TestService testService = new TestService();

    /**
     * Отримує всі CV.
     * @return Всі CV у форматі JSON.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCV() {
        return Response.ok(testService.getAllCVs()).build();
    }

    /**
     * Створює нове CV.
     * @param cv Об'єкт CV для створення.
     * @return Створене CV у форматі JSON.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCV(CV cv) {
        CV createdCV = testService.createCV(cv);
        if (createdCV != null) {
            return Response.ok(createdCV).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to create CV").build();
        }
    }

    /**
     * Оновлює існуюче CV за його ідентифікатором.
     * @param id Ідентифікатор CV, яке потрібно оновити.
     * @param cv Нові дані CV для оновлення.
     * @return Оновлене CV у форматі JSON або повідомлення про помилку, якщо CV не знайдено.
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCV(@PathParam("id") int id, CV cv) {
        Response updatedCV = testService.updateCV(id, cv);
        if (updatedCV != null) {
            return Response.ok(updatedCV).build(); // Повертає відповідь із оновленим CV
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("CV not found").build(); // Повертає відповідь із статусом Not Found та повідомленням про помилку
        }
    }

    /**
     * Видаляє CV за його ідентифікатором.
     * @param id Ідентифікатор CV, яке потрібно видалити.
     * @return Відповідь про успішне видалення або повідомлення про помилку, якщо CV не знайдено.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteCV(@PathParam("id") String id) {
        try {
            int cvId = Integer.parseInt(id);
            testService.deleteCV(cvId);
            return Response.ok().build();
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid CV ID format").build();
        }
    }

    /**
     * Пошук CV за ім'ям.
     * @param name Ім'я, за яким потрібно здійснити пошук.
     * @return Знайдені CV у форматі JSON або повідомлення про помилку, якщо CV не знайдено.
     */
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchCVsByName(@QueryParam("name") String name) {
        if (name == null || name.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Name parameter is required").build();
        }

        List<CV> foundCVs = testService.searchCVsByName(name);
        if (!foundCVs.isEmpty()) {
            return Response.ok(foundCVs).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("No CVs found with the specified name").build();
        }
    }
}

