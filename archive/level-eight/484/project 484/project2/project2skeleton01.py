import glob
import os
import numpy as np
from sklearn.metrics import f1_score

def load_data(directory):
  """
  Loads the email data from the specified directory.

  Args:
    directory: The directory containing the email files.

  Returns:
    A tuple containing two lists: x (documents) and y (labels).
  """
  x = []
  y = []
  for f in glob.glob(os.path.join(directory, "HAM.*.txt")):
    with open(f, 'r') as file:
      x.append(file.read())
      y.append(0)
  for f in glob.glob(os.path.join(directory, "SPAM.*.txt")):
    with open(f, 'r') as file:
      x.append(file.read())
      y.append(1)
  return x, y

def nb_train(x, y):
  """
  Trains a Naive Bayes classifier on the given data.

  Args:
    x: A list of documents (strings).
    y: A list of labels (0 for HAM, 1 for SPAM).

  Returns:
    A dictionary representing the trained model.
  """
  model = {
    'ham_count': 0,
    'spam_count': 0,
    'ham_fd': {},
    'spam_fd': {}
  }

  for label in y:
    if label == 0:
      model['ham_count'] += 1
    else:
      model['spam_count'] += 1

  for i, doc in enumerate(x):
    label = y[i]
    words = doc.split()
    for word in words:
      if label == 0:
        model['ham_fd'][word] = model['ham_fd'].get(word, 0) + 1
      else:
        model['spam_fd'][word] = model['spam_fd'].get(word, 0) + 1

  return model

def nb_test(docs, model, use_log=False, smoothing=False):
  """
  Tests a trained Naive Bayes classifier on new documents.

  Args:
    docs: A list of documents (strings).
    model: The trained Naive Bayes model.
    use_log: Whether to use log calculations (True) or multiplication (False).
    smoothing: Whether to use add-one smoothing (True) or not (False).

  Returns:
    A list of predicted labels (0 for HAM, 1 for SPAM).
  """
  predictions = []
  for doc in docs:
    words = doc.split()
    ham_prob = 0.0
    spam_prob = 0.0
    for word in words:
      ham_count = model['ham_fd'].get(word, 0)
      spam_count = model['spam_fd'].get(word, 0)
      if use_log:
        ham_prob += np.log((ham_count + smoothing) / (model['ham_count'] + len(model['ham_fd']) * smoothing))
        spam_prob += np.log((spam_count + smoothing) / (model['spam_count'] + len(model['spam_fd']) * smoothing))
      else:
        ham_prob *= (ham_count + smoothing) / (model['ham_count'] + len(model['ham_fd']) * smoothing)
        spam_prob *= (spam_count + smoothing) / (model['spam_count'] + len(model['spam_fd']) * smoothing)
    if ham_prob > spam_prob:
      predictions.append(0)
    else:
      predictions.append(1)
  return predictions

def f_score(y_true, y_pred):
  """
  Calculates the F1-score for the given predictions.

  Args:
    y_true: A list of true labels.
    y_pred: A list of predicted labels.

  Returns:
    The F1-score.
  """
  return f1_score(y_true, y_pred)

# Load the training and test data
x_train, y_train = load_data("./SPAM_training_set/")
x_test, y_test = load_data("./SPAM_test_set/")

# Train the model
model = nb_train(x_train, y_train)

# Run the experiments
print("F1-score without log and without smoothing:", f_score(y_test, nb_test(x_test, model, use_log=False, smoothing=False)))
print("F1-score with log and without smoothing:", f_score(y_test, nb_test(x_test, model, use_log=True, smoothing=False)))
print("F1-score without log and with smoothing:", f_score(y_test, nb_test(x_test, model, use_log=False, smoothing=True)))
print("F1-score with log and with smoothing:", f_score(y_test, nb_test(x_test, model, use_log=True, smoothing=True)))

# Test the model with a new email
test_email = """Subject: Free Viagra!

This is your chance to get free Viagra! Just click here: https://www.viagra.com

Don't miss out!"""

# Predict the label
prediction = nb_test([test_email], model)[0]

# Print the result
if prediction == 0:
  print("The email is classified as HAM.")
else:
  print("The email is classified as SPAM.")