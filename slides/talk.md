#Functional Programming
##with Scala



What is functional programming associated with:

- Lambda calculus.
- Lisp/Haskell Monads !??? WTF!


Simple ruby/js example of a pure function:
```javascript
// js

function square (number) {
  return number * number;
}
square(square(3)) // 3 * 3 * 3
```

```ruby
# ruby

def square (number) do
  number * number;
end

square(square(3)) # 3 * 3 * 3
```


- We're already doing functional programming
- Often seen as "academic" languages
- A different mind set
- Complicated if you're used to imperative programming

Note:
Debunk a bit. It's nothing magical.



# Let's start


## Scala is ...


Multi-paradigm (a bit like your mom, it can do it all)

- functional
- object oriented
- imperative
- concurrent
- statically and strongly typed
- JVM based

Note:
- statically typed: if the type of a variable is known at compile time
- strong-typing means that you can't use one type of variable where another is expected


## Why it has gotten some tracktion?

- Scalable and fault tolerant
- Runs on the JVM, can interact with Java applications
- Good tooling pretty early on, and developed ecosystem


## Who uses it?

- LinkedIn
- Twitter
- Novell
- FourSquare
- a lot of other enterprises/big companies

<br>
Not really popular in startups :(

Note:
- just to add some tracktion
- people are migration because of scalability



#Agenda

Basics of functional programming with examples in ruby, js and scala

Note:
- Try to explain functional programming using Scala, something you can apply in your language of choice
- Scala supports Object Oriented paradigm as well, and why it matters



# Dive in


## Functional programming in Scala:
<br>
```scala
  //scala
  def square(number:Int):Int = number * number

  square(square(3)) // 3 * 3 * 3
```
Note:
- this is the example, which we had earlier


##Done!



# Repl session

## Live coding (Oh noes)


```scala
  //scala
  val a = 2 //Scala encourages the use of immutable data
  var b = 5
  a += 2
  b += 2

  def add(a:Int)(b:Int):Int = a + b

  val add2 = add(2) _ //Currying

  println(add2(4))
```

Note:
- Just show stuff in scala, var val introduces next slide.



## Immutable data structures

In functional programming there is no mutable variables.

It's about transforming "a" to "b" using functions.

By default, in scala, you're using immutable data structures.

Note:
Mutable variable are for iterable programming.



## Type Inference

Scala detects your type, most of the time ;)

<br>

Simple example:
```scala
  //scala
  val a = 2
  //a: Int
```
This happens at compile time.

Note:
- Reduces boiler plate with statically typed language, benefits of statically typed.
- Close as "possible" to script languages.



## Collection operations

Find a sum of an array

```javascript
  //js
  var arr = [1, 2, 3, 4];
  var i;
  var sum = 0;
  for (i = 0; i < arr.length; i++) {
    sum += arr[i];
  }
```


## How can we implement this without state?


## Recursion!

```javascript
  //js
  function sumList(sum, arr) {
    if (arr.length === 0) {
      return sum;
    }
    sum += arr.pop();
    return sumList(sum, arr);
  }
```


## But recursion is ...

- complicated
- complicated
- complicated
- expensive


### Iterators to the rescue!

```javascript
  //js
  var l = [1, 2, 3 , 4];
  l.reduce(function (memo, x) {
    return memo + x;
  });
  //es5
```

### We know them already.

map, flatMap, foldRight (/:), filter, find

Note:
- it came from func langs


javascript:
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

ruby:
```ruby
  l = (1..10).to_a
  l.map { |x| x + 2 }
  l.find_all { |x| x > 4 }
  l.reduce { |x, memo| x + memo }
```

scala:
```scala
  val l = List.range(1, 10)
  l.map(x => x + 2)
  l.filter(x => x > 4)
  l.reduce(memo, x => memo + x)
```



## Pattern matching



```javascript
  //js
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
  //scala
  def length(a: List[Int]):Int = a match {
    case Nil => 0
    case h::t => 1 + length(t)
  }
```

Note:
- So you know that it is list, less protection needed
- Also warns if there is cases you haven't covered


## why does it matter?

Compiler warns when there is missing types.
Can also match on operations, classes, function.

So if you want to create a programming language this is very cool!



## Example of fault tolerance

Suppose, we're trying to fetch some data...

<br>

in ruby:
```ruby
  #ruby
  name = request.name
  println(name)
```

and in js:
``` javascript
  //js
  var name = request.getParameter('name');
  console.log(name);
```

What can go wrong here?

Note:
- anything can happen here, request failed, wrong, response parsing
- so you need to be defensive in script languages


Let's try to do the same in scala:

```scala
  //scala
  val name = request getParameter "name"
  println(name)
```

Note:
- say, that it won't work


## The option monad does the job

Option wraps the response that might happened so it's safe.

<br>

Ok, let's try to do better:

```scala
  //scala
  val nameMaybe = request getParameter "name"
  nameMaybe match {
    case Some(name) =>
      println(name)
  }
```

Note:
- because it's strongly typed, we need to extract data from `maybe` state.
- this doesn't cover all the states, compiler will show a warning


Complete example:
```scala
  //scala
  val nameMaybe = request getParameter "name"
  nameMaybe match {
    case Some(name) =>
      println(name)
    case None =>
      println("Oh no name")
  }
  //Resource: scala-lang option monad
```

Note:
- and now this is safe + has some kind of the error handling



## Higher order function


In scala functions are first class citizens, they are also variables.

Higher order functions are functions, where you send in functions as arguments.

```scala
  //scala
  def awesomePrinter(x) =
    println("awesome magic", x)

  def myMagicListIterator(f: Int=>Unit, xs:List[Int]) =
    xs.foreach(x => f(x))

  //myMagicListIterator(awesomePrinter, List.Range(0, 10))
```

Note:
This is painful in ruby and in javascript we don not have strongly type.
Which can make this a bit error prone. (Typically a lot of type checking)



## Pure functions

You actually already know this by now. It's simply a stateless function.


> If an expression can be replaced by its value without changing the behavior of the program,
it is said to be referentially transparent.

<br>

pure function:
```javascript
  //js
  (1 + 3) //can be replaced by 4
```

impure function:
```javascript
  //js
  var a;
  setA(b) {
    a = b; //even worse with conditions
  }
```


A pure function will always give the same output given the same input.

```javascript
  //js
  Math.sin(0) // 0
```

<br>

It has no side effects

Note:
- in simple words: if you know the input then you can just replace it by output w/o changing
the behavior of program
- it comes from Math



# Summary


## What defines functional programming?

A whole program composed by pure functions and immutable data structures.

Note:
- And this becomes extremely powerful when dealing with concurrency.


## Is it useful??
Yes and No...

In the real world, you need to keep track of state in many cases.

Note:
- Writing a "pure" program is hard and not that useful.


Why is it practical in Scala and what are the benefits?

Scala is bit pragmatic, compared to "PURE" languages such as Haskell.


The idea is to write pure functional core surrounded by a few impure functions.

```scala
  //scala
  class BankAccount {
    private var bal:Int = 0

    def deposit(amount: Int) = {
      bal += amount
    }

    // Pure
    def isItEnoughMoney(price: Int, amount: Int) = {
      if price > amount ? false : true
    }

    // Impure
    def doIhaveEnoughMoney(price: Int) = {
      isItEnoughMoney(pric, bal)
    }
  }

```



# References

- This talk is highly inspired by: http://de.slideshare.net/pramode_ce/introduction-to-functional-programming-with-scala
- Coursera functional programming course (scala): https://www.coursera.org/course/progfun (next session starts in April!)
- Coursera reactive programming course: https://www.coursera.org/course/reactive
- Twitter scala school: http://twitter.github.io/scala_school (Warning: extremely complicated)



# Q and A?

Note:
  - How can we apply this in Babbel?
  - Good for creating compliers. (babbel language)
