public class ClienteBanco(){
	public ArrayList<Cuentas> CuentasDelCliente = new ArrayList<Cuentas>();
	private String NombreCompleto;

	
	public ClienteBanco(ArrayList<Cuentas> CuentasExistentes, String NombreCompleto){
		CuentasDelCliente = CuentasExistentes;
	}
	public getNombreCompleto(){return NombreCompleto;}

}