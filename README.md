# FXC
Flyweight XML construction kit

FXC is designed to facillitate the creation of a simple xml document with an attempt to be as minimalistic as possible without impacting readability.

FXC can be described by what it doesn't do

* No validation
  * No namespace checking
  * No value checks

It's purpose is to simply provide xml

```java
Element note = new Element("note")
                  .addTag("to", "Tove")
                  .addTag("from", "Jani")
                  .addTag("heading", "Reminder")
                  .addTag("body", "Don't forget me this weekend!");
```
	
which produces
	
```xml
<note>
    <to>Tove</to>
    <from>Jani</from>
    <heading>Reminder</heading>
    <body>Don't forget me this weekend!</body>
 </note>
```
  
