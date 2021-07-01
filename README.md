CrudConsole Описание Необходимо реализовать консольное CRUD приложение, которое имеет следующие сущности:

Team Developer Skill TeamStatus (enum ACTIVE, DELETED)

Team -> List developers + Developer developer

Developer -> List skills + Skill skill

В качестве хранилища данных необходимо использовать json: teams.json, developers.json, skills.json

Пользователь в консоли должен иметь возможность создания, получения, редактирования и удаления данных.

Слои:

main.java.com.arman.crud.model - POJO клаcсы 

main.java.com.arman.crud.repo - классы, реализующие доступ к json с помощью библиотеки gson 

main.java.com.arman.crud.controller - обработка запросов от пользователя 

main.java.com.arman.crud.view - все данные, необходимые для работы с консолью

Инструкция по запуску

1) Скачать приложение

2) Перейти в репозиторий по ссылке https://github.com/ArmanBekmuratov/Crud-console-app

3) Кликнуть зеленую кнопку "Code" в правой верхней части страницы.

4) Распаковать архиватором

5) Открыть проект в intellij idea

6) Запустить класс main.java.com.arman.crud.Main
