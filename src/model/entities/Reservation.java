package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer numeroQuarto;
    private Date dataDeEntrada;
    private Date dataDeSaida;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer numeroQuarto, Date dataDeEntrada, Date dataDeSaida) {
        this.numeroQuarto = numeroQuarto;
        this.dataDeEntrada = dataDeEntrada;
        this.dataDeSaida = dataDeSaida;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getDataDeEntrada() {
        return dataDeEntrada;
    }

    public Date getDataDeSaida() {
        return dataDeSaida;
    }

    public long duracao(){
        long dif = dataDeSaida.getTime() - dataDeEntrada.getTime();
        return TimeUnit.DAYS.convert(dif,TimeUnit.MILLISECONDS);
    }

    public String updateData(Date checkIn, Date checkOut){

        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)){
            return "Erro na Reserva: as reservas de atualização devem ser futuras.";
        }
        if ( !checkOut.after(checkIn)) {
            return "Error na reserva: Data de Saida deve ser posterior da Data de Entrada";
        }
        this.dataDeEntrada = checkIn;
        this.dataDeSaida = checkOut;
        return null;
    }

    @Override
    public String toString(){
        return "Quarto " + numeroQuarto + ", Data de Entrada: " + sdf.format(dataDeEntrada) + ", Data de Saida: "+ sdf.format(dataDeSaida)
                + ", " + duracao() + " noites";
    }

}
