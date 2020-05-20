Testing Coverage: 83.3%%

# Web Game Full Stack Project

A full stack project utilising Java with Spring and Javascript with React, paired up with a MySQL database to host a website for an interactive webgame that shows off and utilises skills on all fronts with languages, API's, development and testing.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

A java runtime environment is required on your PC to run this along with a version of Maven to build the project. Having an IDE would also be useful if you wish to edit or test the code, this particular project was done through VSCode.

### Installing

Fork this repository to your own GitHub and then clone it to your PC. From there, the .jar file can be created using the command line.
Open your command line in the main directory of the project and run the following commands to get the program working, using Maven and Java. **Run each command one line at a time!**
'''
    mvn clean package
    cd target
    java -jar webgame-jar-with-dependencies.jar
'''

## Running the tests

Running the tests can be done by opening the source code in an IDE and running the test codes as a JUnit application. Alternatively, opening your command line in the main directory and running the tests via maven will also work, with the command given below.
'''
    mvn clean test
'''

### Coding style tests

Building this application and pushing it forward to a computer or virtual machine hosting Sonarqube will allow the user to anylise the code for coding style issues, bugs and security issues.


## Deployment

The project has been deployed via multiple stages of a CI pipeline. It is first pushed to GitHub, before being retrieved by Jenkins. Jenkins utilises maven to run the unit tests and build the project before pushing it further ahead to both Sonarqube (for more testing) and Nexus, for artifact repositing and hosting the fully built application.


## Built With

* [Spring](https://spring.io) - Open Source Java based framework
* [React](https://reactjs.org) - Javascript library for building user interfaces
* [Grommet](https://v2.grommet.io) - React Javascript library for user interfaces
* [GitHub](https://github.com) - Version Management and Source Code Backup
* [Maven](https://maven.apache.org/) - Dependency Management
* [Jenkins](https://jenkins.io) - Pipeline Automation and Code Building and Deploying
* [Sonarqube](https://www.sonarqube.org) - Java Code Testing
* [Nexus](https://www.sonatype.com/product-nexus-repository) - Build Artifact Repository

## Authors

* **Luke Conway** - *Main author of the source code.*[ConwayQA](https://github.com/ConwayQA)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* **Tadas Vaidotas** - *Trainer for Java spring* - [tvaidotas](https://github.com/tvaidotas)
* **Nick Johnson** - *Massive influence from teaching all aspects of the development for this project.* - [nickrstewarttds](https://github.com/nickrstewarttds)
* **Jordan Harrison** - *Trainer and also Master debugger*

## Project Links

* [Project presentation](https://drive.google.com/open?id=10YrSLOUWwms4jzRhlqcmePx5Ab60vuEKMU6bHRhdKPY)
* [Project ERD](https://drive.google.com/open?id=1YEaggmOUqyGyo12R1i-IjUMmLoWNiign)
* [Project Risk Assessment](https://drive.google.com/open?id=112sqdOrziVAhgpah8ZigPt123q26Bdo2MYziQWCtGJM)
* [MoSCoW User Stories](https://drive.google.com/open?id=1A7fEOvrUXrBWsmfw6Sm9boQLgnjpMNIvwWAqsGN95l0)
* [Project GitHub KANBAN board](https://github.com/ConwayQA/WebGameProject/projects/1)
* [Project UML Diagram](https://drive.google.com/open?id=1OTF-bnJiWcnOYIYN9jTLxQ159iueA2QY)
