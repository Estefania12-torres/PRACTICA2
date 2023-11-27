/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.dao.Implements;

import Controlador.TDA.Listas.ListaEnlazada;
import Controlador.dao.DaoImplements;
import modelo.Pasajero;

/**
 *
 * @author Usuario
 */
public class ControlPasajero extends DaoImplements<Pasajero> {

    private Pasajero pasajero = new Pasajero();
    private ListaEnlazada<Pasajero> pasajeros = new ListaEnlazada<>();

    public ControlPasajero() {
        super(Pasajero.class);
    }

    public ControlPasajero(Pasajero pasajero, Class<Pasajero> clazz) {
        super(clazz);
        this.pasajero = pasajero;
    }

    public ListaEnlazada<Pasajero> getPasajeros() {
        if (pasajeros.isEmpty()) {
            pasajeros = this.all();
        }
        return pasajeros;

    }

    public void setPasajeros(ListaEnlazada<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public Boolean guardar() {
        if (pasajero != null) {
            pasajeros.add(pasajero);
            pasajero = null;
            return true;
        }
        return false;
    }

    public Pasajero getPasajero() {
        if (pasajero == null) {
            pasajero = new Pasajero();
        }
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Boolean guardar(Pasajero pasajero) {
        pasajero.setId(all().getLength());
        return persist(pasajero);
    }

}
