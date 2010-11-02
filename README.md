# Clojure Koans

The Clojure Koans are a fun and easy way to get started with Clojure - no
experience assumed or required.  Just follow the instructions below to start
making tests pass!


### Getting Started

The only things you need to run the Clojure Koans are:

- JRE 1.5 or higher
- clojure-1.3.0-alpha1.jar

clojure-1.3.0-alpha1.jar needs to be placed in a directory `lib` under this
project.

You can use Leiningen (http://github.com/technomancy/leiningen) to
automatically install the Clojure jar in the right place. Leiningen will also
get you a couple more jarfiles, including JLine, which allows you some of the
functionality of readline (command-line history, for example).

After you have leiningen installed, run

`lein deps`

which will download all dependencies you need to run the Clojure koans.


### Running The Koans

To run the koans, simply run

`script/run` on Mac/\*nix

`script\run` on Windows

You'll see something like this:

    FAIL in clojure.lang.PersistentList$EmptyList@1 (equalities.clj:1)
    We shall contemplate truth by testing reality, via equality.
    expected: (= __ true)
      actual: (not (= nil true))

The output is telling you that you have a failing test in equalities.clj.
So open that file up and make it pass!  In general, you just fill in the
blanks to make tests pass.  Sometimes there are several (or even an infinite
number) of correct answers: any of them will work in these cases.

The koans differ from normal TDD in that the tests are already written for you,
so you'll have to pay close attention to the failure messages, because up until
the very end, making a test pass just means that the next failure message comes
up.

While it's very easy (especially at first) to just fill in the blanks making
things pass, you should work slowly, making sure you understand why the answer
is what it is.  Enjoy your path to Clojure enlightenment!


### Trying more things out

There's a REPL (Read-Evaluate-Print Loop) included in the Clojure Koans. Just
run:

`script/repl` on Mac/\*nix

`script\repl` on Windows

Here are some interesting commands you might try, once you're in a running REPL:

    (find-doc "vec")
    (find-doc #"vec$")
    (doc vec)

And if those still don't make sense:

    (doc doc)
    (doc find-doc)

will show you what those commands mean.

You can exit the REPL with `CTRL-d` on any OS.


### Contributing

Patches are encouraged!  Make sure the answer sheet still passes (`test.sh`, or
`test.bat` on Windows), and send a pull request.

The file ideaboard.txt has lots of good places to start


### Contributors (in order of appearance)

- Aaron Bedra
- Colin Jones
- Eric Lavigne
- Nuno Marquez


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

