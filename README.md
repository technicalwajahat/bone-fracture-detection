# Bone Fracture Detection

Bone Fracture Detection is a web-based application that utilizes machine learning to identify fractures in X-ray images. This application helps healthcare professionals analyze X-ray scans efficiently and accurately. The frontend is built with **Tailwind CSS** for a modern and responsive UI, while the backend consists of **Flask** for image processing and **Spring Boot** for management and user data handling.

## Features

- **Fracture Detection**: Uses a machine learning model to detect fractures in uploaded X-ray images.
- **User Interface**: A clean, modern interface built with **Tailwind CSS** for responsiveness and ease of use.
- **Image Upload**: Users can upload X-ray images for analysis.
- **Real-time Results**: Provides immediate feedback on whether the X-ray shows a fracture or not.
- **Management System**: Spring Boot-based system for managing user data, scan history, and reports.
- **Role-Based Access**: Doctors and patients have different access privileges.
- **API Communication**: Flask handles image processing, and Spring Boot manages user-related functionalities.

## Tech Stack

- **Frontend**: HTML, CSS (Tailwind CSS), JavaScript
- **Backend**: Flask (Python) for image processing and machine learning
- **Management System**: Spring Boot (Java) for user data and scan history management
- **Machine Learning**: TensorFlow, Keras for deep learning-based image analysis
- **Image Processing**: OpenCV or similar libraries for preprocessing X-ray images

## Installation and Usage

### Prerequisites

Ensure you have the following installed:
- [Python 3.9+](https://www.python.org/downloads/)
- [Java 17+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- Flask and required Python libraries (`pip install flask tensorflow keras opencv-python`)
- Spring Boot dependencies (`Spring Web, Spring Data JPA, Spring Security`)
- Tailwind CSS for the frontend

## Contribution
Feel free to contribute by improving the machine learning model, enhancing the UI, or optimizing backend performance. Fork the repo and submit a pull request!

## License
This project is open-source and available under the MIT License.
