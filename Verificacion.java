import java.util.*;
import java.io.*;

public class Verificacion{
  Administrador admin = new Administrador(3456712, "Julio Cortes", "password");
  Administrador[] admins = {admin};
  
  //Verificaciones del cliente;
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

  //Verificaciones del administrador;
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

  //Metodos para obtener los objetos segun el id;
  public Cliente obtenerCliente(int id) {
    for (Cliente cliente : admin.clientes) {
      if (cliente.getId() == id) {
        return cliente;
        }
    }
    return null;
  }

    public ATM obtenerATM(int id) {
    for (ATM atm : admin.atm_list) {
      if (atm.getId() == id) {
        return atm;
        }
    }
    return null;
  }
}
