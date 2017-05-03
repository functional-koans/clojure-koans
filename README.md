# Clojure Koans

The Clojure Koans are a fun and easy way to get started with Clojure - no
experience assumed or required.  Just follow the instructions below to start
making tests pass!


## Getting Started

I recommend starting from a cloned or forked repo. This way you'll be able to
track your progress in Git. You might want to create your own branch - that way
if you pull back the latest koans from master, it'll be a bit easier to manage
the inevitable conflicts if we make changes to exercises you've already
completed.

You have a few options for installation:

- Install the dependencies for the koans (such as Clojure) on your machine
- Use Vagrant and the configuration in this repository
- Use Docker

Instructions for each option are below!


### Installation on Your Machine

The only things you'll need to run the Clojure Koans are:

- JDK (I suggest version 8, but anything 6 or above should work fine)
- [Leiningen](http://github.com/technomancy/leiningen), a build tool for Clojure

Once you've cloned this repo and installed the dependencies, you can run:

```
lein repl
```

to make sure all the dependencies get downloaded properly (and then `(exit)`
when you want to quit). See below for details on the REPL.


### Installation with Vagrant

Make sure you have [Vagrant](https://www.vagrantup.com/) and
[VirtualBox](https://www.virtualbox.org) installed.
In the root directory of the project, execute:

```
vagrant up
vagrant ssh
cd /vagrant
lein koan run
```


### Installation with Docker

Once you've got [Docker](https://www.docker.com/) installed, you're basically
all set. You can run these commands to get started:

To run koans:

```
docker run --rm -it -v $(pwd):/app -w /app clojure lein koan run
```

To start up a REPL:

```
docker run --rm -it -v $(pwd):/app -w /app clojure lein repl
```


## Running the Koans

Run the koans via:

`lein koan run`

If want to run directly from a REPL, once you are inside the `lein repl` prompt you can run the koans with

`(exec "run")`

Either way, it's an auto-runner, so as you save your files with the correct
answers, it will advance you to the next koan or file (conveniently, all files
are prefixed with the sequence that you should follow).

You'll see something like this:

    Now meditate on /home/colin/Projects/clojure-koans/src/koans/01_equalities.clj:3
    ---------------------
    Assertion failed!
    We shall contemplate truth by testing reality, via equality.
    (= __ true)

The output is telling you that you have a failing test in the file named
`01_equalities.clj`, on line 3. So you just need to open that file up and make
it pass!  You'll always be filling in the blanks to make tests pass.
Sometimes there could be several correct answers (or even an infinite number):
any of them will work in these cases. Some tests will pass even if you replace
the blanks with whitespace (or nothing) instead of the expected answer. Make sure
you give one correct expression to replace each blank.

The koans differ from normal TDD in that the tests are already written for you,
so you'll have to pay close attention to the failure messages, because up until
the very end, making a test pass just means that the next failure message comes
up.

While it might be easy (especially at first) to just fill in the blanks making
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


## Contributing

Patches are encouraged!  Make sure the answer sheet still passes
(`lein koan test`), and send a pull request.

The file ideaboard.txt has lots of good ideas for new koans to start, or things
to add to existing koans.  So write some fun exercises, add your answers to
`resources/koans.clj`, and we'll get them in there!

Please follow the guidelines in
http://tbaggery.com/2008/04/19/a-note-about-git-commit-messages.html for
commmit messages, and put your code in a feature branch (not master) before
making the pull request. This makes patches easier to review.

Feel free to contact me (Colin Jones / trptcolin) on Github or elsewhere if you
have any questions or want more direction before you start pitching in.


## Contributors

https://github.com/functional-koans/clojure-koans/contributors


## Credits

These exercises were started by [Aaron Bedra](http://github.com/abedra) of
[Relevance, Inc.](http://github.com/relevance) in early 2010, as a learning
tool for newcomers to functional programming. Aaron's macro-fu makes these
koans extremely simple and fun to use, and to improve upon, and without
Relevance's initiative, this project would not exist.

Using the [koans](http://en.wikipedia.org/wiki/koan) metaphor as a tool for
learning a programming language started with the
[Ruby Koans](http://rubykoans.com) by [EdgeCase](http://github.com/edgecase).


## License

The use and distribution terms for this software are covered by the
Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
which can be found in the file epl-v10.html at the root of this distribution.
By using this software in any fashion, you are agreeing to be bound by
the terms of this license.
