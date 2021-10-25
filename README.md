# HowHiltWorks

## Journey
* Had some issues with adding dependencies, so remove code in `settings.gradle` and use old way.

### Multi-modules
For multi-modules project, have to add:
```
hilt {
    enableExperimentalClasspathAggregation = true
}
```
Otherwise there might be some `ClassCastException`.

see:
https://dagger.dev/hilt/gradle-setup#classpath-aggregation

### Inject List
To inject a list of instances of some interface,
in Module:
```
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBuildInformation(): BuildInformation {
        return BuildInformation(versionName = BuildConfig.VERSION_NAME)
    }

    @Provides
    fun provideCacheManagers(localCache: LocalCache, memoryCache: MemoryCache): List<CacheManager> {
        return listOf(localCache, memoryCache)
    }
}

```

add `@JvmSuppressWildcards` at the injection site.


```
class ExampleRepository @Inject constructor(
    private val cacheManagers: List<@JvmSuppressWildcards CacheManager>
)
```
Explanation: https://kotlinlang.org/docs/java-to-kotlin-interop.html#variant-generics

