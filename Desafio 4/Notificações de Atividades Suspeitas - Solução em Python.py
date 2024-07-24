#Algoritmo para calcular notificações de atividades suspeitas 
#Autor: Scheila Fantinel & Erasmo Martínez
#Fecha: 02/07/2024

def activityNotifications(despesas, dias):
    # Inicializa el contador de notificaciones.
    notificacoes = 0

    # Recorre la lista de despesas a partir del índice 'dias' hasta el final.
    for i in range(dias, len(despesas)):
        # Obtiene los datos de los últimos 'dias' días.
        dados_antigos = despesas[i-dias:i]
        
        # Ordena los datos.
        dados_antigos.sort()
        
        # Calcula la mediana.
        n = len(dados_antigos)
        meio = n // 2
        
        # Si el número de elementos es impar, la mediana es el elemento del medio.
        if n % 2 == 1:
            mediana = dados_antigos[meio]
        # Si el número de elementos es par, la mediana es el promedio de los dos elementos del medio.
        else:
            mediana = (dados_antigos[meio - 1] + dados_antigos[meio]) / 2
        
        # Verifica si el gasto actual es al menos el doble de la mediana calculada.
        if despesas[i] >= 2 * mediana:
            # Incrementa el contador de notificaciones.
            notificacoes += 1
    
    # Retorna el número total de notificaciones calculado.
    return notificacoes

# Ejemplos de uso de la función para verificar la salida y entender su funcionamiento.
print(activityNotifications([2, 3, 4, 2, 3, 6, 8, 4, 5], 5))  # Salida: 2
print(activityNotifications([1, 2, 3, 4, 4], 4))  # Salida: 0
print(activityNotifications([10, 20, 30, 40, 50, 60, 70, 80, 90], 5))  # Salida: 1
print(activityNotifications([1, 2, 100, 2, 2, 2, 2, 2], 4))  # Salida: 0
