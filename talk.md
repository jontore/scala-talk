Introduction
==============

Functional Programming
----------------------

 - Lambda calalus.
 - Lisp/Haskell Monads !??? WTF!
 - Simple ruby/js example of a pure function
  ```javascript
    function square (number) {
      return number * number;
    }
    square(square(3)) // 3 * 3 * 3
  ```
  ```ruby
    def square (number) do
      number * number;
    end

    square(square(3)) # 3 * 3 * 3
  ```

  ```Objective-C

  ```

 - Debunk a bit. We're already doing functional programming. It's nothing magical.
 - Why it's not been so popular

Scala
----------------------
  Multi-paradigm (a bit like your mom, it can do it all)
    - functinoal
    - object oriented
    - imperative
    - concurrent

  Statically and strongly typed**

  JVM!!! (Powerful and all over the world)


Why it has gotten some tracktion? Who uses it?

Agenda
-------
 - Basics of functional programming with examples in ruby, js and scala
 - A bit about the eco system


Dive in
-------
  Functional programming in Scala:
  ```scala
    def square(number:Int):Int = number * number
    square(square(3)) // 3 * 3 * 3
  ```

  Done!


Repl session
------------
Live coding :/ (Oh noes)

```scala
  val a = 2 //Scala encourages the use of immutable data
  var b = 5
  a += 2
  b += 2


  def add(a:Int)(b:Int):Int = a + b

  val add2 = add(2) _

  println(add2(4))
```

Immutable data structures
-------------------------
In functional programming there is no mutable variable.
Can also transform a -> b
Mutable variable are for iterable programming.
By default in scala you're using imutable data structures.
Scala encourages and makes it easy to create and use immutables.

Type Inference
______________

Scala detecs your type, if it can not you have to specify it.

Remember this
```scala
  val add2 = add(2) _
  //add2: Int => Int = <function1>
```


List operations
----------------
map, flatMap, foldRight (/:), filter, find
```javascript
  var l = [0, 1, 2, 3, 4, 5, 6, 7, 8, 10];
  l.map(function (x) {
    return x + 2;
  });
  l.filter(function (x) {
    return x > 4;
  });
  l.reduce(function (memo, x) {
    return memo + x;
  });
  //es5
```

```ruby
  l = (1..10).to_a
  l.map { |x| x + 2 }
  l.find_all { |x| x > 4 }
  l.reduce { |x, memo| x + memo }
```

```scala
  val l = List.range(1, 10)
  l.map(x => x + 2)
  l.filter(x => x > 4)
  l.reduce(memo, x => memo + x)
```

Pattern matching
----------------
```javascript
  function length(list) {
    switch(list.length) {
      case 0:
        return 0;
      default:
        return 1 + length(list.slice(0));
    }
  }
```

```scala
  def length(a: List[Int]):Int = a match {
    case Nil => 0
    case h::t => 1 + length(t)
  }
```

Compiler warns when there is missing, types, can also match on operations, classes, function.
So if you want to create a programming language this is very cool!

Option (It's actually a monad!)
--------------------------------

```ruby
  name = request.name
  println(name)
```

``` javascript
  var name = request.getParameter('name');
  console.log(name);
```

Strongly typed

```scala
  val name = request getParameter "name"
  println(name)
```

```scala
  val nameMaybe = request getParameter "name"
  nameMaybe match {
    case Some(name) =>
      println(name)
  }
```

```scala
  val nameMaybe = request getParameter "name"
  nameMaybe match {
    case Some(name) =>
      println(name)
    case None =>
      println("Oh no name")
  }
  //Resource scala-lang option monad
```

Higher order function
----------------------
In scala functions is first class citizens, they are also variables.
A typical example of this pattern is higher order functions.

```scala
  def awesomePrinter(x) =
    println("awesome magic", x)

  def myMagicListIterator(f: Int=>Unit, xs:List[Int]) =
    xs.foreach(x => f(x))

  //myMagicListIterator(awesomePrinter, List.Range(0, 10)
```

//This is painful in ruby and in javascript we don not have strongly type. Which can make this a bit error prone. (Typically a lot of type checking)

Pure functions
--------------
If an expression can be replaced by its value without changing the behaviour of the program, it is said to be referentially transparent.

```scala
  (1 + 3) //can be replaced by 4
```

```javascript
  var a;
  setA(b) {
    a = b; //even worse with conditions
  }
```

A pure function will always give the same output given the same input.
In math very simple:

```javascript
  Math.sin(0) // 0
```
No side effects

So we have immutable data and pure functions. What defines functional programming?
A whole program composed by pure functions and immutable data structures. And this becomes extremly powerful when dealing with concurrency.

Is it useful??
--------------

Yes and No..
How practical and what's the benefits?

Scala is bit pragmatic, compared to PURE languages such as Haskell.

The idea is to write pure functional core surronded by a few impure functions.


```scala
  \\Some class with state and pure functions...

```

Q and A?
-------


Eco system
----------


Why is scalable
---------------
Actors


