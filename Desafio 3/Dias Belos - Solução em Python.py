#Algoritmo para calcular dias belos
#Autor: Scheila Fantinel & Erasmo Martínez
#Fecha: 02/07/2024

def beautiful_days(i, j, k):
    beautiful_days_count = 0

    for day in range(i, j + 1):
        reversed_day = 0
        temp = day

        # Processo para inverter o número
        while temp != 0:
            digit = temp % 10
            reversed_day = reversed_day * 10 + digit
            temp = temp // 10

        difference = 0;

        if day >= reversed_day:
            difference = day - reversed_day
        else:
            difference = reversed_day - day

        if difference % k == 0:
            beautiful_days_count += 1

    return beautiful_days_count


print("O primeiro dia deve ser sempre menor que o segundo dia")
i = int(input("Digite o valor do primeiro dia (i): "))
j = int(input("Digite o valor do segundo dia (j): "))
k = int(input("Digite o valor do número divisor (k): "))

dias = beautiful_days(i, j, k)
print(f"Número de dias bonitos: {dias}")

