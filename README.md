# 📱 Mobile Automation Basics

This repository contains **Android mobile automation practice examples** built using **Appium, Java, and TestNG**.  
It covers **core mobile automation concepts**, commonly used **UI elements**, and **touch gestures** implemented using **W3C Actions**.

This project is intended for **learning, practice, and interview preparation**.

---

## 🔧 Tech Stack
- **Java**
- **Appium**
- **Selenium 4 (W3C Actions)**
- **TestNG**
- **Maven**
- **Android Emulator / Real Device**

---

## 📦 Applications Automated
- **API Demos (Android)**
- **Android System Apps**
  - Calculator
  - Dialer
  - Messages
  - WiFi Settings

---

## 📂 Project Structure

Mobile_Automation_Basics
│
├── src/test/java
│ └── com.appium.tests
│ ├── ApiDemosTest.java
│ ├── Calculator.java
│ ├── CheckBoxTest.java
│ ├── DialNumberTest.java
│ ├── DragAndDropTest.java
│ ├── MessagesTest.java
│ ├── RadioButtonTest.java
│ ├── SeekBarTest.java
│ ├── TextBoxTest.java
│ └── WifiSwitchTest.java
│
├── pom.xml
├── README.md


---

## 🧪 Test Scenarios Covered

### ✅ Basic UI Elements
- Text Box (EditText)
- Check Box
- Radio Button
- Switch / Toggle

### ✅ Gestures & Interactions
- Vertical scrolling (UiScrollable & W3C swipe)
- Drag and Drop (W3C PointerInput & Sequence)
- SeekBar / Slider handling

### ✅ System App Automation
- Dial a phone number
- Calculator operations
- Open Messages app
- Enable / Disable WiFi

---

## 🚀 How to Run the Tests

### Prerequisites
- Java installed
- Android Emulator or Real Device
- Appium Server running
- API Demos app installed

### Steps
1. Start Android Emulator
2. Start Appium Server
3. Clone the repository
4. Run tests using Maven or TestNG

```bash
mvn test
