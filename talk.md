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

Pattern matching
----------------


