Apache Sling JSON Library

The Sling JSON library provides json support.


Getting Started
===============

This component uses a Maven (http://maven.apache.org/) build
environment. It requires a Java 8 JDK (or higher) and Maven (http://maven.apache.org/)
version 3 or later. We recommend to use the latest Maven version.

If you have Maven installed, you can compile and
package the jar using the following command:

    mvn package

See the Maven documentation for other build features.

Manual changes applied to the library
=====================================
- Copy source over from https://github.com/stleary/JSON-java
- move all the classes into their seperate subpackages and adjust imports everywhere
- Using mvn bundle:baseline command, check for broken compatibility (there will be)
- Change code to make it compatible, there must not be any major differences, minor ones are accepted as long as they are stuff beeing added
- Known major breaking changes to be addressed:
  - JSONWriter: change field 'writer' from type Appendable back to type Writer, adapt the constructor accordingly
  - JSONWriter: add missing methods isTidy/setTidy
  - make the following classes package-private, as those were not present in the initial version of this library: JSONML, JSONMLParserConfioguration, Property, JSONPointer, JSONPointerException, XMLParserConfiguration, XMLXsiTypeConverter, JSONParserConfiguration
  - check for newly added classes that add features to the json-java library, whereas we do not want to add them to the API of this library
  - to restore the old behaviour:
    - in reading string, adapt the getString() methods in JSONObject and JSONArray. Instead of throwing an exception, return get(...).toString() instead.
    - in JSONWriter.key(), remove the check that throws an exception for duplicated keys
- build using mvn clean install, ensure that no more breaking changes are present with mvn bundle:baseline
