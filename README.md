# Compose_custom_ui
Create a UI library with custom widgets for a mobile application using Jetpack Compose. Used material design and its assets for this assignment. Library available in https://github.com/rametechie/Custom_UI_Library/packages/2501100.
Usage in Android App : Import the dependency using implementation("com.kpit:ui_library:1.0.2").

# Running Android UI test 
./gradlew connectedAndroidTest

# ADB devices 
nano ~/.zshrc
export PATH=$PATH:/Volumes/Eaget/AndroidSdk/Android/sdk/platform-tools
source ~/.zshrc

# Running UI test and generating jacoco reports

./gradlew testDebugUnitTest jacocoTestReport

./gradlew :ui_library:testDebugUnitTest :ui_library:jacocoTestReport

Ensure the test results file is generated:
ls app/build/jacoco/testDebugUnitTest.exec
You can force them to run:
./gradlew clean testDebugUnitTest --info

# Publish aar file for ui_library
./gradlew :ui_library:publishReleasePublicationToGitHubPackagesRepository
