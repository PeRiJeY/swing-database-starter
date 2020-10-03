# swing-database-starter-1.0.0
A Sample Swing Database / CRUD Application. 


## Description
A sample Swing Database / CRUD Application / MDI (Multi Documents Interface) to help developers quickly start new project... 
The application is pre-configured with Maven, Log4j and auto load properties files under `resources` folder.  

## Dev tools
* Java 
* JDK 1.8
* AWT
* Swing
* MDI (Multi Documents Interfaces)
* Maven
* Log4j
* Java Properties config files
* Hibernate
* H2 Database
* MySQL

## Demo
The demo folder contain a built final jar with dependencies that you can run to have an idea on the application: 

java -jar swing-database-starter.jar &

## Clone and create your project
To use this code in your project or to start a new application using this approach you can type in terminal : 

`$ git clone https://github.com/PeRiJeY/swing-database-starter.git /your-local-path/your-project-name`

Also in **pom.xml** file change : 
`<artifactId>swing-database-starter</artifactId>`

To : 
`<artifactId>your-project-name</artifactId>`

Modify hibernate.cfg.xml to configure database connection

## MySQL or MariaDB
* Tested with MariaDB 5.5.68 64Bits
* DB Browser: HeidiSQL 10.2.64
