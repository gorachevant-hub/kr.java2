# Таблица переходов
| Команда | Откуда | Куда | Условие |
|---|---|---|---|
| submit | DRAFT | SUBMITTED | обязательные поля |
| approve | SUBMITTED | APPROVED | — |
| reject | SUBMITTED | REJECTED | причина от 10 символов |
| cancel | DRAFT, SUBMITTED, APPROVED | CANCELLED | — |
| complete | APPROVED | COMPLETED | текущая дата позже конца |
