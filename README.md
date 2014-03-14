scala-talk
==========

Slides
--------
[Slide deck](http://jontore.github.io/scala-talk)
  


Ecosystem
----------

## Akka
http://akka.io

> Akka is a toolkit and runtime for building highly concurrent, distributed,
and fault tolerant event-driven applications on the JVM

Akka provides fault-tolerance based on supervisor hierarchies.
Every actor can create other actors, which it will then supervise, making decisions if they should be
resumed, restarted, retired or if the problem should be escalated. Instead of trying all
things possible to prevent an error from happening, this approach lets you embrace the reality of
unplanned errors.


Example of creating an actor:
```
case class Greeting(who: String)

class GreetingActor extends Actor with ActorLogging {
  def receive = {
    case Greeting(who) => log.info("Hello " + who)
  }
}

val system = ActorSystem("MySystem")
val greeter = system.actorOf(Props[GreetingActor], name = "greeter")
greeter ! Greeting("Charlie Parker")
```

## Play Framework

> (Framework) Built on Akka, Play provides predictable and minimal resource consumption (CPU, memory, threads)
for highly-scalable applications.

Main features:

- native scala support
- stateless
- non-blocking I/O
- built on akka
- real-time support
- modular architecture


Example of async I/O:

```
def index = Action.async {
  val futureInt = Future { intensiveComputation() }
  // Map creates a new future by applying a function to the successful result of this future.
  futureInt.map(i => Ok("Got result: " + i))
}
```



Resources
----------
- http://de.slideshare.net/pramode_ce/introduction-to-functional-programming-with-scala
- http://slid.es/gsklee/functional-programming-in-5-minutes
- http://de.slideshare.net/jboner/pragmatic-real-world-scala-45-min-presentation
- http://stackoverflow.com/questions/2284259/suggested-content-for-a-lunch-time-introduction-to-scala-talk
- http://stackoverflow.com/questions/1722726/is-the-scala-2-8-collections-library-a-case-of-the-longest-suicide-note-in-hist?rq=1
- http://twitter.github.io/scala_school
- [Fun talk on functional programming, more on monads](http://vimeo.com/user18356272/review/66548720/99c7fe5c0c)
- [Monads in Haskell](http://learnyouahaskell.com/a-fistful-of-monads)

