Questions = [{ "Question": "What is 2 + 2?", "Answer":"4"},
             { "Question": "What is 5 + 5?", "Answer":"10"},
             { "Question": "What is 7 + 4?", "Answer":"11"}]

score = 0

for q in Questions:
    answer = input(q["Question"])
    if answer == q["Answer"]:
        score += 1

print("Your score:", score)
