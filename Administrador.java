import java.util.*;
import java.io.*;

public class Administrador extends Usuario{
  Scanner input = new Scanner(System.in);
  public List<Cliente> clientes = new ArrayList<Cliente>();
  ATM[] atm_list = {new ATM(11, 100000000), new ATM(12, 200000000), new ATM(13, 300000000), new ATM(14, 400000000)};
  //Constructor
  public Administrador(int id, String nombre, String password){
    super(id, nombre,  password);
  }
  //Metodos;
  public void agregarCliente(int id, String nombre, String password, int tipo_cliente) {
    Cliente cliente = new Cliente(id, nombre, password, tipo_cliente);
    clientes.add(cliente);
    escribir_txt("Clientes.txt");
    }

    public void eliminarCliente(int id) {
      try {
      Boolean check = false;
      for (Cliente i : clientes) {
        if (i.getId() == id) {
          clientes.remove(i);
          sobre_escribir_archivo("Clientes.txt");
          escribir_txt("Clientes.txt");
          System.out.println("Cliente eliminado");
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
          sobre_escribir_archivo("Clientes.txt");
          System.out.println("Modificar nombre: ");
          String newNombre = input.nextLine();
          System.out.println("Modificar tipo de cliente:");
          int newTipo = input.nextInt();
          i.setNombre(newNombre);
          i.setTipoCliente(newTipo);
          escribir_txt("Clientes.txt");
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

    //public void agregarATM(int id, int balance_especifico) {
        //ATM atm = new ATM(id, balance_especifico);
        //atms.add(atm);
    //}
  
    public void escribir_txt(String ruta){
      try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));
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
    public void leer_archivo(String ruta){
      try{
      Scanner lectorArchivo = new Scanner(new File(ruta));
      while (lectorArchivo.hasNextLine()) {
        String linea = lectorArchivo.nextLine();
        String[] campos = linea.split(" ");
        if (campos.length == 4) {
          int id = Integer.parseInt(campos[0]);
          String nombre = campos[1];
          String password = campos[2];
          int tipo = Integer.parseInt(campos[3]);
          Cliente cliente = new Cliente(id, nombre, password, tipo);
          clientes.add(cliente);
        }
      }
      }catch(FileNotFoundException e) {
        System.out.println("Except");
      }
    }
    public void sobre_escribir_archivo(String ruta){
        try {
            FileWriter writer = new FileWriter(ruta, false);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al borrar el archivo: ");
        }
    }
}