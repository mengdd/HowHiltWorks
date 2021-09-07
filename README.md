# HowHiltWorks

## Journey
* Had some issues with adding dependencies, so remove code in `settings.gradle` and use old way.

For multi-modules project, have to add:
```
hilt {
    enableExperimentalClasspathAggregation = true
}
```
Otherwise there might be some `ClassCastException`.

see:
https://dagger.dev/hilt/gradle-setup#classpath-aggregation

