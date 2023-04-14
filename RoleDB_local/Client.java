import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private static final String SERVER_IP = "127.0.0.1"; // Canviï aquesta adreça IP si el servidor s'executa en una màquina diferent
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));

            for (;;) {
                printMenu();
                int option = getOption(consoleIn);
                out.writeInt(option);
                out.flush();

                switch (option) {
                    case 1:
                        listNames(in);
                        break;
                    case 2:
                        infoFromOneCharacter(in, out, consoleIn);
                        break;
                    case 3:
                        addCharacter(in, out, consoleIn);
                        break;
                    case 4:
                        deleteCharacter(in, out, consoleIn);
                        break;
                    case 5:
                        quit(socket, in, out);
                        break;
                }
                System.out.println();
            }
        } catch (UnknownHostException e) {
            System.err.println("Impossible connectar amb el servidor.");
        } catch (IOException e) {
            System.err.println("Error en la comunicació amb el servidor.");
        }
    }

    // Implementa les funcions que tracten cada opció de menú aquí
}
