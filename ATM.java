public class ATM{
//Atributos;
  public int balance;
  public int id;
  
//Método constructor;
  public ATM(int id, int balance){
    this.id = id;
    this.balance = balance;
  }

//Property;
  public int getId() {
        return id;
    }
    
  public int getBalance() {
        return balance;
  }
  public void setBalance(int newBalance){
      this.balance = newBalance;
  }
  public String toString(){
      return "id: "+id+"balance: "+balance;
    }
  
//Comportamientos;
  public void whithdraw_atm(int valor){
    this.balance -= valor;

  }

  public void update_Balance_atm(int valor){
    this.balance += valor;
    
    
  }
  
}