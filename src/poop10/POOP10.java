package poop10;

import excepcionesPropias.MontoMaximoException;
import excepcionesPropias.RetirosMaximosException;
import excepcionesPropias.SaldoInsuficienteException;

/**
 *
 * @author poo01alu36
 */
public class POOP10 {

    public static void main(String[] args) {
        
        try{
            String mensajes[] = {"mensaje1","mensaje2", "mensaje3"};
            for (int i = 0; i <= mensajes.length; i++) {
                System.out.println(mensajes[i]);  
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Apuntador fuera de los límites");
            //e.printStackTrace();
        }
        
        System.out.println("################################");
        try{
            float x = 10/0;
            System.out.println("x="+x);
        }catch (ArithmeticException e){
            System.out.println("No se puede dividir entre 0");
        }finally{
            System.out.println("Cualquier cosa que suceda, entra al finally");
        }
        System.out.println("·········Catch anidado··········");
        try{
            float x = 10/0;
            System.out.println("x="+x);
        }catch (ArithmeticException e){
            System.out.println("No se puede dividir entre 0");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Apuntador fuera de los límites");
            //e.printStackTrace();
        }
        
        System.out.println("##########Propagacion de excepciones##############");
        try{
            float division = metodoDivision(4, 0);
            System.out.println("resultado:"+division);        
        }catch(ArithmeticException e){
            System.out.println("Excepción que sucede en el étodo division");
        }
        System.out.println("·······Marcadas······");
        try{
            float div = metodoDivisionMarcada(5, 0); 
        }catch(ArithmeticException e){
            System.out.println("Exepcion de division / 0 marcada");
        }
        System.out.println("··············Creación de excepciones···············");
        Cuenta cuenta = new Cuenta();
        try {
            cuenta.depositar(18_000);
            System.out.println("El saldo es: " + cuenta.getSaldo());
            cuenta.retirar(1_000);
            System.out.println("El saldo es: " + cuenta.getSaldo());
            cuenta.retirar(1_000);
            System.out.println("El saldo es: " + cuenta.getSaldo());
            cuenta.retirar(1_000);
            System.out.println("El saldo es: " + cuenta.getSaldo());
            cuenta.retirar(1_000);
            System.out.println("El saldo es: " + cuenta.getSaldo());
        } catch (SaldoInsuficienteException | MontoMaximoException | RetirosMaximosException ex) {
            System.out.println(ex.getMessage());
        }finally{
            System.out.println("El saldo es: " + cuenta.getSaldo());
        }
        
        //Ejericio No se pueden depositar mas de 20 mil y no se pueden hacer mas de tres retiros
    }
    
    private static float metodoDivision(int a, int b) {
        return a/b;
    }

    private static float metodoDivisionMarcada(int a, int b) throws ArithmeticException {
        return a/b;
    }
}



