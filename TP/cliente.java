import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
 

public class Cliente {
 
    public void iniciar(String endereco, int porta) {
		ObjectOutputStream saida;
        ObjectInputStream entrada;
        Socket conexao;
        try {
            conexao = new Socket("127.0.0.1", 5050);
           
 
            // ligando as conexoes de saida e de entrada
            saida = new ObjectOutputStream(conexao.getOutputStream());
            saida.flush();
            entrada = new ObjectInputStream(conexao.getInputStream());
 
            //lendo a mensagem enviada pelo servidor
            mensagem = (String) entrada.readObject();
            System.out.println("Servidor>> "+mensagem);
 
            do {
                System.out.print("..: ");
                mensagem = ler.nextLine();
				//ida
				
                saida.writeObject(mensagem);
                saida.flush();
                //lendo a mensagem enviada pelo servidor
                mensagem = (String) entrada.readObject();
				
				//volta
				
                System.out.println("Servidor>> "+mensagem);
            } while (!mensagem.equals("FIM"));
 
            saida.close();
            entrada.close();
            conexao.close();
 
        } catch (Exception e) {
            System.err.println("erro: " + e.toString());
        }
 
    }
 
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Uso: java tcp.Cliente <endereco-IP> <porta>");
            System.exit(1);
        }
 
        Cliente c = new Cliente();
        c.iniciar(args[0], Integer.parseInt(args[1]));
    }
}