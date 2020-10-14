# Rothko
Rothko is an Android app that populates a list with artwork hosted on Artsy.

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
