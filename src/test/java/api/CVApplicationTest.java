
package api;

import cv.model.CV;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.TestService;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Клас для тестування ресурсу CV.
 */
class CVApplicationTest {

    private CVResource cvResource;
    private TestService testService; // Add this line


    @BeforeEach
    void setUp() {
        cvResource = new CVResource();
    }


    @org.junit.jupiter.api.Test
    void getClasses() {
    }

    @org.junit.jupiter.api.Test
    void getAllCVs() {
    }

    @org.junit.jupiter.api.Test
    void createCV() {
    }

    @org.junit.jupiter.api.Test
    void updateCV() {
    }

    @org.junit.jupiter.api.Test
    void deleteCV() {
    }

    @org.junit.jupiter.api.Test
    void searchCVsByName() {
    }

    @Test
    void createCV_ValidCV_ReturnsOK() {
        CV cv = new CV();

        cv.setId(1);
        cv.setName("Alex Doe");
        cv.setEmail("alex@example.com");
        cv.setProfession_id(1);
        cv.setEducation("SumDU");
        cv.setWork_experience("Student jobs at university");
        cv.setSkills("Management");


        // Act
        Response response = cvResource.createCV(cv);

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertNotNull(response.getEntity());
        assertTrue(response.getEntity() instanceof CV);
    }

    @Test
    void createCV_InvalidCV_ReturnsInternalServerError() {
        // Create a CV with missing required fields
        CV cv = new CV();

        // Act
        Response response = cvResource.createCV(cv);

        // Assert
        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
        assertNull(response.getEntity());
    }


    @Test
    void updateCV_NonExistingCV_ReturnsNotFound() {
        // Assuming there is no CV with ID = 1000
        int id = 1000;
        CV cv = new CV();
        cv.setName("Updated Name");

        // Act
        Response response = cvResource.updateCV(id, cv);

        // Assert
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
        assertNull(response.getEntity());
    }

    @Test
    void deleteCV_ExistingCV_ReturnsOK() {
        // Assuming there is an existing CV with ID = 1
        int id = 1;

        // Act
        Response response = cvResource.deleteCV(String.valueOf(id));

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    void deleteCV_NonExistingCV_ReturnsNotFound() {
        // Assuming there is no CV with ID = 1000
        int id = 1000;

        // Act
        Response response = cvResource.deleteCV(String.valueOf(id));

        // Assert
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }
}
