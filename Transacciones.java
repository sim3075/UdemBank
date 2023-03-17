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
            int type_client = input.nextInt();
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

  public void transacciones_clientes(int opcion, Cliente cliente){
    admin.leer_archivo("Clientes.txt");
      switch(opcion){
        case 1:
        System.out.println("Selecciona el id del ATM que se ajuste a su solicitud");
        for(ATM i : admin.atm_list){
            System.out.println(i.toString());
        }
        int id_atm_retirar = input.nextInt();
        ATM atm_retirar = check.obtenerATM(id_atm_retirar);
        System.out.println("Ingrese la cantidad de dinero a retirar: ");
            double valor_retirar = input.nextInt();
            double valor_platino = valor_retirar*0.005+valor_retirar;
            double valor_regular = valor_retirar*0.015+valor_retirar;
            if (valor_retirar > cliente.getSaldo()){
              System.out.println("Saldo insuficiente. ");
            }else if(valor_retirar < 0){ 
              System.out.println("Valor incorrecto. ");
            }else if(cliente.getTipoCliente() == 0){
              System.out.println("Saldo actualizado: "+cliente.retirar(valor_regular));
              atm_retirar.whithdraw_atm(valor_retirar);
            }else if(cliente.getTipoCliente() == 1){
              System.out.println("Saldo actualizado: "+cliente.retirar(valor_platino));
              atm_retirar.whithdraw_atm(valor_retirar);
            }
            break;
        case 2:
          System.out.println("Selecciona el id del ATM que se ajuste a su solicitud");
          for(ATM i : admin.atm_list){
            System.out.println(i.toString());
          }
          int id_atm_depositar = input.nextInt();
          ATM atm_depositar = check.obtenerATM(id_atm_depositar);
          System.out.println("Ingrese la cantidad de dinero a depositar: ");
            double valor_depositar = input.nextInt();
            double valor_platino_depo = valor_depositar-valor_depositar*0.005;
            double valor_regular_depo = valor_depositar-valor_depositar*0.015;
            if(valor_depositar < 0){ 
              System.out.println("Valor incorrecto. ");
            }else if(cliente.getTipoCliente() == 0){
              System.out.println("Saldo actualizado: "+cliente.depositar(valor_regular_depo));
              atm_depositar.update_Balance_atm(valor_depositar);
            }else if(cliente.getTipoCliente() == 1){
              System.out.println("Saldo actualizado: "+cliente.depositar(valor_platino_depo));
              atm_depositar.update_Balance_atm(valor_depositar);
            }
            break;

        case 3:
          System.out.println("Ingrese el id del usuario al que va transferir: ");
          int id_cliente = input.nextInt();
          if(check.verificacion_id(id_cliente)){
            Cliente cliente_transac = check.obtenerCliente(id_cliente);
            System.out.println("Ingrese el valor a tranferir: ");
            double valor_transac = input.nextInt();
            double valor_platino_transac = valor_transac+valor_transac*0.005;
            double valor_regular_transac = valor_transac+valor_transac*0.015;
            if(valor_transac < 0){
              System.out.println("valor incorrecto.");
              }else if(valor_transac > cliente.getSaldo()){
              System.out.println("Saldo insuficiente. ");
              }else if(cliente.getTipoCliente() == 0){
              System.out.println("Saldo actualizado: "+cliente.transferir(valor_regular_transac, cliente_transac));
              }else if(cliente.getTipoCliente() == 1){
              System.out.println("Saldo actualizado: "+cliente.transferir(valor_platino_transac, cliente_transac));
              }
          }else{
            System.out.println("Este usuario no existe.");
          }
  } }
}