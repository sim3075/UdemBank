public class ATM{
//Atributos;
  private int balance;
  private int id;
  
//Método constructor;
  public ATM(int id, int balance){
    this.id = id;
    this.balance = balance;
  }

//Property;
  public String getId() {
        return id;
    }
    
  public int getBalance() {
        return balance;
  }
  public void setBalance(int newBalance){
      this.balance = newBalance;
  }
  
//Comportamientos;
  public void whithdraw_atm(int valor){
    this.balance -= valor;

  }

  public void update_Balance_atm(int valor){
    this.balance += valor;
    
    
  }
  
}