public class Usuario{
  //Atributos;
  int id;
  String nombre;
  String password;

  //Constructor;
  public Usuario(int id, String nombre, String password){
    this.id = id;
    this.nombre = nombre;
    this.password = password;
  }

  //property;
  public String getNombre() {
        return nombre;
    }
  public void setNombre(String newNombre){
    this.nombre = newNombre;
  }
    
  public int getId() {
        return id;
  }
  public void setId(int newId){
      this.id = newId;
    }
    
  public String getPassword() {
        return password;
    }
  public void setPassword(String newPassword){
      this.password = newPassword;
    }
  
}