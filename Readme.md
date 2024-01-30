## Spring Data для работы с базами данных
Базовое задание:
Условие:
Вам предстоит создать приложение для управления списком задач с использованием Spring Boot и Spring Data JPA.

### Требуется реализовать следующие функции:
* Добавление задачи. Подсказка метод в контроллере: @PostMapping public Task addTask(@RequestBody Task task)
* Просмотр всех задач. Подсказка метод в контроллере: @GetMapping public List<Task> getAllTasks()
* Просмотр задач по статусу (например, "завершена", "в процессе", "не начата"). 
  * Подсказка метод в контроллере: @GetMapping("/status/{status}") public List<Task> getTasksByStatus(@PathVariable TaskStatus status)
* Изменение статуса задачи. Подсказка метод в контроллере: @PutMapping("/{id}") public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task)
* Удаление задачи. Подсказка метод в контроллере: @DeleteMapping("/{id}") public void deleteTask(@PathVariable Long id)

Репозиторий подсказка public interface TaskRepository extends JpaRepository<Task, Long>

### Структура задачи(класс Task):
- ID (автоинкрементное)(тип Long)
- Описание (не может быть пустым)(тип String)
- Статус (одно из значений: "не начата", "в процессе", "завершена")(Тип TaskStatus )
- Дата создания (автоматически устанавливается при создании задачи)(Тип LocalDateTime)

* Подсказка понадобится энумератор:
enum TaskStatus {
NOT_STARTED, IN_PROGRESS, COMPLETED;
}

ОШИБКА!
org.springframework.beans.factory.UnsatisfiedDependencyException: 
Error creating bean with name 'taskController' defined in file [C:\Projects\Java\Java Spring\SptirngBootDataSemin5\target\classes\com\example\SptirngBootDataSemin5\controllers\TaskController.class]: 
Unsatisfied dependency expressed through constructor parameter 0: 
Error creating bean with name 'taskServiceImpl' defined in file [C:\Projects\Java\Java Spring\SptirngBootDataSemin5\target\classes\com\example\SptirngBootDataSemin5\services\TaskServiceImpl.class]: 
Unsatisfied dependency expressed through constructor parameter 0: 
Error creating bean with name 'taskRepository' defined in com.example.SptirngBootDataSemin5.repositories.TaskRepository defined in @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration: 
Could not create query for public abstract java.util.List com.example.SptirngBootDataSemin5.repositories.TaskRepository.findByStatus(com.example.SptirngBootDataSemin5.model.TaskStatus); Reason: 
Failed to create query for method public abstract java.util.List com.example.SptirngBootDataSemin5.repositories.TaskRepository.findByStatus(com.example.SptirngBootDataSemin5.model.TaskStatus); 
No property 'status' found for type 'Task'