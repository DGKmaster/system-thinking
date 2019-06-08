# System-Thinking Team

[![Build Status](https://travis-ci.org/DGKmaster/system-thinking.svg?branch=dgk)](https://travis-ci.org/DGKmaster/system-thinking)

## Описание

Приложение и сервер по созданию туристических маршрутов. 

---

## Технологический стек

1. Java 11
1. Spring MVC
1. Tomcat 9
1. Docker 18.09
1. PostgreSQL
1. Travis CI

---

## Взаимодействие между приложением и сервером

### Пример запроса

```url
http://localhost:9090/server?sort_by=SORT_BY_POPULARITY&page=1
```

### Пример ответа

```json
{
    "string": "foo",
    "number": 5,
    "array": [1, 2, 3],
    "object": {
        "property": "value" ,
        "subobj": {
            "arr": ["foo", "ha"],
            "numero": 1
            }
        }
    }
```
