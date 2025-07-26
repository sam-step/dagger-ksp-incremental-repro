./gradlew :app:build

echo "// trigger incremental" >> app/src/main/kotlin/app/OtherClass.kt

./gradlew :app:build
