import java.util.*;
import java.io.*;

public class UdemBank{
  Scanner input = new Scanner(System.in);
  Administrador admin = new Administrador();
  Verificacion check = new Verificacion();
  Administrador[] admins = {new Administrador(3456712, "Julio Cortes", "password")};

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
      check.verificar_id(id_cliente);
      
    }
    
  }
}