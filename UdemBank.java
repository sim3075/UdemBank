import java.util.*;
import java.io.*;

public class UdemBank{
  public long balance_general = 1000000000;
  Scanner input = new Scanner(System.in);
  Administrador admin = new Administrador(3456712, "Julio Cortes", "password");
  Verificacion check = new Verificacion();
  Administrador[] admins = {admin};

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
      if(check.verificacion_id(id_cliente)){
        
      }
      
    }else if(tipo_usuario == 2){
      System.out.println("Bienvenido por favor digita tu id: ");
      int id_admin = input.nextInt();
      if(check.verificacion_id(id_admin)){
        
      }
      
    }
    
  }
}