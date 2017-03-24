# mism_capstone
Location-based web service with Legendary Entertainment spatial APIs

Lombok+Android
https://projectlombok.org/setup/android.html

MongoDB
// https://mvnrepository.com/artifact/org.mongodb/mongodb-driver
compile group: 'org.mongodb', name: 'mongodb-driver', version: '3.4.2'
instead of
// https://mvnrepository.com/artifact/org.mongodb/mongo-java-driver
// compile group: 'org.mongodb', name: 'mongo-java-driver', version: '1.3'

Intellij
Error:Gradle: A problem occurred evaluating project ':app'.
> java.lang.UnsupportedClassVersionError: com/android/build/gradle/AppPlugin : Unsupported major.minor version 52.0
Choose SDK with Android SDK.


// https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient
compile group: 'org.apache.httpcomponents', name: 'httpclient', version: '4.5.3'
Warning:WARNING: Dependency org.apache.httpcomponents:httpclient:4.5.3 is ignored for debug as it may be conflicting with the internal version provided by Android.

Lombok usage:
https://projectlombok.org/mavenrepo/

gradle:
provided 'org.projectlombok:lombok:1.16.14'

Android Studio

Follow the previous instructions (Gradle). In addition to setting up your gradle project correctly, you need to add the Lombok IntelliJ plugin to add lombok support to Android Studio:
Go to File > Settings > Plugins
Click on Browse repositories...
Search for Lombok Plugin
Click on Install plugin
Restart Android Studio


package javax.annotation does not exist
http://stackoverflow.com/questions/28465603/error-package-javax-annotation-does-not-exist-after-upgrade-to-lombok-1-16-2
Global config keys
https://projectlombok.org/features/configuration.html
lombok.addGeneratedAnnotation = false