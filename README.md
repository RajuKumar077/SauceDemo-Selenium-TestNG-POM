# 🚀 SauceDemo Selenium Automation Framework

## 🌟 Introduction
Welcome to the **SauceDemo Selenium Automation Framework**! This project is designed to automate the end-to-end user journey on [SauceDemo](https://www.saucedemo.com/) using **Selenium WebDriver**, **TestNG**, and the **Page Object Model (POM)**.

This framework ensures a **structured, scalable, and maintainable** test automation approach for validating the following workflows:
- ✅ **User Login**
- ✅ **Product Selection**
- ✅ **Add to Cart**
- ✅ **Proceed to Checkout**
- ✅ **Logout**
- ✅ **Test Reporting with Extent Reports**

---

## 📌 Project Structure

```
SauceDemo-Selenium-TestNG-POM/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/                  # Page Object Model (POM) classes
│   │   │   │   ├── LoginPage.java       # Handles login functionality
│   │   │   │   ├── ProductPage.java     # Handles product selection
│   │   │   │   ├── CartPage.java        # Handles cart operations
│   │   │   │   ├── CheckoutPage.java    # Handles checkout process
│   │   │   │   ├── LogoutPage.java      # Handles logoff functionality
│   │   │   ├── objectrepository/        # Locators for elements
│   │   │   │   ├── Locators.java
│   │   │   ├── utils/                   # Utility functions
│   │   │   │   ├── Base.java
│   │   │   │   ├── Reporter.java
│   ├── test/
│   │   ├── java/
│   │   │   ├── tests/                   # Test cases
│   │   │   │   ├── SauceDemoTest.java   # Main test execution file
│   ├── pom.xml                           # Maven dependencies
│   ├── README.md                         # Project documentation
│   ├── testng.xml                        # TestNG suite configuration
```

---

## ⚙️ Installation & Setup

### **1️⃣ Clone the Repository**
```bash
git clone https://github.com/your-username/SauceDemo-Selenium-TestNG-POM.git
cd SauceDemo-Selenium-TestNG-POM
```

### **2️⃣ Install Dependencies**
Ensure you have:
- **Java (JDK 8+)**
- **Maven**
- **TestNG**

If not installed, install them using:
```bash
sudo apt install openjdk-11-jdk  # Ubuntu/Linux
choco install openjdk  # Windows (Chocolatey)
brew install openjdk  # macOS (Homebrew)
```

### **3️⃣ Configure WebDriver**
- Download and place **ChromeDriver** or **GeckoDriver** in the appropriate location.
- Update **Base.java** to set the WebDriver path.

### **4️⃣ Run Tests**
To execute tests, run:
```bash
mvn clean test
```
Or execute via TestNG:
```bash
Right-click on `testng.xml` > Run as TestNG Suite
```

---

## 📌 Test Scenarios Covered
| Test Case | Description |
|-----------|------------|
| **Login Test** | Validates successful login with correct credentials |
| **Product Selection** | Selects a product from the product page |
| **Add to Cart** | Adds the selected product to the shopping cart |
| **Proceed to Checkout** | Proceeds from the cart page to the checkout page |
| **Logout Test** | Logs out of the application after successful checkout |

---

## 🛠️ Technologies Used
- **Java** – Programming language
- **Selenium WebDriver** – UI automation
- **TestNG** – Test execution framework
- **Extent Reports** – Test reporting
- **Maven** – Dependency management

---

## 📊 Test Reports
After running the tests, **Extent Reports** are generated in:
```
/test-output/ExtentReports/
```
Open **index.html** to view the test execution report.

---

## 🤝 Contributing
Contributions are welcome! Feel free to **fork this repository**, make improvements, and submit a pull request.

---

---

## ✨ Author
**[Raju Kumar]** – [LinkedIn](https://www.linkedin.com/in/raju-kumar7388/) | [GitHub](https://github.com/RajuKumar077)

