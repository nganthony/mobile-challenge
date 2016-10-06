# Wave Software Development Challenge

I decided to finish the mobile challenge in Android. To run the project simply download Android Studio 2.2, import the project, and hit Run. The application is highly unit testable using several design patterns. The architectural decisions I made when creating this application are listed below.

## Model View Presenter

I structured the application to use MVP, where the views are the fragments and all the business logic is contained inside a presenter class. I used manual dependency injection to inject all the dependencies of the presenter into the constructor. This allows dependencies of the presenter to be easily swapped out. If the object graph gets very large, we can consider something like Dagger to do dependency injection instead of writing the factory methods ourselves. The dependencies can easily be mocked using Mockito for unit testing since I created interfaces that the dependencies implement. I added a unit test for the presenter class to demonstrate this.

## Reactive/Functional programming using RxJava

I decided to use Retrofit and RxJava to make the product request to the server asynchronously. Retrofit reduces the amount of networking boilerplate code that I have to write. It also wraps the networking call into an observable so I can easily subscribe to the request and update the views when the result is received.

## Android Data binding

Data binding is a relatively new feature in Android. The idea behind it is you can bind a model object and its data to a view. I use data binding in the product view holder, where I avoid having to write a lot of boilerplate code to find the views and store them as variables of the view holder. 