
package messenger;


public class Messenger {
    
    public static Conectorc cliente;
    public static void main (String[] args){
        VCliente cliente = new VCliente();
        cliente.show();
    }
    
    public static void initCliente(String ip)
    {
        cliente = new Conectorc(ip);
        cliente.start();
    }
    
}
