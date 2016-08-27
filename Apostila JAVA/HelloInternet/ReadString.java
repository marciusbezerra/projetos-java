
import java.io.DataInputStream; // classe DataInputStream para entrada de dados

public class ReadString {
	public static void main(String[] args) {
		String linha="";
		DataInputStream meuDataInputStream;
		meuDataInputStream =new DataInputStream(System.in);
		try {
			linha=meuDataInputStream.readLine();
		}
		catch (Exception e) {
			System.out.println ("Erro de leitura.");
		}
		System.out.println (linha);
	}
}

