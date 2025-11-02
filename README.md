# Análise comparativa

Considerando que a quantidade de threads reais utilizada no pool do modelo M:N foi 100, obtemos o seguinte resultado:

## Tabela de tempos de execução para diferentes quantidades de tarefas
<img width="413" height="212" alt="image" src="https://github.com/user-attachments/assets/89c04121-1b60-4f5f-8603-31333d9ebc93" />

## Gráfico comparativo:
<img width="826" height="466" alt="image" src="https://github.com/user-attachments/assets/88e8a5c5-aa7c-4b64-9a72-c8a3bd5ba157" />

Dessa forma, foi possível observar que, quando o número de tarefas é menor ou igual ao número de threads reais, o modelo M:N (pool de threads) apresenta desempenho levemente superior, sendo mais rápido e eficiente. Isso ocorre porque todas as tarefas conseguem ser executadas em paralelo utilizando o conjunto de threads já existentes, sem a necessidade de criar novas a cada execução. Esse reaproveitamento reduz o custo de criação e destruição de threads, além de diminuir a sobrecarga do sistema com trocas de contexto e alocação de memória.<br>
Entretanto, à medida que o número de tarefas ultrapassa o número de threads reais disponíveis no pool, o desempenho do modelo M:N tende a cair. Isso acontece porque o ExecutorService precisa colocar as tarefas excedentes em uma fila de espera, fazendo com que a execução ocorra em grupos, de forma sequencial. Nesses casos, o modelo 1:1 torna-se mais vantajoso, pois cada tarefa possui sua própria thread e pode ser executada imediatamente, sem depender da liberação de threads do pool.<br>
Por outro lado, o ganho de desempenho do modelo 1:1 vem acompanhado de um custo maior. Como cada tarefa cria uma thread real, há um aumento significativo no consumo de memória e processamento, além de maior carga sobre o sistema operacional para gerenciar um grande número de threads ativas. Em ambientes com muitas tarefas, isso pode levar à perda de estabilidade e até a travamentos.<br>
Em resumo, o modelo M:N se mostra mais indicado em cenários com menor número de tarefas ou quando se busca um uso mais controlado e eficiente dos recursos do sistema. Já o modelo 1:1 tende a apresentar melhor desempenho quando é necessário executar simultaneamente um grande volume de tarefas, desde que a máquina possua recursos suficientes para suportar a criação e gerenciamento de todas as threads reais necessárias.
