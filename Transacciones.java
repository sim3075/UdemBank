import java.util.*;
import java.io.*;

public class Transacciones{
  Scanner input = new Scanner(System.in);
  Verificacion check = new Verificacion();
  Administrador admin = new Administrador(3456712, "Julio Cortes", "password");
  public void transacciones_admin(int opcion){
    try{
        admin.leer_archivo("Clientes.txt");
        switch(opcion){
          case 1:
            System.out.println("Ingrese el id del ATM: ");
            int id_atm = input.nextInt();
            System.out.println("Ingrese el balance del ATM: ");
            int balance_atm = input.nextInt();
            //Except;
            //admin.agregarATM(id_atm, balance_atm);
            //bank.balance_general = bank.balance_general-balance_atm;
            System.out.println("ATM creado.");
            break;
            
          case 2:
            System.out.println("Ingrese el id del cliente: ");
            int id_client = input.nextInt();
            input.nextLine();
            System.out.println("Ingrese el nombre del cliente: ");
            String name_client = input.nextLine();
            System.out.println("Ingrese la contraseña del cliente: ");
            String password_client = input.nextLine();
            System.out.println("Ingrese el tipo de cliente: ");
            String type_client = input.nextLine();
            //Except;
            admin.agregarCliente(id_client, name_client, password_client, type_client);
            break;
            
          case 3:
            System.out.println("Ingrese el id del cliente para modificar el nombre y el tipo: ");
            int id_client_modify = input.nextInt();
            admin.modificarCliente(id_client_modify);
            break;

          case 4:
            System.out.println("Ingrese el id del cliente que va eliminar: ");
            int id_client_del = input.nextInt();
            admin.eliminarCliente(id_client_del);
        }
      }catch(Exception e){
        System.out.println("Ocurrio un error intentalo más tarde.");
      }
    }

  public void transacciones_clientes(){
    
  }

}