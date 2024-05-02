[![Build status](https://ci.appveyor.com/api/projects/status/cch4k5jkd2ps6ayk?svg=true)](https://ci.appveyor.com/project/Nephedov/pageobjects)

# Домашнее задание к занятию «2.4. BDD»

## Решения
### Задание 1
 * <a href="https://github.com/Nephedov/7.1.Automated-Testing/blob/aa5e610d557dfce2ed2e77d28390990fa4ebf722/src/test/java/ru/netology/PageObjectTest.java">PageObjectTest.java</a>. - класс с автотестами.
 * <a href="https://github.com/Nephedov/7.1.Automated-Testing/issues/1#issue-1510355774">Баг-репорт</a> по результатам тестирования.
### Задание 2
 * <a href="https://github.com/Nephedov/7.2.Automated-Testing/blob/3ed31b2ee2be5228f064498e1b0723d5311e7f12/src/test/java/ru/netology/RunCucumberTest.java">RunCucumberTest.java</a>. - класс с автотестами, c описанием опций для Cucumber.
 * <a href="https://github.com/Nephedov/7.2.Automated-Testing/blob/3ed31b2ee2be5228f064498e1b0723d5311e7f12/src/test/java/ru/netology/steps/TemplateSteps.java">TemplateSteps.java</a>. - класс steps для Cucumber.
 * <a href="https://github.com/Nephedov/7.2.Automated-Testing/blob/3ed31b2ee2be5228f064498e1b0723d5311e7f12/src/test/resources/features/MoneyTransfer.feature">MoneyTransfer.feature</a>. - feature для Cucumber c описанием сценария.
## Что было сделано
### Задание 1
* Настроен <a href="https://github.com/Nephedov/7.1.Automated-Testing/blob/d6640c6851ad0f40d365888382b9625910f1c336/build.gradle">build.gradle</a> с зависимостями:
  * JunitJupier.
  * Selenide.
  * Lombok.
* Подключен к проекту AppVeyor. Настроен <a href="https://github.com/Nephedov/7.1.Automated-Testing/blob/d6640c6851ad0f40d365888382b9625910f1c336/.appveyor.yml">appveyor.yml</a>. Добавлен бейдж в README.md, о статусе сборки при пуше.
* Создан <a href="https://github.com/Nephedov/7.1.Automated-Testing/tree/d6640c6851ad0f40d365888382b9625910f1c336/src/test/java/ru/netology/page">репозиторий</a> с файлами описывающими селекторы элементов страниц и методы взаимодействия с ними:
  * <a href="https://github.com/Nephedov/7.1.Automated-Testing/blob/d6640c6851ad0f40d365888382b9625910f1c336/src/test/java/ru/netology/page/DashboardPage.java">DashboardPage.java</a>.
  * <a href="https://github.com/Nephedov/7.1.Automated-Testing/blob/d6640c6851ad0f40d365888382b9625910f1c336/src/test/java/ru/netology/page/LoginPage.java">LoginPage.java</a>.
  * <a href="https://github.com/Nephedov/7.1.Automated-Testing/blob/d6640c6851ad0f40d365888382b9625910f1c336/src/test/java/ru/netology/page/TransactionPage.java">TransactionPage.java</a>.
  * <a href="https://github.com/Nephedov/7.1.Automated-Testing/blob/d6640c6851ad0f40d365888382b9625910f1c336/src/test/java/ru/netology/page/VerificationPage.java">VerificationPage.java</a>.
* Реализован служебный класс <a href="https://github.com/Nephedov/7.1.Automated-Testing/blob/d6640c6851ad0f40d365888382b9625910f1c336/src/test/java/ru/netology/data/DataHelper.java">DataHelper.java</a> содержащий данные о картах.
* Написан класс с автотестами <a href="https://github.com/Nephedov/7.1.Automated-Testing/blob/d6640c6851ad0f40d365888382b9625910f1c336/src/test/java/ru/netology/PageObjectTest.java">PageObjectTest.java</a>.
* Заведен <a href="https://github.com/Nephedov/PageObjects/issues">Баг-репорт</a> по результатам тестирования.
### Задание 2
* Настроен <a href="https://github.com/Nephedov/7.2.Automated-Testing/blob/3ed31b2ee2be5228f064498e1b0723d5311e7f12/build.gradle">build.gradle</a> с зависимостями:
   * JunitJupier.
   * JunitVintage.
   * CucumberJava.
   * CucumberJunit.
   * Selenide.
   * Lombok.
* Подключен к проекту AppVeyor. Настроен <a href="https://github.com/Nephedov/7.2.Automated-Testing/blob/3ed31b2ee2be5228f064498e1b0723d5311e7f12/.appveyor.yml">appveyor.yml</a>. Добавлен бейдж в README.md, о статусе сборки при пуше.
* Создан ряд файлов, для реализации тестового сценария с Cucumber:
  * <a href="https://github.com/Nephedov/7.2.Automated-Testing/blob/3ed31b2ee2be5228f064498e1b0723d5311e7f12/src/test/resources/features/MoneyTransfer.feature">MoneyTransfer.feature</a> - с описанием тестового сценария.
  * <a href="https://github.com/Nephedov/7.2.Automated-Testing/blob/3ed31b2ee2be5228f064498e1b0723d5311e7f12/src/test/java/ru/netology/steps/TemplateSteps.java">TemplateSteps.java</a> - описывающий реализацию и логику работы шагов.
  * <a href="https://github.com/Nephedov/7.2.Automated-Testing/blob/3ed31b2ee2be5228f064498e1b0723d5311e7f12/src/test/java/ru/netology/RunCucumberTest.java">RunCucumberTest.java</a> - класс запускающий тесты с Cucumber.
   
## Задача №1: Page Object's

Вам необходимо добить тестирование функции перевода с карты на карту. Разработчики пока реализовали возможность перевода только между своими картами, но уже хотят, чтобы вы всё протестировали.

Для этого они не поленились и захардкодили вам целого одного пользователя с двумя дебетовыми картами:

После логина, который уже мы сделали на лекции, вы получите список карт.

Нажав на кнопку «Пополнить», вы перейдёте на страницу перевода средств.

При успешном переводе вы вернётесь назад на страницу со списком карт.

Это ключевой кейс, который нужно протестировать.

Нужно, чтобы вы через Page Object's добавили доменные методы:
* перевода с определённой карты на другую карту энной суммы,
* проверки баланса по карте со страницы списка карт.

## Задача №2: BDD (необязательная)

Используя Page Object's из предыдущей задачи, на базе шаблона Cucumber с лекции реализуйте кастомные steps:
* когда пользователь переводит 5 000 рублей с карты с номером 5559 0000 0000 0002 на свою 1 карту с главной страницы,
* тогда баланс его 1 карты из списка на главной странице должен стать 15 000 рублей.

Тогда вместе с логином, который мы сделали на лекции, всё должно выглядеть вот так:
* пусть пользователь залогинен с именем «vasya» и паролем «qwerty123»,
* когда пользователь переводит 5 000 рублей с карты с номером 5559 0000 0000 0002 на свою 1 карту с главной страницы,
* тогда баланс его 1 карты из списка на главной странице должен стать 15 000 рублей.
