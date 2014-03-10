Introduction
==============

Functional Programming
----------------------
What is functional programming associated with:
 - Lambda calculus.
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

 - Debunk a bit. We're already doing functional programming. It's nothing magical.
 - Very academic languages
 - A different mind set
 - Complicated seen with imperative eyes

Functional programming in Scala
-------------------------------
  Multi-paradigm (a bit like your mom, it can do it all)
    - functinoal
    - object oriented
    - imperative
    - concurrent

  Statically and strongly typed**

  JVM!!!


Why it has gotten some tracktion?
  - Focus on scabalility, and error safe!
  - Runs on the JVM, can interact with Java application
  - Good tooling pretty early on, and eco-system

Who uses it?
 - LinkedIn
 - Twitter
 - Novell
 - FourSquare
 - ...

Agenda
-------
 - Basics of functional programming with examples in ruby, js and scala
 - A bit about the eco system (if we have time)

 > Try to explain functional programming using Scal, something you can apply in your language of choice
 > Scala supports Object Oriented paradigm aswell, and why it matters


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

  val add2 = add(2) _ //Currying

  println(add2(4))
```

> Just show stuff in scala, var val introduces next slide.

Immutable data structures
-------------------------
In functional programming there is no mutable variable.
Can also transform a -> b

Mutable variable are for iterable programming.

By default in scala you're using immutable data structures.


Type Inference
______________

Scala detecs your type, if it can not you have to specify it.

Remember this
```scala
  val a = 2
  //a: Int
```

>Reduce boiler plate with statically typed language, benefits of statically typed.
Close as "possible" to script languages.


Collection operations
----------------
Find a sum of array
```javascript
  var arr = [1, 2, 3, 4];
  var i;
  var sum = 0;
  for (i = 0; i < arr.length; i++) {
    sum += arr[i];
  }
```

How can we implement this without state.
Recursion

```javascript
  function sumList(sum, arr) {
    if (arr.length === 0) {
      return sum;
    }
    sum += arr.pop();
    return sumList(sum, arr);
  }
```

```javascript
  var l = [1, 2, 3 , 4];
  l.reduce(function (memo, x) {
    return memo + x;
  });
  //es5
```

> But this is very complicated, and exspensive

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

> So you know that it is list, less protection needed
> Also warns if there is cases you haven't covered

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

> anything can happend here, request failed, wrong,
> Need to be defensive in script languages

Strongly typed

Wraps the response that might happend so it's safe.

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
This enables is higher order functions, where you send in functions as arguments.

```scala
  def awesomePrinter(x) =
    println("awesome magic", x)

  def myMagicListIterator(f: Int=>Unit, xs:List[Int]) =
    xs.foreach(x => f(x))

  //myMagicListIterator(awesomePrinter, List.Range(0, 10))
```

//This is painful in ruby and in javascript we don not have strongly type. Which can make this a bit error prone. (Typically a lot of type checking)

Pure functions
--------------
You actually already know this by no. It's simply a statless function.

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

So we have immutable data and pure functions.

What defines functional programming?
A whole program composed by pure functions and immutable data structures. And this becomes extremly powerful when dealing with concurrency.

Is it useful??
--------------
Yes and No...

> In the real world, you need to keep track of state in many cases.
> Writing a "pure" program is hard and not that useful.

Why is it practical in Scala and what's the benefits?

Scala is bit pragmatic, compared to "PURE" languages such as Haskell.

The idea is to write pure functional core surronded by a few impure functions.


```scala
  class BankAccount {
    private var bal:Int = 0

    def deposit(amount: Int) = {
      bal += amount
    } //Impure

    def isItEnoughMoney(price: Int, amount: Int) = {
      if price > amount ? false : true
    }

    def doIhaveEnoughMoney(price: Int) = {
      isItEnoughMoney(pric, bal)
    }

     //Pure
  }

```

Q and A?
-------


Eco system
----------


Why is scalable
---------------
Actors


