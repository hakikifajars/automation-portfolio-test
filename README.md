# Automation Portfolio Test

Automation Portfolio Test adalah project automation testing untuk **Web UI Test** dan **API Test** dalam satu repository. Project ini menggunakan **Java**, **Gradle**, **Cucumber**, **Gherkin**, **Selenium WebDriver**, dan **Rest Assured**.

## Project Requirement

Project ini dibuat untuk memenuhi requirement berikut:

1. Membuat automation test untuk Web UI dan API dalam satu repository.
2. Test case Web dan API menggunakan format Gherkin.
3. Menggunakan Cucumber sebagai library implementasi test.
4. Memisahkan folder/package Java Code, Step Definitions, dan Feature untuk Web dan API.
5. Menyediakan Gradle task untuk menjalankan test berdasarkan tag:
    - `@api`
    - `@web`
6. Membuat report test dalam format HTML.
7. Menambahkan GitHub Actions workflow untuk menjalankan test secara otomatis.
8. Menyediakan dokumentasi project melalui README.

## Tech Stack

Tools dan library yang digunakan:

- Java
- Gradle
- Cucumber
- Gherkin
- Selenium WebDriver
- WebDriverManager
- Rest Assured
- JUnit
- JSON Library

## Project Structure

```text
automation-portfolio-test
├── .github
│   └── workflows
├── src
│   └── test
│       ├── java
│       │   └── portfolio
│       │       ├── api
│       │       │   ├── requests
│       │       │   │   └── UserApiRequest.java
│       │       │   ├── steps
│       │       │   │   └── ApiSteps.java
│       │       │   └── runner
│       │       ├── web
│       │       │   ├── pages
│       │       │   │   ├── BasePage.java
│       │       │   │   ├── CartPage.java
│       │       │   │   ├── HomePage.java
│       │       │   │   ├── LoginPage.java
│       │       │   │   ├── ProductPage.java
│       │       │   │   └── SignupPage.java
│       │       │   └── steps
│       │       └── utilities
│       │           └── DriverManager.java
│       └── resources
│           └── features
│               ├── api_user.feature
│               └── web_demoblaze.feature
├── build.gradle
└── README.md