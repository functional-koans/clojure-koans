# Clojure Koans

Для того чтобы приступить к решению Clojure коанов, следуйте инструкциям ниже.


## Установка

Прежде всего клонируйте репозиторий или создайте свой форк. Далее вы можете создать отдельную ветку
чтобы избежать конфликтов при обновлении коанов.

Способы установки зависимостей:

- Установите все зависимости локально
- Используйте Vagrant
- Используйте Docker

Инструкции для каждого для реализации каждого способа ниже.


### Локальная установка

Вам необходимо:

- JDK (от 6 до 8 версии)
- [Leiningen](http://github.com/technomancy/leiningen), инструмент сборки для Clojure

После этого выполните в клонированной папке:

```
lein repl
```

Leiningen скачает все зависимости, затем наберите `(exit)` чтобы выйти.


### Установка, используя Vagrant

Установите [Vagrant](https://www.vagrantup.com/) и
[VirtualBox](https://www.virtualbox.org).
В корневой директории выполните:

```
vagrant up
vagrant ssh
cd /vagrant
lein koan run
```


### Установка, используя Docker

Установите [Docker](https://www.docker.com/), затем выполните:

для запуска коанов:

```
docker run --rm -it -v $(pwd):/app -w /app clojure lein koan run
```

для запуска REPL:

```
docker run --rm -it -v $(pwd):/app -w /app clojure lein repl
```


## Запуск коанов

Команда:

`lein koan run`

Для запуска из REPL:

`(exec "run")`

В любом случае программа запустится и будет ожидать сохранения файла с коанами
и даст вам знать правильно ли было решение или нет.
Каждый коан сопровождён указаниями и направляющими вопросами.

Пример:

    Now meditate on /home/colin/Projects/clojure-koans/src/koans/01_equalities.clj:3
    ---------------------
    Assertion failed!
    We shall contemplate truth by testing reality, via equality.
    (= __ true)

Программа сообщает вам о том, что в файле `01_equalities.clj`, строка 3 тест не пройден
и коан не решён. Подумайте и внесите изменения!
Вам всегда будет предложено заполнить пустое место, обозначенное символами подчёркивания.
Иногда способов решения несколько, некоторые тесты успешно пройдут даже при замене символов подчёркивания
на пробел.

Коаны отличаются от TDD, т.к. тесты уже написаны за вас.
Следите за сообщениями о непройденном тесте — они будут появляться вплоть до решения всех коанов.
Соответственно при прохождении одного коана, вы увидите собщение об ошибке при прохождении следующего,
ещё не решённого вами коана. Вы решаете следующий и так далее, пока не решите последний.

Постарайтесь обдумывать ваше решение и вполне понимать почему правильный ответ именно таков.
Наслаждайтесь вашим путём к Clojure-просветлению!


## Используйте REPL

Помимо коанов, практикуйтесь и читайте документацию используя интерактивную командную строку:

```
lein repl
```

Вводите выражения и программа будет сразу выводить результат — это очень удобно и
ускоряет изучение языка.

Попробуйте ввести эти команды:

```clojure
(find-doc "vec")
(find-doc #"vec$")
(doc vec)
```

И эти:

```clojure
(doc doc)
(doc find-doc)
```

Для окончания работы с REPL используйте `CTRL-d`, `(exit)`, или `(quit)`.


## Развитие

Убедитесь, что (`lein koan test`) пройдены и присылайте патчи в pull request.

Файл ideaboard.txt содержит различные идеи для реализации новых или изменения текущих коанов.
Ответы на упражнения пишите в `resources/koans.clj`!

Следуйте эти рекомендациям 
http://tbaggery.com/2008/04/19/a-note-about-git-commit-messages.html.
Для упрощения оценки ваших патчей, — сохраняйте код в feature ветку (не master) перед pull request.

Если у вас остались вопросы или нужны рекомендации,
связывайтесь со мной (Colin Jones / trptcolin) через Github или иным способом.


## Участники

https://github.com/functional-koans/clojure-koans/contributors


### Перевод на русский язык

[Alex Gorelov](https://github.com/brannx)

## Благодарность

Эти упражнения создавались [Aaron Bedra](http://github.com/abedra) 
[Relevance, Inc.](http://github.com/relevance) в начале 2010 как инструмент
для изучения функционального программирования для новичков.
Макрос-фу Аарона делали эти коаны доступными для использования и изучения языка,
а также для их дальнейшей разработки и улучшения.
Без инициативы со стороны Relevance Inc. этот проект не был бы осуществлён.

Использование впервые [коанов](http://en.wikipedia.org/wiki/koan) в качестве метафоры
для обучающих упражнений было заслугой [Ruby Koans](http://rubykoans.com) от [EdgeCase](http://github.com/edgecase).


## Лицензия

The use and distribution terms for this software are covered by the
Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
which can be found in the file epl-v10.html at the root of this distribution.
By using this software in any fashion, you are agreeing to be bound by
the terms of this license.
