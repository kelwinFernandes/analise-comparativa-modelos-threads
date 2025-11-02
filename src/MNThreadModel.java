import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MNThreadModel {
    public static void main(String[] args) {
        int numTarefas = 1000;  // N = número de tarefas (threads de usuário)
        int numThreads = 100;   // M = número de threads reais no pool

        // Criam um grupo fixo de 100 threads reais
        ExecutorService pool = Executors.newFixedThreadPool(numThreads);

        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= numTarefas; i++) {
            pool.submit(() -> { // envia a tarefa para o grupo de threads
                int soma = 0;
                for (int j = 1; j <= 1000; j++) {
                    soma += j;
                    try {
                        Thread.sleep(10); // simula trabalho
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        // Encerra o pool
        pool.shutdown();

        while (!pool.isTerminated()) {
            // Espera todas as tarefas terminarem
        }

        long fim = System.currentTimeMillis();
        System.out.println("Tempo total (N:M) = " + (fim - inicio) + " ms");
    }
}
