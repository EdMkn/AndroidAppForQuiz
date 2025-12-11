#!/bin/bash
# Helper script to build Android APK with Docker and proper caching

# Exit on error, exit on undefined variable, exit on pipe failure
set -euo pipefail

# Enable BuildKit for advanced caching
export DOCKER_BUILDKIT=1
export COMPOSE_DOCKER_CLI_BUILD=1

# Build the Docker image with cache
echo "Building Docker image with cache..."
if ! docker build \
  --tag javaguiz-app:latest \
  --cache-from javaguiz-app:latest \
  .; then
  echo "❌ Docker image build failed!"
  exit 1
fi

# Build APK with Gradle cache mounted
echo "Building APK with cached Gradle dependencies..."
if ! docker run --rm \
  -v "$(pwd):/app" \
  -v gradle-cache:/root/.gradle/caches \
  -v gradle-wrapper:/root/.gradle/wrapper \
  -w /app \
  javaguiz-app:latest \
  ./gradlew assembleDebug --no-daemon; then
  echo "❌ APK build failed!"
  exit 1
fi

echo "✅ APK built successfully!"
echo "📦 Location: app/build/outputs/apk/debug/app-debug.apk"

