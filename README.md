# CV Web Service

Цей проект є веб-сервісом, який надає REST API для роботи з резюме (CV). Він використовує Java та Maven для розробки.

## Endpoints

### GET /api/cvresource

Повертає всі CV в форматі JSON.

### POST /api/cvresource

Створює нове CV. Приймає JSON об'єкт CV в тілі запиту.

### PUT /api/cvresource/{id}

Оновлює існуюче CV з вказаним ID. Приймає JSON об'єкт CV в тілі запиту.

### DELETE /api/cvresource/{id}

Видаляє CV з вказаним ID.

### GET /api/cvresource/search?name={name}

Повертає всі CV, які мають вказане ім'я.

## JSON об'єкт CV

```json
{
    "id": 1,
    "name": "Alex Doe",
    "email": "alex@example.com",
    "profession_id": 1,
    "education": "SumDU",
    "work_experience": "Student jobs at university",
    "skills": "Management"
}

```

# Повернення кодів
API повертає відповідні HTTP коди відповіді. Наприклад, якщо операція пройшла успішно, то код 200. Якщо сталася помилка на сервері - 500. Якщо CV з вказаним ID не знайдено - 404.  
# Розробка
Проект використовує Maven для збірки. Ви можете зібрати проект за допомогою команди mvn clean install.  
# Тестування
Проект включає юніт-тести, які перевіряють основні функції API. Ви можете запустити тести за допомогою команди mvn test.

# CV Resource API Documentation

## Overview

The CVResource API provides endpoints for managing CVs, including operations such as retrieving, creating, updating, and deleting CVs. Additionally, it supports searching for CVs by name.

## Base URL

`/cvresource`

## Endpoints

### `GET /cvresource`

- **Description:** Retrieves all CVs.
- **Method:** GET
- **Response:** JSON array of CV objects.
- **Response Status Codes:**
    - 200: OK - CVs retrieved successfully.
    - 500: Internal Server Error - Failed to retrieve CVs.

### `POST /cvresource`

- **Description:** Creates a new CV.
- **Method:** POST
- **Request Body:** JSON representation of the CV object.
- **Response:** Created CV object.
- **Response Status Codes:**
    - 200: OK - CV created successfully.
    - 500: Internal Server Error - Failed to create CV.

### `PUT /cvresource/{id}`

- **Description:** Updates an existing CV with the specified ID.
- **Method:** PUT
- **Path Parameter:**
    - `id`: The ID of the CV to update.
- **Request Body:** JSON representation of the updated CV object.
- **Response:** Updated CV object or error message if CV is not found.
- **Response Status Codes:**
    - 200: OK - CV updated successfully.
    - 404: Not Found - CV not found.

### `DELETE /cvresource/{id}`

- **Description:** Deletes the CV with the specified ID.
- **Method:** DELETE
- **Path Parameter:**
    - `id`: The ID of the CV to delete.
- **Response:** Success message or error message if CV is not found or ID is invalid.
- **Response Status Codes:**
    - 200: OK - CV deleted successfully.
    - 400: Bad Request - Invalid CV ID format.
    - 404: Not Found - CV not found.

### `GET /cvresource/search`

- **Description:** Searches for CVs by name.
- **Method:** GET
- **Query Parameter:**
    - `name`: The name to search for.
- **Response:** JSON array of CV objects matching the specified name.
- **Response Status Codes:**
    - 200: OK - CVs found successfully.
    - 400: Bad Request - Name parameter is required.
    - 404: Not Found - No CVs found with the specified name.

# CV Application API Testing Documentation

This document outlines the testing procedures and results for the CV Application API.

## Overview

The CV Application API provides endpoints for managing CVs, including operations such as retrieving, creating, updating, and deleting CVs. Additionally, it supports searching for CVs by name.

## Test Cases

### 1. createCV_ValidCV_ReturnsOK

- **Description:** Tests the creation of a valid CV.
- **Test Steps:**
    1. Create a valid CV object with all required fields.
    2. Send a POST request to create the CV.
- **Expected Result:** The API should return a status code of 200 (OK) and the created CV object.

### 2. createCV_InvalidCV_ReturnsInternalServerError

- **Description:** Tests the creation of an invalid CV.
- **Test Steps:**
    1. Create an invalid CV object with missing required fields.
    2. Send a POST request to create the CV.
- **Expected Result:** The API should return a status code of 500 (Internal Server Error).

### 3. updateCV_NonExistingCV_ReturnsNotFound

- **Description:** Tests updating a non-existing CV.
- **Test Steps:**
    1. Specify the ID of a non-existing CV.
    2. Send a PUT request to update the CV.
- **Expected Result:** The API should return a status code of 404 (Not Found).

### 4. deleteCV_ExistingCV_ReturnsOK

- **Description:** Tests deleting an existing CV.
- **Test Steps:**
    1. Specify the ID of an existing CV.
    2. Send a DELETE request to delete the CV.
- **Expected Result:** The API should return a status code of 200 (OK).

### 5. deleteCV_NonExistingCV_ReturnsNotFound

- **Description:** Tests deleting a non-existing CV.
- **Test Steps:**
    1. Specify the ID of a non-existing CV.
    2. Send a DELETE request to delete the CV.
- **Expected Result:** The API should return a status code of 404 (Not Found).

## Test Results

All test cases passed successfully, confirming the proper functionality of the CV Application API.

