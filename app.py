import os
from flask import Flask, request, render_template, redirect, url_for
from tensorflow.keras.models import load_model
from PIL import Image
import numpy as np
import cv2

# Initialize Flask app
app = Flask(__name__)
app.config['UPLOAD_FOLDER'] = 'static/uploaded/'
app.config['RESULT_FOLDER'] = 'static/results/'

# Load the fracture detection model
model = load_model('model/best_model_-10.h5')

# Class labels
class_labels = [
    "Elbow Positive",
    "Fingers Positive",
    "Forearm Positive",
    "Wrist Positive",
    "Humerus Fracture",
    "Shoulder Fracture"
]


# Preprocessing function
def preprocess_image(image_path):
    img = Image.open(image_path).convert('RGB')
    img = img.resize((299, 299))  # Update to 299x299 as per the model's requirement
    img_array = np.array(img) / 255.0
    return np.expand_dims(img_array, axis=0)  # Add batch dimension


@app.route('/', methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        # Handle image upload
        if 'file' not in request.files:
            return "No file uploaded", 400

        file = request.files['file']
        if file.filename == '':
            return "No file selected", 400

        # Save uploaded file
        filepath = os.path.join(app.config['UPLOAD_FOLDER'], file.filename)
        file.save(filepath)

        # Preprocess the image and make predictions
        preprocessed_image = preprocess_image(filepath)
        predictions = model.predict(preprocessed_image)

        # Get class and confidence
        class_id = np.argmax(predictions[0])
        confidence = np.max(predictions[0]) * 100
        label = f"{class_labels[class_id]} ({confidence:.2f}%)"

        # Load image for drawing bounding box (if applicable)
        image = cv2.imread(filepath)
        # Example: Draw a dummy bounding box (Replace with actual box coordinates)
        box_start = (50, 50)
        box_end = (200, 200)
        cv2.rectangle(image, box_start, box_end, (0, 255, 0), 2)
        cv2.putText(image, label, (box_start[0], box_start[1] - 10), cv2.FONT_HERSHEY_SIMPLEX, 0.5, (0, 255, 0), 2)

        # Save the resulting image
        result_path = os.path.join(app.config['RESULT_FOLDER'], file.filename)
        cv2.imwrite(result_path, image)

        return render_template('index.html', uploaded_image=filepath, result_image=result_path, label=label)

    return render_template('index.html')


if __name__ == '__main__':
    app.run(debug=True)
