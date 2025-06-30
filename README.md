# 🧠 Task Manager - Spring Boot CRUD Application

A lightweight **Task Manager Tool** built with Spring Boot. This application supports **CRUD operations** for managing Boards, Task Lists, Tasks, and Users assigned to tasks — like a simplified Trello or Kanban board system.

---

## 🚀 Features

- 🗂️ **Board**: Create and manage multiple boards.
- 📝 **Task List**: Each board can have multiple task lists (e.g., To Do, In Progress, Done).
- ✅ **Tasks**: Add, update, move, or delete tasks within lists.
- 👤 **Assignee**: Assign tasks to users (people) with CRUD for users.

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2 / MySQL** (you can switch via `application.properties`)
- **Lombok** (for boilerplate code reduction)
- **Maven** (project build)
- **Postman** (for API testing)

---

## 📁 Project Structure
```
task-manager/
├── src/
│ └── main/
│ ├── java/
│ │ └── com/example/taskmanager/
│ │ ├── controller/
│ │ ├── service/
│ │ ├── model/
│ │ ├── repository/
│ │ └── TaskManagerApplication.java
│ └── resources/
│ └── application.properties
├── pom.xml
```

## ⚙️ Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/task-manager-crud.git
   cd task-manager-crud
   ```

2. **Build the project**

```bash
mvn clean install
```

3. **Run the application**

```bash
mvn spring-boot:run
```

4. **Access API**

**Default URL: http://localhost:8080/api**

## Sample API Endpoints
**Board**
POST /api/boards/make – Create board

GET /api/boards/all – List all boards

GET /api/boards/{id} – Get board by ID

DELETE /api/boards/{id} – Delete board

**Task List**
POST /api/boards/{boardId}/make – Add list to board

GET /api/boards/{boardId}/all – Get lists on a board

Task
POST /api/lists/{listId}/make – Create a task in a list

PUT /api/tasks/{id}/assign/{userId} – Assign user to task

**User**
POST /api/users/make – Add user

GET /api/users/all – View all users

## Notes
Default in-memory database is H2.
To use MySQL, update application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/taskmanager
spring.datasource.username=root
spring.datasource.password=yourpassword

🙋‍♀️ Author
Jhanvi Gopal
📧 jhanugopal11@gmail.com
📌 GitHub: @jhanvig





