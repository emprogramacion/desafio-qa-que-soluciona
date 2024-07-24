#Algoritmo para fazer uma escada
#Autor: Scheila Fantinel
#Fecha: 28/06/2024

n=int(input("Introduza o número para fazer a escada: "))
print("\n")


def escadaria(n):
    for i in range(1, n + 1):
        print(' ' * (n - i) + '#' * i)

escadaria(20)
