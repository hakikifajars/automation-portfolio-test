# Automation Portfolio Test

Automation Portfolio Test adalah project final automation testing yang menggabungkan **Web UI Automation Test** dan **API Automation Test** dalam satu repository.

Project ini dibuat menggunakan **Java, Gradle, Cucumber, Selenium, Rest Assured, JUnit**, dan dijalankan secara otomatis melalui **GitHub Actions**. Test report tersedia dalam bentuk **Cucumber report** dan **Gradle test report** yang dapat diunduh dari artifact pipeline.

## Tech Stack

| Tools / Library    | Fungsi                              |
| ------------------ | ----------------------------------- |
| Java               | Bahasa pemrograman utama            |
| Gradle             | Build tool dan dependency manager   |
| Cucumber           | BDD framework dengan Gherkin syntax |
| Selenium WebDriver | Web UI automation                   |
| Rest Assured       | API automation testing              |
| JUnit              | Test runner                         |
| WebDriverManager   | Browser driver management           |
| GitHub Actions     | CI/CD pipeline                      |
| Cucumber Report    | Test execution report               |

## Test Target

### Web Automation Test

Web automation test menggunakan website:

```text
https://www.demoblaze.com/
```

Test mencakup flow utama e-commerce, mulai dari membuka homepage, sign up, login, menambahkan produk ke cart, hingga checkout berhasil.

### API Automation Test

API automation test menggunakan:

```text
https://dummyapi.io/data/v1
```

Authentication menggunakan header:

```text
app-id: 63a804408eb0cb069b57e43a
```

Referensi API:

```text
https://dummyapi.io/docs
```

## Project Structure

```text
src
└── test
    ├── java
    │   └── portfolio
    │       ├── api
    │       │   ├── requests
    │       │   └── steps
    │       ├── runner
    │       └── web
    │           ├── pages
    │           ├── steps
    │           └── utilities
    └── resources
        └── features
            ├── api_user.feature
            └── web_demoblaze.feature
```

## Web Automation Scenarios

File:

```text
src/test/resources/features/web_demoblaze.feature
```

Scenario yang dibuat:

| No | Scenario                                | Type       |
| -- | --------------------------------------- | ---------- |
| 1  | User can view product list on homepage  | Positive   |
| 2  | User can sign up with valid data        | Positive   |
| 3  | User can login with valid credential    | Positive   |
| 4  | User cannot login with invalid password | Negative   |
| 5  | User can add product to cart            | Positive   |
| 6  | User can checkout product successfully  | End-to-End |

Web automation sudah memenuhi requirement:

* Minimal 5 Web Automation Test
* Minimal 1 negative test
* Minimal 1 End-to-End test sampai checkout berhasil

## API Automation Scenarios

File:

```text
src/test/resources/features/api_user.feature
```

API test mencakup beberapa skenario utama pada DummyAPI, seperti:

| No | Scenario                           | Type     |
| -- | ---------------------------------- | -------- |
| 1  | Get list users                     | Positive |
| 2  | Get list tags                      | Positive |
| 3  | Create new user                    | Positive |
| 4  | Get user detail by id              | Positive |
| 5  | Update user                        | Positive |
| 6  | Delete user                        | Positive |
| 7  | Create user without required field | Negative |

API automation sudah memenuhi requirement:

* Minimal 5 API Automation Test
* Minimal 1 negative test
* Menggunakan header `app-id`

## How to Run Test

### Run All Tests

Windows:

```bash
.\gradlew.bat clean test
```

Mac / Linux:

```bash
./gradlew clean test
```

### Run API Test Only

Windows:

```bash
.\gradlew.bat apiTest
```

Mac / Linux:

```bash
./gradlew apiTest
```

### Run Web Test Only

Windows:

```bash
.\gradlew.bat webTest
```

Mac / Linux:

```bash
./gradlew webTest
```

## Test Report

Setelah test dijalankan, report dapat dilihat pada folder:

```text
build/reports/tests/test/index.html
```

Untuk task tertentu, report juga dapat dilihat pada:

```text
build/reports/tests/apiTest/index.html
build/reports/tests/webTest/index.html
```

Jika menggunakan Cucumber report, hasil report tersedia pada folder:

```text
build/reports/cucumber
```

## GitHub Actions Pipeline

Project ini sudah dilengkapi dengan GitHub Actions workflow untuk menjalankan automation test secara otomatis.

Pipeline menjalankan:

```text
./gradlew clean test
```

atau task terpisah:

```text
./gradlew apiTest
./gradlew webTest
```

Setelah pipeline selesai, report akan diunggah sebagai artifact sehingga dapat diunduh melalui halaman GitHub Actions.

Artifact yang tersedia:

* Cucumber Report
* Gradle Test Report

## Final Project Requirement Checklist

| Requirement                                        | Status |
| -------------------------------------------------- | ------ |
| Web Automation Test menggunakan DemoBlaze          | Done   |
| API Automation Test menggunakan DummyAPI           | Done   |
| Menggunakan app-id pada header API                 | Done   |
| Minimal 5 API Automation Test                      | Done   |
| Minimal 1 API negative test                        | Done   |
| Minimal 5 Web Automation Test                      | Done   |
| Minimal 1 Web negative test                        | Done   |
| Minimal 1 End-to-End test sampai checkout berhasil | Done   |
| Menggunakan Cucumber report / Allure report        | Done   |
| Pipeline berjalan normal                           | Done   |
| Report dapat di-download dari artifact             | Done   |

## Author

Hakiki Fajar
