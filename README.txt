InternetStoreAppInternship
1. Create database shop_intern:
url = jdbc:postgresql://localhost:5432/shop_intern
2. Set properties in application/src/main/resources/application.properties:
    a. dao.config - preferable dao implementation (choose from: json, xml, hibernate, jpa-repository)
    b. spring.liquibase.enabled - if true, liquibase is enabled.
    c. scheduling.enabled - if true, scheduling is enabled and application is inspecting directory search
    for csv format files.
    d. facade.enabled - if true, console interface is enabled and controller layer is switch of, if false - controller
    layer is enabled.
3. Application gives an opportunity to inspect directory application/src/main/resources/csv/search on schedule where
files for updates should be placed. Application.properties searching.file.delay sets scheduling parameter. Files without
errors are parsed in asynchronous mode and moved to save directory, if errors occur files are moved to error directory.
To test parsing from csv place files to application/src/main/resources/csv/search directory
4. File with logs - InternetStoreAppInternship/spring-boot-logging.log.
5. Postman collection for testing application - InternetStoreInternship.postman_collection.json.
6. Users of application are divided into 2 roles: user and admin. Password: password.


