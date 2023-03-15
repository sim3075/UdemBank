import java.util.*;
import java.io.*;

public class Verificacion{
  Administrador admin = new Administrador(3456712, "Julio Cortes", "password");
  public Boolean verificacion_id(int id){
    try{
       Boolean check = false;
      for (Cliente i : admin.clientes) {
        if (i.getId() == id) {
          return true;
          check = true;
          break;
        }
      }
      if (!check) {
        throw new Excepciones("Usuario no registrado.");
      }

    } catch (Excepciones e) {
      System.out.println("Error inesperado.");
    }
    }
  }
  
}