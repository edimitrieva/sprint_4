# sprint_4
/*
Структура проекта 

В данном проекте реализованы основные и дополнительные тесты для сайта Самокат.

Основные сценарии:
1. Раздел "Вопросы о важном" реализован в классе TestQuestionAboutImportant. 
Локаторы и методы объявлены в классе QuestionAboutImportant.
2. Заказ самоката. Весь позитивный флоу реализован в классе TestPositiveForOrder
Локаторы и методы объявлены в классе OrderPage

Дополнительные сценарии:
1. Проверка логотипа Самокат реализована в классе TestLogo
Локаторы и методы объявлены в классе Header
2. Проверка логотипа Яндекс реализована в классе TestLogo
Локаторы и методы объявлены в классе Header
3. Проверки ошибок для всех полей формы заказа реализованы в классе TestNegativeForOrder
Локаторы и методы объявлены в классе OrderPage
4. Поиск по некорректному номеру заказа реализован в классе TestWrongNumberOrder
Локаторы и методы объявлены в классе SearchResult

Локаторы и методы Главной страницы определены в классе MainPage. Используются в разных тестах.
В классе Constants определены URL страницы Самокат и Дзен.

Класс BaseClass является родительским, все тестовые классы наследуются от него. Содержит метод ожидания видимости элемента. Данный метод используется в разных классах.

Класс BaseTest содержит настройки браузера и его закрытие после выполнения теста.

*/