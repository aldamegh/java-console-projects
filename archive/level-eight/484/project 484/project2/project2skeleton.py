import glob
import os
import math
import re


def load_data(directory):
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
    model = {
        'ham_count': 0,
        'spam_count': 0,
        'ham_fd': {},
        'spam_fd': {}
    }
    for document, label in zip(x, y):
        words = re.findall(r'\b\w+\b', document.lower())
        if label == 0:
            model['ham_count'] += 1
            update_frequency_distribution(words, model['ham_fd'])
        else:
            model['spam_count'] += 1
            update_frequency_distribution(words, model['spam_fd'])
    return model

def update_frequency_distribution(words, freq_dict):
    for word in words:
        if word in freq_dict:
            freq_dict[word] += 1
        else:
            freq_dict[word] = 1


def nb_test(docs, trained_model, use_log=False, smoothing=False):
    predictions = []
    # Calculate the prior probabilities
    total_emails = trained_model['ham_count'] + trained_model['spam_count']
    prior_ham = trained_model['ham_count'] / total_emails
    prior_spam = trained_model['spam_count'] / total_emails
    
    # Pre-calculate total words in ham and spam for smoothing
    total_ham_words = sum(trained_model['ham_fd'].values())
    total_spam_words = sum(trained_model['spam_fd'].values())
    vocab_size = len(set(trained_model['ham_fd']).union(set(trained_model['spam_fd'])))

    for doc in docs:
        words = re.findall(r'\b\w+\b', doc.lower())
        # Calculate the log probabilities or direct probabilities
        ham_prob = math.log(prior_ham) if use_log else prior_ham
        spam_prob = math.log(prior_spam) if use_log else prior_spam
        
        for word in words:
            if smoothing:
                # Add-one Laplace smoothing
                ham_word_prob = (trained_model['ham_fd'].get(word, 0) + 1) / (total_ham_words + vocab_size)
                spam_word_prob = (trained_model['spam_fd'].get(word, 0) + 1) / (total_spam_words + vocab_size)
            else:
                # No smoothing
                ham_word_prob = trained_model['ham_fd'].get(word, 0) / total_ham_words if trained_model['ham_fd'].get(word, 0) > 0 else 1e-10
                spam_word_prob = trained_model['spam_fd'].get(word, 0) / total_spam_words if trained_model['spam_fd'].get(word, 0) > 0 else 1e-10
            
            if use_log:
                ham_prob += math.log(ham_word_prob)
                spam_prob += math.log(spam_word_prob)
            else:
                ham_prob *= ham_word_prob
                spam_prob *= spam_word_prob
        
        # Compare the probabilities to classify
        if use_log:
            prediction = 0 if ham_prob > spam_prob else 1
        else:
            prediction = 0 if ham_prob >= spam_prob else 1
        
        predictions.append(prediction)
    
    return predictions
    
def f_score(y_true, y_pred):
    true_positives = sum(1 for true, pred in zip(y_true, y_pred) if true == pred == 1)
    false_positives = sum(1 for true, pred in zip(y_true, y_pred) if true == 0 and pred == 1)
    false_negatives = sum(1 for true, pred in zip(y_true, y_pred) if true == 1 and pred == 0)

    precision = true_positives / (true_positives + false_positives) if true_positives + false_positives > 0 else 0
    recall = true_positives / (true_positives + false_negatives) if true_positives + false_negatives > 0 else 0
    
    if precision + recall == 0:
        return 0
    return 2 * (precision * recall) / (precision + recall)




if __name__ == "__main__":
    x_train, y_train = load_data("./SPAM_training_set/")
    model = nb_train(x_train, y_train)
    x_test, y_test = load_data("./SPAM_test_set/")
    configurations = [
        {"use_log": False, "smoothing": False},
        {"use_log": False, "smoothing": True},
        {"use_log": True, "smoothing": False},
        {"use_log": True, "smoothing": True}
    ]
    results = {}
    for config in configurations:
        y_pred = nb_test(x_test, model, use_log=config["use_log"], smoothing=config["smoothing"])
        f1 = f_score(y_test, y_pred)
        results[f"Log: {config['use_log']}, Smoothing: {config['smoothing']}"] = f1

    for config, f1_score in results.items():
        print(f"{config} -> F1-score: {f1_score:.4f}")

