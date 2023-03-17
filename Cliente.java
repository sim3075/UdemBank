import java.util.*;


public class Cliente extends Usuario{
  private String numero_cuenta;
  private int saldo;
  private int tipo_cliente;

  //Constructor;
  public Cliente(int id, String nombre, String password, int tipo_cliente){
    super(id, nombre, password);
    this.numero_cuenta = generarNumeroCuenta();
    this.saldo = 20000;
    this.tipo_cliente = tipo_cliente;
  }
  //Property
  public String getNumeroCuenta() {
        return numero_cuenta;
    }

  public int getSaldo() {
        return saldo;
    }
  
  public int getTipoCliente(){
    return tipo_cliente;
  }
  public void setTipoCliente(int newTipo){
    this.tipo_cliente = newTipo;
  }
  
  //Metodos;
    public int depositar(double monto) {
        this.saldo += monto;
        return this.saldo;
    }

    public int retirar(double monto) {
        this.saldo -= monto;
        return this.saldo;
    }

    public int transferir(double monto, Cliente destinatario) {
        this.saldo -= monto;
        destinatario.depositar(monto);
        return this.saldo;
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
      return id+" "+nombre+" "+password+" "+tipo_cliente;
    }
}