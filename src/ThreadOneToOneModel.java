public class ThreadOneToOneModel {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = 1000; // threads reais

        Thread[] threads = new Thread[numThreads];

        long inicio = System.currentTimeMillis();

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                int soma = 0;
                for (int j = 1; j <= 1000; j++) {
                    soma += j;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start(); // inicia a thread
        }

        // Espera todas terminarem
        for (Thread t : threads) {
            t.join();
        }

        long fim = System.currentTimeMillis();
        System.out.println("Tempo total (1:1) = " + (fim - inicio) + " ms");
    }
}
