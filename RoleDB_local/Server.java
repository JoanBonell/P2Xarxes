import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 12345;
    private static final String CHARACTERS_DB_NAME = "charactersDB.dat";
    private static CharactersDB charactersDB;

    public static void main(String[] args) {
        try {
            charactersDB = new CharactersDB(CHARACTERS_DB_NAME);
        } catch (IOException ex) {
            System.err.println("Error opening database!");
            System.exit(-1);
        }

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            System.err.println("Error in server: " + e.getMessage());
        }
    }

    private static void handleClient(Socket clientSocket) {
        // Implementa el tractament del client aquí
    }
}
