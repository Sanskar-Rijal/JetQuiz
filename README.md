# Quiz App

It's a quiz application that fetches questions from the internet using Retrofit and displays them to the user. The app includes a progress bar that provides visual feedback as users progress through the quiz.

## Features

- **Fetch Questions from the Internet**: Uses Retrofit to retrieve questions in JSON format from an online source.
- **Progress Tracking**: A progress bar displays as users reach certain milestones in the quiz, providing a clear indicator of their progress.

## Screenshots

<div align="start">
  <a href="https://imgur.com/JCgyTi0">
    <img src="https://i.imgur.com/JCgyTi0.gif" title="source: imgur.com" height="400" width="200" style="margin-right: 20px;" />
  <a href="https://imgur.com/JHDCVxY">
    <img src="https://i.imgur.com/JHDCVxY.gif" title="source: imgur.com" height="400" width="200" style="margin-right: 20px;" />
  </a>
  <a href="https://imgur.com/Rs8WLYH">
    <img src="https://i.imgur.com/Rs8WLYH.gif" title="source: imgur.com" height="400" width="200" style="margin-right: 20px;" />
  </a>
  <a href="https://imgur.com/Somp97W">
    <img src="https://i.imgur.com/Somp97W.gif" title="source: imgur.com" height="400" width="200" style="margin-right: 20px;" />
  </a>
  <a href="https://imgur.com/pnFVfVK">
    <img src="https://i.imgur.com/pnFVfVK.gif" title="source: imgur.com" height="400" width="200" />
  </a>
</div>


## Technologies Used

- **Kotlin** - Core programming language for the app
- **Jetpack Compose** - UI framework for building composable and responsive interfaces
- **Retrofit** - Library for HTTP requests, used to fetch quiz questions in JSON format from an online source
- **Jetpack Hilt** - Dependency injection framework to manage dependencies
- **Material Design** - UI components for a polished user experience

## Installation

1. Clone this repository:
    ```bash
    git clone https://github.com/yourusername/randomquiz.git
    ```
2. Open the project in Android Studio.
3. Build and run the project on an Android device or emulator.

## How It Works

1. When the app starts, it connects to an online source using Retrofit and fetches quiz questions in JSON format.
2. Questions are displayed to the user in a multiple-choice format.
3. As the user answers questions, a progress bar appears when specific milestones are reached, giving visual feedback on their quiz progress.

## Dependencies

- [Retrofit](https://square.github.io/retrofit/) - For network requests
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - For dependency injection
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - For UI

## Permissions

- **Internet**: Required to fetch quiz questions from the web.

## Contributing

Feel free to fork this repository and submit pull requests. Any contributions, whether bug fixes or new features, are welcome!

