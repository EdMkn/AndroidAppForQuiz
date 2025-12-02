# Quick Start Guide

## 🚀 Run the App in 3 Steps

1. **Open in Android Studio**
   - File → Open → Select this folder
   - Wait for Gradle sync to complete

2. **Start Emulator or Connect Device**
   - Tools → Device Manager → Create/Start emulator
   - OR connect your Android phone via USB (enable USB debugging)

3. **Run**
   - Click the green ▶️ button
   - OR press `Shift + F10`

## 📱 What You'll See

1. **Welcome Screen**: Tap "Start Quiz"
2. **Quiz Screen**: Answer 10 questions about Java 17-21
3. **Results Screen**: See your score and restart

## 🎯 Key Files to Explore

- `QuestionBank.kt` - Add/edit questions here
- `QuizActivity.kt` - Main quiz logic
- `activity_quiz.xml` - Quiz UI layout
- `strings.xml` - All text strings

## 💡 Pro Tips

- Questions are randomized each time
- Currently shows 10 questions (change in `QuizActivity.kt` line 40)
- All questions are about Java 17-21 features
- Explanations appear after each answer

## 🐛 Common Issues

**"Cannot resolve symbol" errors?**
→ Wait for Gradle sync to finish (bottom right of Android Studio)

**App crashes on launch?**
→ Check Logcat for error messages (bottom panel in Android Studio)

**Can't find emulator?**
→ Tools → Device Manager → Create Virtual Device

---

That's it! Start exploring and learning Android development! 🎓

