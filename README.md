# courier-delivery-api

Учебный REST API на Spring Boot, созданный в рамках задания «Подготовка репозитория».

## Используемые технологии

- Java 17 и выше
- Spring Boot 3.5.13
- Maven Wrapper

## Что реализовано

- проект создан через Spring Initializr;
- реализованы простые REST endpoint'ы;
- добавлены демонстрационные данные по теме курьерской доставки;
- подготовлены базовые тесты для контроллеров;
- добавлен workflow для автоматического запуска тестов в GitHub Actions.

## Endpoint'ы

- `GET /api`
- `GET /api/couriers`
- `GET /api/couriers/{id}`
- `GET /api/orders`
- `GET /api/orders/active`

## Запуск приложения

Для запуска требуется JDK 17 или новее.

```powershell
./mvnw.cmd spring-boot:run
```

После запуска приложение будет доступно по адресу `http://localhost:8080`.

## Запуск тестов

```powershell
./mvnw.cmd test
```

## Примеры запросов

```powershell
curl.exe http://localhost:8080/api
curl.exe http://localhost:8080/api/couriers
curl.exe http://localhost:8080/api/orders/active
```

## Ссылка на репозиторий

`https://github.com/LouayK459/lab1-courier-delivery-api`
