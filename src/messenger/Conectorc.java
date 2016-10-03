
package messenger;
import java.net.*;
import java.io.*;

public class Conectorc extends Thread{
    private Socket s;
    private ServerSocket ss;
    private InputStreamReader entradaSocket;
    private DataOutputStream salida;
    private BufferedReader entrada;
    final int puerto = 8180;
    chat m=new chat();
    
    public Conectorc(String ip)
    {
        try{
            this.s = new Socket(ip,this.puerto);
            
            this.entradaSocket = new InputStreamReader(s.getInputStream());
            this.entrada = new BufferedReader(entradaSocket);
            
            this.salida= new DataOutputStream(s.getOutputStream());
             //this.salida.writeUTF("  11657 16283 12483 12505 11657 12520 10091 8705 16283 ");
            
        }catch (Exception e){};
    }
    
    public void run()
    {
        String texto;
        while(true)
        {try{
            texto = entrada.readLine();
            texto=m.desencriptar(texto);
            
            VCliente.jTextArea1.setText(VCliente.jTextArea1.getText()+"\n El:  "+ texto);
            
        }catch(IOException e){};
        }
    }
   
    public void enviarMSG(String msg)
    {
        
        System.out.println("enviado");
        VCliente.jTextArea1.setText(VCliente.jTextArea1.getText()+"\n Tu:  "+msg);
        msg=m.espacio(msg);
        try{
            this.salida = new DataOutputStream(s.getOutputStream());
            this.salida.writeUTF(msg+"\n");
        }catch (IOException e){
            System.out.println("Problema al enviar");
        };
    }
    
    
}
