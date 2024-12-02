from tensorflow.keras.models import load_model

# Load the .h5 model file
model = load_model('best_model_-10.h5')

# Print the summary of the model
print(model.summary())
