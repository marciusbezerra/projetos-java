
import java.io.DataInputStream;

public class ReadInt {
	public static void main(String[] args) {
		String linha;
		DataInputStream in = new DataInputStream(System.in);
		try {
			linha = in.readLine();
			int i = Integer.valueOf(linha).intValue();
			System.out.println (i);
		}
		catch (Exception e) {
			System.out.println ("ERRO!!");
		}
	}
}