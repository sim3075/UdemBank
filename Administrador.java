import java.util.*;
import java.io.*;

public class Administrador extends Usuario{
  Scanner input = new Scanner(System.in);
  public List<Cliente> clientes = new ArrayList<Cliente>();
  public List<ATM> atms = new ArrayList<ATM>();
  //Constructor
  public Administrador(int id, String nombre, String password){
    super(id, nombre,  password);
  }
  //Metodos;
  public void agregarCliente(int id, String nombre, String password, String tipo_cliente) {
    Cliente cliente = new Cliente(id, nombre, password, tipo_cliente);
    clientes.add(cliente);
    escribir_txt();
    }

    public void eliminarCliente(int id) {
      try {
      Boolean check = false;
      for (Cliente i : clientes) {
        if (i.getId() == id) {
          clientes.remove(i);
          System.out.println("Cliente eliminado");
          escribir_txt();
          check = true;
          break;
        }
      }
      if (!check) {
        throw new Excepciones("Usuario no registrado.");
      }
    }catch (Excepciones e) {
      System.out.println("Intente con otro ID");
    }
    }
  
    public void modificarCliente(int id) {
      try {
      Boolean check = false;
      for (Cliente i : clientes) {
        if (i.getId() == id) {
          System.out.println("Modificar nombre: ");
          String newNombre = input.nextLine();
          System.out.println("Modificar tipo de cliente:");
          String newTipo = input.nextLine();
          i.setNombre(newNombre);
          i.setTipoCliente(newTipo);
          escribir_txt();
          check = true;
          break;
        }
      }
      if (!check) {
        throw new Excepciones("Usuario no registrado.");
      }
    }catch (Excepciones e) {
      System.out.println("Intente con otro ID");
    } 
    }

    public void agregarATM(int id, int balance_especifico) {
        ATM atm = new ATM(id, balance_especifico);
        atms.add(atm);
    }
  
    public void escribir_txt(){
      try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Clientes.txt"));
            for ( Cliente i : clientes) {
                writer.write(i.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo");
            e.printStackTrace();
        }
    }
  
}