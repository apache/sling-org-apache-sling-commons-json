Apache Sling JSON Library

The Sling JSON library provides json support.


Getting Started
===============

This component uses a Maven 2 (http://maven.apache.org/) build
environment. It requires a Java 5 JDK (or higher) and Maven (http://maven.apache.org/)
2.0.7 or later. We recommend to use the latest Maven version.

If you have Maven 2 installed, you can compile and
package the jar using the following command:

    mvn package

See the Maven 2 documentation for other build features.

The latest source code for this component is available in the
Subversion (http://subversion.tigris.org/) source repository of
the Apache Software Foundation. If you have Subversion installed,
you can checkout the latest source using the following command:

    svn checkout http://svn.apache.org/repos/asf/sling/trunk/commons/json

See the Subversion documentation for other source control features.

Manual changes applied to the library
=====================================
- Copy source over from https://github.com/stleary/JSON-java
- move all the classes into their seperate subpackages and adjust imports everywhere
- Using mvn bundle:baseline command, check for broken compatibility (there will be)
- Change code to make it compatible, there must not be any major differences, minor ones are accepted as long as they are stuff beeing added
- Known major breaking changes to be addressed:
  - JSONWriter: change field 'writer' from type Appendable back to type Writer, adapt the constructor accordingly
  - JSONWriter: add missing methods isTidy/setTidy
- build using mvn clean install, ensure that no more breaking changes are present with mvn bundle:baseline