package poop10;

import excepcionesPropias.MontoMaximoException;
import excepcionesPropias.RetirosMaximosException;
import excepcionesPropias.SaldoInsuficienteException;

/**
 *
 * @author poo01alu36
 */
class Cuenta {
    private double saldo;
    private int retiros;

    public Cuenta() {
    }
    /**
     * Método para retirar
     * @param monto Monto a retirar 
     * @throws SaldoInsuficienteException Arroja esto si no se tiene suficiente dinero en la cuenta
     * @throws RetirosMaximosException Arroja esto si los retiros superan 3
     */
    public void retirar(double monto) throws SaldoInsuficienteException, RetirosMaximosException {
        System.out.println("Retirando.... $" + monto);
        if(this.retiros >= 3)
            throw new RetirosMaximosException();
        if(saldo<monto)
            throw new SaldoInsuficienteException();
        else{
            this.saldo -= monto;
            this.retiros++;
        } 
    }
    /**
     * Método para depositar en la cuenta
     * @param monto Monto a depositar
     * @throws MontoMaximoException arroja esto si el monto supera 20,000
     */
    public void depositar(double monto) throws MontoMaximoException{
        System.out.println("Depositando...$"+monto);
        if (monto>20_000) {
            throw new MontoMaximoException();
        }else
        {
            saldo += monto;
        }
    }
    /**
     * 
     * @return Saldo de la cuenta
     */
    public double getSaldo() {
        return saldo;
    }
    /**
     * 
     * @return Numero de retiros
     */
    public double getRetiros() {
        return retiros;
    }
    @Override
    public String toString() {
        return "Cuenta{" + "saldo=" + saldo + '}';
    }
}