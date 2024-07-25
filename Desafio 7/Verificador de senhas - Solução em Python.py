#Algoritmo para verificar senhas
#Autor: Scheila Fantinel & Erasmo Martínez
#Fecha: 17/07/2024

def passwordCracker(passwords, loginAttempt):
    n = len(loginAttempt)  # Comprimento da tentativa de login
    dp = [""] * (n + 1)  # Array para armazenar a combinação de senhas usadas até cada posição
    dp[0] = ""  # Inicializa a primeira posição como string vazia, pois não é necessário nenhuma senha para formar uma string vazia

    for i in range(1, n + 1):  # Itera sobre cada posição da string de tentativa de login
        for password in passwords:  # Itera sobre cada senha na lista de senhas
            length = len(password)  # Comprimento da senha atual
            # Verifica se a posição atual é maior ou igual ao comprimento da senha, se a combinação até a posição anterior é válida
            # e se a substring da tentativa de login corresponde à senha atual
            if i >= length and dp[i - length] is not None and loginAttempt[i - length:i] == password:
                if dp[i - length] == "":  # Se a combinação até a posição anterior for uma string vazia
                    dp[i] = password  # Armazena a senha atual em dp[i]
                else:
                    dp[i] = dp[i - length] + " " + password  # Caso contrário, concatena a senha atual à combinação anterior com um espaço
                break  # Sai do loop das senhas, pois encontrou uma combinação válida para a posição atual
        else:
            dp[i] = None  # Se nenhuma senha corresponder, marca dp[i] como None

    # Retorna a combinação de senhas usada para formar loginAttempt, ou "WRONG PASSWORD" se não for possível formar a string
    return dp[n] if dp[n] is not None else "WRONG PASSWORD"

# Testes
print(passwordCracker(["because", "can", "do", "must", "we", "what"], "wedowhatwemustbecausewecan"))  # Expected: "we do what we must because we can"
print(passwordCracker(["hello", "planet"], "helloworld"))  # Expected: "WRONG PASSWORD"
print(passwordCracker(["ab", "abcd", "cd"], "abcd")) # Expected: "ab cd" or "abcd"
print(passwordCracker(["ozkxyhkcst", "xvglh", "hpdnb", "zfzahm"], "zfzahm"))  # Expected: "zfzahm"
print(passwordCracker(["gurwgrb", "maqz", "holpkhqx", "aowypvopu"], "gurwgrb"))  # Expected: "gurwgrb"
print(passwordCracker(["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"], "aaaaaaaaaab"))  # Expected: "WRONG PASSWORD"
print(passwordCracker(["ejevas", "drdv", "mgxucpnh", "wqixbctfd", "kmmam", "kjquwvis", "liznldbnh", "pivoicfu", "espropqatm", "dbrasoqg"], 
                        "cfuwqixbctfdliznldbnhkmmamlsprmpqatmljevaskmmamwqixbctfdpivoicauwgixbctfdmgxucpnhejevasdrdvpivoicfuliznldbnh"))  # Expected: "WRONG PASSWORD"
print(passwordCracker(["okweif", "rpgnteja", "ufemijimuw", "vpon", "eoncaf", "udgf", "hhtez", "aiknzgy", "bpndljur", "eeycbwv"], 
                        "ufemijimuweeycbwvokweifvponbpndljurudgfaiknzgyhhtezufemijimuwufemijimuwaiknzgyudgfufemijimuwrpgntejaeoncafvponudgfbpndljurokweifhhtezbpndljurvponufemijimuwudgfbpndljurufemijimuweoncafrpgntejaudgf"))  # Expected: "ufemijimuw eeycbwv okweif vpon bpndljur udgf aiknzgy hhtez ufemijimuw ufemijimuw aiknzgy udgf ufemijimuw rpgnteja eoncaf vpon udgf bpndljur okweif hhtez bpndljur vpon ufemijimuw udgf bpndljur ufemijimuw eoncaf rpgnteja udgf"


