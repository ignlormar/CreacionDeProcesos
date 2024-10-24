package KillProcess;

import java.io.IOException;

public class ProcessKillNotepad {
    public static void main(String[] args) {
        try {
            Process proceso = new ProcessBuilder("pluma").start();
            Thread.sleep(10000);

            if (proceso.isAlive()){
                proceso.destroy();
            }
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
