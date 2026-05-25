JSONPlaceholder API Testing Framework

Descriere generală:
Acest proiect reprezintă un framework de testare automată pentru API ul JSONPlaceholder, construit în Java, folosind RestAssured, TestNG și Allure Reports. Framework ul acoperă scenarii pozitive și negative, validează status code uri, payload uri și generează rapoarte Allure cu Behaviors, Epic, Feature și Story.
🛠️ Tehnologii utilizate
•	Java 17
•	Maven
•	RestAssured
•	TestNG
•	Allure Reports 2.23.0
•	JSONPlaceholder API
•	IntelliJ IDEA
•	GitHub Actions (CI)

Structura proiectului:
src
 ├── main
 │    └── java
 │         └── com.jsonplaceholder.api.api
 │              └── App.java
 └── test
      ├── java
      │    ├── config
      │    ├── models
      │    ├── services
      │    └── tests
      └── resources
           ├── allure.properties
           ├── config.properties
           └── environment.properties

Explicații:
•	config – citirea configurațiilor (URL, timeout etc.)
•	models – obiecte DTO pentru request/response
•	services – logica de request (GET/POST/PUT/DELETE)
•	tests – testele efective, grupate pe endpoint-uri și scenarii



Cum rulezi testele:
 Rulezi testele TestNG:
mvn clean test

Generezi raportul Allure:
          allure serve target/allure-results

Raportul include:
•	Overview
•	Suites
•	Behaviors (Epic, Feature, Story)
•	Timeline
•	Graphs
  Scenarii acoperite:
•	GET post valid
•	GET post invalid
•	POST creare post valid
•	POST creare post invalid
•	PUT update valid
•	PUT update invalid
•	DELETE valid
•	DELETE invalid

Fiecare test include:
•	Validare status code
•	Validare body
•	Allure steps
•	Allure labels (Epic, Feature, Story, Severity)

  Integrare Allure Behaviors:
Framework-ul folosește:
•	@Epic("JSONPlaceholder API")
•	@Feature("Posts API")
•	@Story("Create Post") etc.
Acestea permit gruparea testelor în raportul Allure într-un mod clar și profesionist.

Integrare CI/CD cu GitHub Actions:
Proiectul include un pipeline CI configurat cu GitHub Actions, care rulează automat testele la fiecare push sau pull request. Workflow-ul execută:
•	instalarea dependențelor Maven
•	rularea testelor TestNG
•	generarea rezultatelor Allure
•	arhivarea allure-results ca artifact
Această integrare permite verificarea continuă a stabilității proiectului și oferă vizibilitate asupra rezultatelor testelor direct din GitHub.

Concluzie:
Acest framework demonstrează:
• bune practici în testarea API
• raportare Allure completă
• scenarii pozitive și negative
• integrare CI/CD cu GitHub Actions

Autor:
 Victoria QA Automation Tester creat pentru portofoliu profesional și dezvoltare continuă.
