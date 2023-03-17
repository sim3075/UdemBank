import java.util.*;
import java.io.*;

public class UdemBank{
  public long balance_general = 1000000000;
  Scanner input = new Scanner(System.in);
  Administrador admin = new Administrador(3456712, "Julio Cortes", "password");
  Verificacion check = new Verificacion();
  Transacciones actions = new Transacciones();

  public void welcome(){
    System.out.println("Que tipo de usuario eres? ");
    System.out.println("1) Cliente");
    System.out.println("2) Administrador");
    int tipo_usuario = input.nextInt();
    inicio_sesion(tipo_usuario);
  }

  public void inicio_sesion(int tipo_usuario){
    if(tipo_usuario == 1){
      System.out.println("Bienvenido por favor digita tu id: ");
      int id_cliente = input.nextInt();
      input.nextLine();
      System.out.println("contraseña: ");
      String password = input.nextLine();
      if(check.verificacion_id(id_cliente) && check.verificacion_password(password)){
        Cliente cliente = check.obtenerCliente(id_cliente);
        System.out.println("Elija una opción");
        System.out.println("(1) Retirar desde un ATM");
        System.out.println("(2) Depositar desde un ATM");
        System.out.println("(3) Transferir");
        System.out.println("Ingrese su respuesta: ");
        int respuesta = input.nextInt();
        actions.transacciones_clientes(respuesta, cliente);
        
      }else{
        System.out.println("Usuario no registrado.");
      }
      
    }else if(tipo_usuario == 2){
      System.out.println("Bienvenido por favor digita tu id: ");
      int id_admin = input.nextInt();
      input.nextLine();
      System.out.println("contraseña: ");
      String password_admin = input.nextLine();
      if(check.verificacion_id_admin(id_admin) && check.verificacion_password_admin(password_admin)){
        System.out.println("Elija una opción");
        System.out.println("(1) Crear un ATM");
        System.out.println("(2) Agregar un cliente");
        System.out.println("(3) Modificar cliente");
        System.out.println("(4) Eliminar cliente");
        System.out.println("Ingrese su respuesta: ");
        int respuesta = input.nextInt();
        actions.transacciones_admin(respuesta);
      }
      
    }
    
  }
  
}