#language: ru
  Функционал: Ипотека

    @all @fail
    Сценарий: Оформление ипотеки

      Когда Выбрана ипотека на готовое жильё

      Тогда Открыта и подготовлена страница ипотеки

      Когда Заполнены поля:
        |5 180 000|
        |3 058 000|
        |30|

      Тогда Выполнена проверка

      Когда Нажат переключатель Карты Сбербанка
      Тогда Нажат переключатель подтверждения дохода

      Когда Нажат переключатель Молодой Семьи
      Тогда Выполнена проверка
      И Сохранены данные

      Когда Убедились в изменении боковых данных
      Тогда Нажат переключатель подтверждения дохода
      И Сохранены данные
      И Выполнен финальный тест