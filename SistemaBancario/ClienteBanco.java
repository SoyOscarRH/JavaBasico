public class ClienteBanco() {
	public ArrayList<Cuenta> CuentasDelCliente = new ArrayList<Cuenta>();
	private String NombreCompleto;

	
	public ClienteBanco(ArrayList<Cuenta> CuentasExistentes, String NombreCompleto){
		CuentasDelCliente = CuentasExistentes;
	}
	public String getNombreCompleto(){return NombreCompleto;}

}