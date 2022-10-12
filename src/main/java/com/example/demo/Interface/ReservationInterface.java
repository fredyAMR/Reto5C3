/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Interface;

import com.example.demo.Modelo.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Fredy
 */
public interface ReservationInterface extends CrudRepository<Reservation, Integer> {
    //Todos los query methods son consultas que van a devolver listas entonces para ello Se invoca la entidad (Reservation)
    //y se utiliza el query metodo findAll para hacer el query de status 
    //Status hace referencia al atributo status de la tabla reservation de la capa modelo
    //ya que uno de los informes debe presentar cuantas completadas y cuantas canceladas
    //luego se pone el tipo de dato(String) y el nombre de la variable(status)
    //y este seria el primer query method
    public List<Reservation> findAllByStatus (String status);
    //luego se le hace la consulta o query method al intervalo de las fechas
    //y se utiliza el query metodo findAll para hacer el query de las fechas, StartDate 
    //StartDate hace referencia al atributo startDate de la tabla reservation de la capa modelo
    //luego se pone el tipo de dato(Date) y el nombre de la variable(datoUno,datoDos)
    //y este seria el segundo query method
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore (Date datoUno, Date datoDos);
    //para hacer el qeury del top de los clientes
    //la anotacion @Query es para poder hacer consultas sql dentro de la interface
    //se crea el alias(c.client) se crea un contador con la palabra count y se busca la palabra client de la tabla Reservation
    //y se ordena(order by) de manera descendente(Desc)
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
	    public List<Object[]> countTotalReservationByClient();
    // se empaqueta para luego poderlo usar dentro de las otras clases(countTotalReservationByClient()) 
}
