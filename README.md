# Automation Portfolio Test

Project ini berisi automation test framework gabungan untuk Web UI dan API dalam satu repository.

## Tech Stack

- Java
- Gradle
- Cucumber
- Selenium WebDriver
- WebDriverManager
- Rest Assured
- JUnit
- GitHub Actions

## Test Target

### Web UI
- https://www.saucedemo.com/

### API
- https://dummyapi.io/docs

## Struktur Project

- `portfolio.api.requests` berisi request class untuk API
- `portfolio.api.steps` berisi step definition API
- `portfolio.web.pages` berisi Page Object Model untuk UI test
- `portfolio.web.steps` berisi step definition Web UI
- `portfolio.web.utilities` berisi konfigurasi WebDriver
- `portfolio.runner` berisi Cucumber runner
- `src/test/resources/features` berisi file Gherkin

## Cara Menjalankan Test

Menjalankan semua test:

```bash
./gradlew test