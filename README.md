# FXC
Flyweight XML construction kit

FXC is designed to facilitate the creation of a simple XML document with an attempt to be as minimalist as possible without impacting readability.

FXC can be described by what it doesn't do

* No validation
* No namespace checking
* No value checks

It's purpose is to simply provide xml, and when formatted, in as nice a formatting as possible.

```java
Element note = new Element("note")
                  .add("to", "Tove")
                  .add("from", "Jani")
                  .add("heading", "Reminder")
                  .add("body", "Don't forget me this weekend!");
```
	
which produces, when formatted, the following
	
```xml
<note>
    <to>Tove</to>
    <from>Jani</from>
    <heading>Reminder</heading>
    <body>Don't forget me this weekend!</body>
 </note>
```
  
