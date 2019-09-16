# ultimate-logger-jvm
[![](https://jitpack.io/v/ArturBorowy/ultimate-logger-jvm.svg)](https://jitpack.io/#ArturBorowy/ultimate-logger-jvm)

**UltimateLogger** is a library with many useful and customizable logging options.

This is **JVM** version of UltimateLogger. **Android version**, which is better choice for Android applications, is available [here](https://github.com/ArturBorowy/ultimate-logger-android).

**Feel free to add your suggestions, issues and pull requests!**

## Quick start guide:

0. Add UltimateLogger dependencies to your **build.gradle**:
```groovy
dependencies {
    implementation 'com.github.ArturBorowy:ultimate-logger-jvm:0.1.0'
}
```

Unless you already have, add **JitPack** repository to your **build.gradle**:

```groovy
repositories {
  ...
  maven { url 'https://jitpack.io' }
}
```

1. Init library (you probably want to do this as fast as you can):

```kotlin
val shouldLog = true
val defaultTagSettings = TagSettings(
        shouldLogFileNameAndLineNum = true,
        shouldLogClassName = true,
        shouldLogMethodName = true)
        
JvmLogInitializer.init(shouldLog, defaultTagSettings)
```

2. Log:
```kotlin
JvmLog.d("Your message to log on debug level.")
JvmLog.e(Exception("Your exception to log on error level."))
```
**Result:**

![Basic logging result example](https://i.imgur.com/XqKzrEb.png)

3. Stop library:
```kotlin
JvmLogInitializer.destroy()
```

## Some advanced features:
1. **Fully customizable tag**:
As I have shown before: `JvmLogInitializer.init(...)` method takes TagSettings object as argument:

![TagSettings data structure](https://i.imgur.com/oARBKaw.png)

If you set `shouldLogClassName` of `tagSettings` flag to `true`, you will see class name before message in every line logged.

Optionally you can override default tag settings (you have set in JvmLogInitializer.init(...)) **in every specific usage of `JvmLog`**

```kotlin
JvmLog.d("This usage overrides tagSettings for own purpose.", true)
```
Above usage will log line number and file name **even if default global settings are different.**

2. **Null safety extensions with logging**

No more boilerplate like this:
```kotlin
myObject?.let {it.doSomething()} ?: OldLogger.w(TAG, "object is null")

// Now you can just write
myObject.tw { it.doSomething() }
```

3. **Logging `Any?` type**

No more `.toString()` calls on objects you want to log. UltimateLogger **can log everything**:

```kotlin
JvmLog.d(1)
JvmLog.e(2f)
JvmLog.v(Date())
JvmLog.wtf((null as String?)) // Objects of nullable types are safe to log!
JvmLog.e() // Empty message? No problem.
```
**Result:**

![Logging Any? result](https://i.imgur.com/NWytUGK.png)

## License

**[MIT](LICENSE)**
  
## Authors
  
###### Writer: [Artur Borowy](https://github.com/ArturBorowy)
###### Editor: [Jakub Brzozowski](https://github.com/KubaB)
