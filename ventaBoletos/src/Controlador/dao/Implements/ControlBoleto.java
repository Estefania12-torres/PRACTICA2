/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.dao.Implements;

import Controlador.*;
import Controlador.TDA.Listas.ListaEnlazada;
import Controlador.dao.DaoImplements;
import modelo.Boleto;

/**
 *
 * @author Usuario
 */
public class ControlBoleto extends DaoImplements<Boleto> {

    private ListaEnlazada<Boleto> boletos = new ListaEnlazada<>();
    private Boleto boleto = new Boleto();

    public ControlBoleto() {
        super(Boleto.class);
    }

    /*public ControlBoleto(Boleto boleto, Class<Boleto> clazz) {
        super(clazz);
        this.boleto = boleto;
    }*/
    public ListaEnlazada<Boleto> getBoletos() {
        if (boletos.isEmpty()) {
            boletos = this.all();
        }
        return boletos;
    }

    public void setBoletos(ListaEnlazada<Boleto> boletos) {
        this.boletos = boletos;
    }

    public Boleto getBoleto() {
        if (boleto == null) {
            boleto = new Boleto();
        }
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public Boolean guardar(Boleto boleto) {
        boleto.setId(all().getLength());
        return persist(boleto);
    }

}
