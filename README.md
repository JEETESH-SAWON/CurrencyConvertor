# App Preview

![1](https://github.com/user-attachments/assets/59a69ff7-80f9-4a57-953a-908897869219)
![2](https://github.com/user-attachments/assets/b94a24d5-202d-48b2-82f9-ca4e5977a530)

# 💱 Simple Currency Converter

![Currency Converter UI](your-image-url-here)

A **Java-based currency converter** using AWT for the graphical interface and [v6.exchangerate-api](https://www.exchangerate-api.com/) to fetch real-time exchange rates. It processes JSON data using Google's `gson` library to perform live currency conversions relative to USD.

---

## 🚀 Features

* 🔄 Convert any currency in real-time using live exchange rates
* 🖥️ User-friendly GUI built with Java AWT
* 🌐 Fetches latest data via `v6.exchangerate-api`
* 📆 JSON parsing with `gson`

---

## 🛠️ Technologies Used

* **Java AWT** – for creating the GUI
* **v6.exchangerate-api** – to retrieve current exchange rates
* **Google Gson** – for parsing JSON response

---



## 🔧 How to Run

1. Clone this repository:

   ```bash
   git clone https://github.com/your-username/your-repo-name.git
   ```

2. Make sure you have Java installed (JDK 8 or above)

3. Run the application:

   ```bash
   javac CurrencyConverter.java  
   java CurrencyConverter
   ```

---

## 📨 API Key Setup

This project uses the free tier of [v6.exchangerate-api](https://www.exchangerate-api.com/).
You’ll need to get your own API key and replace it in the code at:

```java
String apiUrl = "https://v6.exchangerate-api.com/v6/YOUR_API_KEY/latest/USD";
```

---

## 📜 License

This project is open-source and available under the [MIT License](LICENSE).

---

## 🙌 Acknowledgments

* [ExchangeRate API](https://www.exchangerate-api.com/)
* [Google Gson](https://github.com/google/gson)

