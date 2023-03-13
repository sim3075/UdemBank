import java.util.*;
import java.io.*;

public class Administrador extends Usuario{
  Scanner input = new Scanner(System,in);
  //Constructor
  public Administrador(int id, String nombre, String password){
    super(id, nombre,  password);
  }
  //Metodos;
  public void agregarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void eliminarCliente(Cliente cliente) {
        this.clientes.remove(cliente);
    }

    public void modificarCliente(Cliente cliente) {
        //Código para modificar en cliente;
        
      
    }

    public void agregarATM(ATM atm) {
        this.atms.add(atm);
    }

    public void eliminarATM(ATM atm) {
        this.atms.remove(atm);
    }

    public void modificarATM(ATM atm) {
        // Código para modificar un ATM
    }
}