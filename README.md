# Compose_custom_ui
Create a UI library with custom widgets for a mobile application using Jetpack Compose. Create a sample app with these UI widget to test your custom widgets. You can use material design and its assets for this assignment.

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