# FXC
Flyweight XML construction kit

FXC is designed to facilitate the creation of a simple XML document with an attempt to be as minimalist as possible without impacting readability.

FXC can be described by what it doesn't do

* No validation
* No namespace checking
* No value checks

It's purpose is to simply provide xml. Relying on the creator to be responsbile for content.

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

To produce the output you just call the toString() method.

```java
out.write(note.toString());
```
To help with troubleshooting, or just to create readable content, a formatter can be used. The formatter provides a series of common, configurable, defaults to format the output.

Using the default formatter is simple.

```java
out.write(note.toString(new Formatter()));
```

The Formatter provides indentation and line breaking based on the length of a node. If the content of a given node is longer than the Formatters segment length it will split the node into multiple lines, if a text is to long it will break the text across multiple lines for ease of viewing.

```xml
<?xml version='1.0'?>
<note>
  <to>Tove</to>
  <from>Jani</from>
  <heading>Reminder</heading>
  <body>
    This is a very long complex note that includes a 
    multi lined string and styling
  </body>
</note>
```
