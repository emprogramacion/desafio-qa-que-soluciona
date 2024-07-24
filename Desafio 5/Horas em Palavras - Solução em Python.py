#Algoritmo para calcular horas em palavras
#Autor: Scheila Fantinel & Erasmo Martínez
#Fecha: 17/07/2024

def timeInWords(h, m):
    nums = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", 
            "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", 
            "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two", 
            "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", 
            "twenty eight", "twenty nine", "half"]

    if m == 0:
        return f"{nums[h]} o' clock"
    elif m <= 30:
        if m == 15 or m == 30:
            return f"{nums[m]} past {nums[h]}"
        elif m == 1:
            return f"one minute past {nums[h]}"
        else:
            return f"{nums[m]} minutes past {nums[h]}"
    else:
        if m == 45:
            return f"quarter to {nums[(h % 12) + 1]}"
        elif m == 59:
            return f"one minute to {nums[(h % 12) + 1]}"
        else:
            return f"{nums[60 - m]} minutes to {nums[(h % 12) + 1]}"

# Testes:
print("5:00 ->", timeInWords(5, 0))
print("5:01 ->", timeInWords(5, 1))
print("5:10 ->", timeInWords(5, 10))
print("5:15 ->", timeInWords(5, 15))
print("5:28 ->", timeInWords(5, 28))
print("5:30 ->", timeInWords(5, 30))
print("5:40 ->", timeInWords(5, 40))
print("5:45 ->", timeInWords(5, 45))
print("5:47 ->", timeInWords(5, 47))
print("12:51 ->", timeInWords(12, 51))
