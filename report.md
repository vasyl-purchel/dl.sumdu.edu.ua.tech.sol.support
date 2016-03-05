# Shapes

## Problems

 * ShapeFactory - name suppose to be a [Factory](http://www.oodesign.com/factory-pattern.html)
 * Constructor takes one parameter which is treated as 2 separate digits/parameters
 * Magic numbers to create shapes and styles
 * Not all shape parameters initiated, but luckily they fold back to default values
 * broken solid principles
   
## What left unfixed

 * Functions to create stars/hexagons are not tested and may fail if you specify number of arms as 0
 * `TitlesPanel` and `TitlesFrame` are not modified a lot
 * `TitlesPanel` creates each time new figure and then modify it by rotating, this is memory efficient as we're not storing a lot of information, but it hurts performance
 
## Conclusions

Most of the problems come from object oriented nature of Java. Using functional language for same problem would get benefits from easy creation of immutable data, each
caching implementation and better testability. For improving testability in Java we need to add interfaces and use IoC to have as much code covered by tests.