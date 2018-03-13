# Clojure Koans

Для того чтобы приступить к решению Clojure коанов, следуйте инструкциям ниже.


## Getting Started

Прежде всего клонируйте репозиторий или создайте свой форк. Далее вы можете создать отдельную ветку
чтобы избежать конфликтов при обновлении кланов.

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

Программа сообщает вам о том, что в файле `01_equalities.clj`, строка 3 тест не пройдён
и коан не решён. Подумайте и внесите изменения!
Вам всегда будет предложено заполнить пустое место,обозначенное символами подчёркивания.
Sometimes there could be several correct answers (or even an infinite number):
any of them will work in these cases. Some tests will pass even if you replace
the blanks with whitespace (or nothing) instead of the expected answer. Make sure
you give one correct expression to replace each blank.

The koans differ from normal TDD in that the tests are already written for you,
so you'll have to pay close attention to the failure messages, because up until
the very end, making a test pass means that the next failure message comes
up.

While it might be easy (especially at first) to fill in the blanks making
things pass, you should work thoughtfully, making sure you understand why the
answer is what it is.  Enjoy your path to Clojure enlightenment!


## Trying more things out

It's very useful to try things out in a REPL (Read-Evaluate-Print Loop)
whenever you get stuck or curious. Run:

```
lein repl
```

and you'll be able to type expressions in, and see what output they produce.

Here are some interesting commands you might try, once you're in a running REPL:

```clojure
(find-doc "vec")
(find-doc #"vec$")
(doc vec)
```

And if those still don't make sense:

```clojure
(doc doc)
(doc find-doc)
```

will show you what those commands mean.

You can exit the REPL with `CTRL-d`, `(exit)`, or `(quit)`.


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
