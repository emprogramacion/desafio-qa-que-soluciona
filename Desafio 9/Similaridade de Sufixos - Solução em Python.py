#Algoritmo para calcular a Similaridade de Sufixos
#Autor: Scheila Fantinel & Erasmo Martínez
#Fecha: 25/07/2024

def similarity(s):
    def calculate_similarity(s, suffix):
        max_length = min(len(s), len(suffix))
        similarity_length = 0
        for i in range(max_length):
            if s[i] == suffix[i]:
                similarity_length += 1
            else:
                break
        return similarity_length

    total_similarity = 0
    n = len(s)
    
    for i in range(n):
        suffix = s[i:]
        total_similarity += calculate_similarity(s, suffix)
    
    return total_similarity


# Teste 1
test1 = "ababaa"
print("Teste 1:", similarity(test1))  # Saída esperada: 11
    
# Teste 2
test2 = "aa"
print("Teste 2:", similarity(test2))  # Saída esperada: 3
    
# Teste 3
test3 = "abcabccba"
print("Teste 3:", similarity(test3))  # Saída esperada: 13
    
# Teste 4
test4 = "eabdcbbeeedbdaebdedbcbdcdeeaebbdbedbdbccbaaeababba"
print("Teste 4:", similarity(test4))  # Saída esperada: 63
    
# Teste 5
test5 = "bcdedeccaabdaebdddaeedabedccdddccbbaaadcbbabccbaadbbbeddecacddbababbabadcbbbacecdaee"
print("Teste 5:", similarity(test5))  # Saída esperada: 105
    
# Teste 6
test6 = "aeccbdaadbcebddbadbaedeceedbcdaaadcbdebecaddedebccdbadaeed"
print("Teste 6:", similarity(test6))  # Saída esperada: 70
