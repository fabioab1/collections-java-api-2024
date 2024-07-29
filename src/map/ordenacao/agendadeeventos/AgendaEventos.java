package map.ordenacao.agendadeeventos;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        Evento evento = new Evento(nome, atracao);
        this.eventosMap.put(data, evento);
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(this.eventosMap);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();

        if (!this.eventosMap.isEmpty()) {
            Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(this.eventosMap);

            LocalDate proximaData = null;
            Evento proximoEvento = null;
            for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                if (proximaData.isEqual(dataAtual) || proximaData.isAfter(dataAtual)) {

                    System.out.println("O próximo evento: " + proximoEvento + " acontecerá na data: " + proximaData);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.SEPTEMBER, 30), "Evento 1", "Atração 1");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.OCTOBER, 30), "Evento 2", "Atração 2");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.DECEMBER, 31), "Evento 3", "Atração 3");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.AUGUST, 3), "Evento 4", "Atração 4");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.JULY, 30), "Evento 6", "Atração 6");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();
    }

}
