import java.util.*;
import java.io.*;

public class Verificacion{
  Administrador admin = new Administrador(3456712, "Julio Cortes", "password");
  Administrador[] admins = {admin};
  
  public Boolean verificacion_id(int id){
      admin.leer_archivo("Clientes.txt");
      for (Cliente i : admin.clientes) {
        if (i.getId() == id) {
          return true;
        }
      }
      return false;
    }
  public Boolean verificacion_password(String password){
      admin.leer_archivo("Clientes.txt");
      for (Cliente i : admin.clientes) {
        if (i.getPassword().equals(password)) {
          return true;
        }
      }
      return false;
  }
  public Boolean verificacion_id_admin(int id){
      for (Administrador i : admins) {
        if (i.getId() == id) {
          return true;
        }
      }
      return false;
    }
    public Boolean verificacion_password_admin(String password){
      for (Administrador i : admins) {
        if (i.getPassword().equals(password)) {
          return true;
        }
      }
      return false;
  }
  public Boolean verificacion_id_atm(int id_atm){
      for (ATM i : admin.atm_list) {
        if (i.getId() == id_atm) {
          return true;
        }
      }
      return false;
  }
}
