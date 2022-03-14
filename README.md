# Simple Notepad
## Applied technologies:
- Spring MVC pattern;
- Spring Boot: (Web, Data, Security, DevTools, Mail);
- Spring Session JDBC;
- Hibernate (Entitymanager, Validator);
- FreeMarker;
- Bootstrap 5;
- PostgreSQL.

## Functionality for users:
- Registration;
- Authorization (for registered users);
- Adding/changing/deleting notes;
- Viewing your own notes.

## Functionality for the administrator: 
- Authorization in the system (to log in use __username: admin, password: admin__);
- Adding/changing/deleting notes;
- Adding/changing/deleting users;
- Viewing your own notes.

## Instructions for deploying the application

### If you assemble it yourself
1. Сreate an empty postgre database
2. In application.properties file replace the following lines with your own data:
```sh
spring.datasource.url=jdbc:postgresql://localhost/nameDB
spring.datasource.username=postgres
spring.datasource.password=postgres
```
3. In the same file, change your email username, password and data for outgoing mail (this can be viewed on the website of the mail you use. You should also allow sending in the settings on the official website)
```sh
spring.mail.username=your username
spring.mail.password=your password

spring.mail.host=host
spring.mail.port=port
spring.mail.protocol=protocol
```
4. In pom.xml change the java version to your own
5. Run project

### If you use a Docker
1. Download a folder "scr/main/docker" from the project.
2. Go to the folder via the docker console (cd ..../docker)
3. Write in the console: _docker-compose up_

Attention!!!
You will not be able to change the email from which messages are sent
# Application description
When you launch the application, you will see this page. It will be possible to login or register on it in the upper right corner.

![Image alt](https://github.com/Mercur1y/notepad/blob/main/images/welcome.png)

After filling in the registration fields, the user is added to the database. If you specify a real or temporary e-mail, you will receive an email with a link to the account activation page.

![Image alt](https://github.com/Mercur1y/notepad/blob/main/images/registration.png)

Then, after successful authentication, the user's name and the count of his notes appear on the main page.

![Image alt](https://github.com/Mercur1y/notepad/blob/main/images/iflogin.png)

Going to the note creation page, you can enter the text and click add. If the text field has been filled in, you will see a message about the successful addition.

![Image alt](https://github.com/Mercur1y/notepad/blob/main/images/add.png)

On the My Notes page you will be able to see the created note (and others if there are any). When you click the edit button, the note id is transferred to the form and you can change it.

![Image alt](https://github.com/Mercur1y/notepad/blob/main/images/edit.png)

The User List tab contains a list of users with the ability to edit their name, assign an admin role, or delete.

![Image alt](https://github.com/Mercur1y/notepad/blob/main/images/userlist.png)

