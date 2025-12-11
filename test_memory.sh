#!/bin/bash
# Quick memory test script for Android app
# Usage: ./test_memory.sh

PACKAGE_NAME="com.javaguiz.app"

echo "=== Memory Test for Java Quiz App ==="
echo ""
echo "Package: $PACKAGE_NAME"
echo ""

# Check if device is connected
if ! adb devices | grep -q "device$"; then
    echo "❌ No Android device connected!"
    echo "Please connect your device via USB and enable USB debugging."
    exit 1
fi

echo "✅ Device connected"
echo ""

# Get memory info
echo "📊 Current Memory Usage:"
echo "---"
adb shell dumpsys meminfo $PACKAGE_NAME | grep -E "TOTAL|Java Heap|Native Heap|Graphics|Private Dirty" | head -10
echo ""

# Check if app is running
if adb shell pm list packages | grep -q "$PACKAGE_NAME"; then
    echo "✅ App is installed"
else
    echo "❌ App is not installed"
    exit 1
fi

echo ""
echo "💡 Tips:"
echo "- Java Heap should be under 50MB for this app"
echo "- Total memory should be under 100MB"
echo "- If values are higher, check for memory leaks"
echo ""
echo "To monitor in real-time, use Android Studio Profiler:"
echo "View → Tool Windows → Profiler"

