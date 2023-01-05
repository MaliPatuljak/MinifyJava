# MinifyJava

Minifies java code for CodeGolf.

## Example

From

```java
public class Main {
  public static void main(final String... args) {
    System.out.println("Hello Minify!");
  }
}
```

To

```java
public class Main{public static void main(final String...args){System.out.println("Hello Minify!");}}
```

Using

```kotlin
val javaCode = "..."
val minifiedCode = javaCode.minify()
```
