# Rothko
Rothko is an Android app that populates a list with artwork hosted on [Artsy](https://www.artsy.net/).

## Screenshots
<img src="art/trending_art.gif" height="400" alt="Trending artwork home"/>

## Architecture
Rothko attempts to use the latest cutting edge libraries and tools. As a summary:
- [Apollo](https://github.com/apollographql/apollo-android) for generating Kotlin models from GraphQL queries.
- [Coil](https://github.com/coil-kt/coil) for image loading.
- [Kotlin Coroutines](https://kotlinlang.org/docs/reference/coroutines/coroutines-guide.html).
- [Dagger/Hilt](https://dagger.dev/hilt/) for dependency injection.
- [Epoxy](https://github.com/airbnb/epoxy) for simplified recycler view usage.
- [View Binding](https://developer.android.com/topic/libraries/view-binding) to replace using `findViewById`.
- [Navigation Components](https://developer.android.com/guide/navigation/navigation-getting-started) for adhering to an established [set of principles](https://developer.android.com/guide/navigation/navigation-principles)
- [Material Design](https://material.io/develop/android) for UI and animated transitions.

### Apollo
This project is setup using the [Intellij GraphQL Plugin](https://jimkyndemeyer.github.io/js-graphql-intellij-plugin/) to validate and test against the [schema.graphql](core/src/main/graphql/com/cammace/rothko/schema.graphql) file.

<img src="https://raw.githubusercontent.com/jimkyndemeyer/js-graphql-intellij-plugin/a34e36b9596dfab0cc7a4dd4e768892f82c28c63/website/static/img/ide.png" alt="Screenshot showing plugin usage"/>

## Access Token
When compiling locally, you'll need to provide an [Artsy access token](https://developers.artsy.net/v2/) to successfully receive data from the network.

Once you obtain the token, you can set them as environment variables:
```
# Get these from https://developers.artsy.net/v2/
export ROTHKO_ARTSY_ACCESS_TOKEN=<insert>
export ROTHKO_ARTSY_USER_ID=<insert>
```

## Code Style
This project uses several tools to prevent code smells and measure technical debt. Some of these tools include:
- [Spotless Gradle Plugin](https://github.com/diffplug/spotless/tree/main/plugin-gradle) for verifying and automatically fixing code formatting issues.
- [ktlint](https://github.com/pinterest/ktlint), provided via Spotless.
- [Detekt](https://detekt.github.io/detekt/) for analysis of Kotlin code.
- [Android Lint](https://developer.android.com/studio/write/lint) for avoiding structural problems in code.

The configuration for all of these tools is wrapped inside a custom Gradle Plugin found within the `buildSrc` folder.

If you run `./gradlew check` and it fails due to a code style conflict, you can easily fix it by running: `./gradlew spotlessApply`.
