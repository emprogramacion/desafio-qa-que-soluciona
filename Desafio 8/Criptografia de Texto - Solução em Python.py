#Algoritmo de criptografía de texto
#Autor: Scheila Fantinel & Erasmo Martínez
#Fecha: 22/07/2024

import math

def encryption(s):
    # Remover espaços do texto original
    s = s.replace(" ", "")
    L = len(s)

    # Calcular o número de linhas e colunas
    linhas = int(math.sqrt(L))
    colunas = linhas

    # Ajustar o número de colunas se necessário
    if linhas * colunas < L:
        colunas += 1

    # Ajustar o número de linhas se necessário
    if linhas * colunas < L:
        linhas += 1

    # Criar uma lista para armazenar as colunas resultantes
    lista_colunas = [""] * colunas

    # Preencher as colunas com os caracteres correspondentes
    for i in range(L):
        coluna_index = i % colunas
        lista_colunas[coluna_index] += s[i]

    # Criar o resultado concatenando as colunas com espaços
    resultado = " ".join(lista_colunas)

    return resultado

# Testes com as entradas fornecidas
print(encryption("haveaniceday"))  # Saída esperada: "hae and via ecy"
print(encryption("feedthedog"))    # Saída esperada: "fto ehg ee dd"
print(encryption("chillout"))      # Saída esperada: "clu hlt io"
print(encryption("iuo"))           # Saída esperada: "io u"
print(encryption("wclwfoznbmyycxvaxagjhtexdkwjqhlojykopldsxesbbnezqmixfpujbssrbfhlgubvfhpfliimvmnny"))
# Saída esperada: "wmgjpnull cyjqlejgi lyhhdzbui wctlsqsbm fxeoxmsvv ovxjeirfm zadysxbhn nxkkbffpn bawobphfy"
