# Web-Lab-3

## Описание проекта

`Web-Lab-3` — это веб-приложение, разработанное с использованием фреймворка JavaServer Faces (JSF). Оно предназначено для проверки попадания заданной пользователем точки в определенную область на координатной плоскости. Приложение состоит из двух Facelets-шаблонов: стартовой страницы и основной страницы приложения.

## Функциональные возможности

- **Стартовая страница**:
  - Отображает ФИО студента, номер группы и номер варианта.
  - Содержит интерактивные часы, показывающие текущие дату и время с обновлением каждые 9 секунд.
  - Предоставляет ссылку для перехода на основную страницу приложения.

- **Основная страница**:
  - Позволяет пользователю задавать координаты точки и радиус области с помощью компонентов ввода.
  - Отображает динамически обновляемое изображение области на координатной плоскости.
    - Пользователь может кликнуть по изображению для задания координат точки; координаты передаются на сервер для проверки попадания в область.
    - Цвет точек на изображении меняется в зависимости от результата проверки (попадание или непопадание в область).
    - При изменении радиуса область и точки на изображении обновляются соответствующим образом.
  - Отображает таблицу с историей результатов предыдущих проверок.
  - Содержит ссылку для возврата на стартовую страницу.

## Технические детали

- **Управляемые бины (Managed Beans)**:
  - Реализуют серверную логику приложения, включая обработку пользовательского ввода, проверку попадания точки в область и управление историей результатов.

- **Валидация данных**:
  - Осуществляется как на стороне клиента (с использованием JavaScript), так и на стороне сервера (с помощью встроенных механизмов JSF), что обеспечивает корректность вводимых данных.

- **Динамическое изображение области**:
  - Реализовано с использованием графических компонентов JSF и дополнительных библиотек, таких как PrimeFaces или ICEfaces, для обеспечения интерактивности и динамического обновления.

- **Хранение результатов**:
  - Все результаты проверок сохраняются в базе данных под управлением СУБД Oracle.
  - Для доступа к базе данных используется Java Persistence API (JPA) с выбранным ORM-провайдером.

- **Управление состоянием**:
  - Для управления списком результатов используется Managed Bean с областью видимости `ApplicationScoped`, что обеспечивает доступ к истории проверок на протяжении всего времени работы приложения.

- **Конфигурация**:
  - Управляемые бины конфигурируются с помощью аннотаций, что упрощает настройку и поддержку кода.
  - Правила навигации между страницами приложения заданы в отдельном конфигурационном файле.

## Используемые технологии

- **JavaServer Faces (JSF)**: Фреймворк для создания компонентных пользовательских интерфейсов в веб-приложениях на Java.

- **Facelets**: Шаблонный язык для JSF, используемый для создания страниц приложения.

- **Java Persistence API (JPA)**: Спецификация для управления постоянными данными в приложениях Java.

- **WildFly**: Сервер приложений Java EE, используемый для развертывания и запуска приложения.

- **PrimeFaces**: Библиотека компонентов UI для JSF, обеспечивающая расширенные возможности пользовательского интерфейса.

- **ICEfaces**: Библиотека компонентов для создания динамических и интерактивных веб-приложений с использованием JSF.

Данное приложение демонстрирует использование современных технологий Java EE для создания интерактивных веб-приложений с богатым пользовательским интерфейсом и надежным управлением данными.
