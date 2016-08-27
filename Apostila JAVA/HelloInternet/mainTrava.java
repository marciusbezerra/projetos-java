
public class mainTrava {
	public static void main(String[] args) {
		Trava umatrava;
		umatrava=new Trava();
		
		umatrava.travar("ProgramaPrincipal");
		System.out.println(umatrava.estado());
		umatrava.destravar("ProgramaPrincipal");
		System.out.println(umatrava.estado());
	}
	
}