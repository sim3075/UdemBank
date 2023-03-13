import java.util.*;


public class Cliente extends Usuario{
  private String numero_cuenta;
  private int saldo;
  private String tipo_cliente;

  //Constructor;
  public Cliente(int id, String nombre, String password, String tipo_cliente){
    super(id, nombre, password);
    this.numero_cuenta = generarNumeroCuenta();
    this.saldo = 0;
    this.tipo_cliente = tipo_cliente;
  }
  //Property
  public String getNumeroCuenta() {
        return numero_cuenta;
    }

  public int getSaldo() {
        return saldo;
    }
  
  public String getTipoCliente(){
    return tipo_cliente;
  }
  public void setTipoCliente(String newTipo){
    this.tipo_cliente = newTipo;
  }
  
  //Metodos;
    public void depositar(int monto) {
        this.saldo += monto;
    }

    public void retirar(int monto) {
        this.saldo -= monto;
    }

    public void transferir(int monto, Cliente destinatario) {
        this.saldo -= monto;
        destinatario.depositar(monto);
    }

    private String generarNumeroCuenta() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        String numeroAleatorio = sb.toString();
        return numeroAleatorio;
    }
    public String toString(){
      return "Cliente:"+nombre+" Número de cuenta: "+numero_cuenta+" Tipo de cliente: "+tipo_cliente;
    }
}