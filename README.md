# Clojure Koans

The Clojure Koans are a fun and easy way to get started with Clojure - no
experience assumed or required.  Just follow the instructions below to start
making tests pass!


### Getting Started

The easiest and fastest way to get the koans up and running is to [download the
latest zip file from Github](https://github.com/functional-koans/clojure-koans/downloads).
This way, you'll have all the dependencies you need, including Clojure itself
and JLine, and you can skip the rest of this section (skip to "Running the
Koans").

If you're starting from a cloned or forked repo, that's cool too. This way
you'll be able to track your progress in Git, and see how your answers compare
to others, by checking out the project's Network tab. You might want to create
your own branch - that way if you pull back the latest koans from master, it'll
be a bit easier to manage the inevitable conflicts if we make changes to
exercises you've already completed.

The only things you'll need to run the Clojure Koans are:

- JRE 1.5 or higher
- [clojure-1.5.1.jar](http://repo1.maven.org/maven2/org/clojure/clojure/1.5.1/clojure-1.5.1.zip)

You can use [Leiningen](http://github.com/technomancy/leiningen) to
automatically install the Clojure jar in the right place. Leiningen will also
get you a couple more jarfiles, including JLine, which allows you some of the
functionality of readline (command-line history, for example).

### Installing dependencies

Dependencies are installed automatically with lein 2, but if you are still
using lein 1 run

`lein deps`

which will download all dependencies you need to run the Clojure koans.


### Running the Koans

If you're running from the zipfile or using lein 1, simply run

`script/run` on Mac/\*nix

`script\run` on Windows

If you're running from a checkout using lein 2, run the koans via

`lein koan run`

It's an auto-runner, so as you save your files with the correct answers, it will
advance you to the next koan or file (conveniently, all files are prefixed with
the sequence that you should follow).

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


### Trying more things out

There's a REPL (Read-Evaluate-Print Loop) included in the Clojure Koans. Just
run:

`script/repl` on Mac/\*nix

`script\repl` on Windows

If you're on lein 2, `lein repl` is what you want instead.

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

You can exit the REPL with `CTRL-d` on any OS.


### Contributing

Patches are encouraged!  Make sure the answer sheet still passes
(`script/test`, or `script\test` on Windows, or `lein koan test` on lein2), and
send a pull request.

The file ideaboard.txt has lots of good ideas for new koans to start, or things
to add to existing koans.  So write some fun exercises, add your answers to
`resources/koans.clj`, and we'll get them in there!

Feel free to contact me (Colin Jones / trptcolin) on Github or elsewhere if you
have any questions or want more direction before you start pitching in.


### Contributors

https://github.com/functional-koans/clojure-koans/contributors


### Credits

These exercises were started by [Aaron Bedra](http://github.com/abedra) of
[Relevance, Inc.](http://github.com/relevance) in early 2010, as a learning
tool for newcomers to functional programming. Aaron's macro-fu makes these
koans extremely simple and fun to use, and to improve upon, and without
Relevance's initiative, this project would not exist.

Using the [koans](http://en.wikipedia.org/wiki/koan) metaphor as a tool for
learning a programming language started with the
[Ruby Koans](http://rubykoans.com) by [EdgeCase](http://github.com/edgecase).


### License

The use and distribution terms for this software are covered by the
Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
which can be found in the file epl-v10.html at the root of this distribution.
By using this software in any fashion, you are agreeing to be bound by
the terms of this license.
