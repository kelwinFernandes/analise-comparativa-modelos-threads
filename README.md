# Análise comparativa

Considerando que a quantidade de threads reais utilizada no pool do modelo M:N foi 100, obtemos o seguinte resultado:

## Tabela de tempos de execução para diferentes quantidades de tarefas
<img width="413" height="212" alt="image" src="https://github.com/user-attachments/assets/89c04121-1b60-4f5f-8603-31333d9ebc93" />

## Gráfico comparativo:
<img width="826" height="466" alt="image" src="https://github.com/user-attachments/assets/88e8a5c5-aa7c-4b64-9a72-c8a3bd5ba157" />

Dessa forma foi possível observar que, quando o número de tarefas é menor ou igual ao número de threads reais, o modelo M:N (pool de threads) é mais rápido e eficiente,
pois todas as tarefas rodam em paralelo sem precisar criar novas threads.
Além disso, há menos custo de criação e troca de contexto.
Mas quando o número de tarefas ultrapassa o número de threads reais, o modelo 1:1 tende a ser mais rápido, porque cada tarefa ganha sua própria thread e pode ser executada imediatamente, sem precisar esperar na fila do pool.
Por outro lado, esse ganho vem com um custo: o 1:1 consome mais memória e CPU,
então em cenários grandes ele pode se tornar mais pesado e até instável.
Em resumo, o modelo M:N é mais vantajoso em cenários com poucas tarefas ou quando se busca economia de recursos, enquanto o modelo 1:1 tende a ter melhor desempenho quando há muitas tarefas que precisam ser executadas simultaneamente, desde que o sistema suporte a criação de todas as threads necessárias.
