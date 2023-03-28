# SHIFT_Task
## Сборка
- Java 20;
- Gradle 8.1-rc-1;
- Дополнительных зависимостей нет, всё указано в build.gradle.
## Расширение
Чтобы добавить новый вид товара потребуется:
- Добавить новый класс, наследующийся от Product;
- Назначить имя нового товара;
- Добавить имя товара в качестве ключа, а класс - в качестве значения при создании `Map.of` в конструкторе класса `ProductService`;
- Добавить новые методы `add` и `edit` в `ProductController`, по аналогии со стандартными.
## База данных
Используется in memory h2, задаётся в `application.properties`.
## Rest API

### Добавление товара
POST /add/{type}
RequestBody:
```json
{
    "series": 15,
    "producer": "HP",
    "price": 15.888,
    "count": 89,
    "sizeInch": "THIRTEEN"
}
```
ResponseBody:
"Successfully added"

### Редактирование товара
PUT /edit/{type}/{id}
RequestBody:
```json
{
    "series": 18,
    "producer": "Acer",
    "price": 10.888,
    "count": 1,
    "sizeInch": "FIFTEEN"
}
```
ResponseBody:
"Successfully edited"

### Удаление товара
PUT /remove/product/{id}
RequestBody:

ResponseBody:
"Product was removed"

### Получение списка товаров по типу
GET /get/product/{type}
RequestBody:

ResponseBody:
```json
[
    {
        "id": 3,
        "series": 1,
        "producer": "LOL",
        "price": 9.87,
        "count": 1,
        "sizeInch": "THIRTEEN"
    }
]
```

### Получение товара по id
GET /get/id/{id}
RequestBody:

ResponseBody:
```json
{
    "id": 3,
    "series": 1,
    "producer": "LOL",
    "price": 9.87,
    "count": 1,
    "sizeInch": "THIRTEEN"
}
```
