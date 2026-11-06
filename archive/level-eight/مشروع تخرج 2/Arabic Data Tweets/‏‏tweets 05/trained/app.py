from flask import Flask, render_template, request
import torch
from transformers import AutoTokenizer, AutoModelForSequenceClassification

app = Flask(__name__)

# Load the model and tokenizer
model_path = "checkpoint-8312"
tokenizer = AutoTokenizer.from_pretrained(model_path)
model = AutoModelForSequenceClassification.from_pretrained(model_path)

# Determine the device (CPU or GPU)
device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
model.to(device)

# Function to process text input
def process_text_input(text_input):
    results = []
    for text in text_input:
        if not text.strip():  # Skip empty or whitespace-only strings
            results.append(("Empty or invalid text input detected, skipping...", ""))
            continue
        
        # Tokenize the text and move the inputs to the device
        inputs = tokenizer(text, return_tensors="pt").to(device)
        
        # Perform the forward pass without computing gradients
        with torch.no_grad():
            logits = model(**inputs).logits
            
        # Get the predicted class id
        predicted_class_id = logits.argmax().item()
        
        # Get the label corresponding to the predicted class id
        predicted_label = model.config.id2label[predicted_class_id]
        
        # Add the result to the list
        results.append((text, predicted_label))
    
    return results

@app.route('/', methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        text_input = request.form.getlist('text_input')
        results = process_text_input(text_input)
        return render_template('index.html', results=results)
    return render_template('index.html')

if __name__ == '__main__':
    app.run(debug=True)
