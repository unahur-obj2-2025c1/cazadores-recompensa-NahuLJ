package ar.edu.unahur.obj2.jefeAgencia;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import ar.edu.unahur.obj2.cazadores.*;
import ar.edu.unahur.obj2.profugos.IProfugo;

public class JefeDeLaAgencia {
	private List<Cazador> cazadores;
	
	public JefeDeLaAgencia(List<Cazador> cazadores) {
		this.cazadores = new ArrayList<>(cazadores);
	}
	
	public List<IProfugo> profugosCapturados(){
		List<IProfugo> profugos = new ArrayList<>();
		cazadores.stream().forEach(c -> profugos.addAll(c.getProfugosCapturados()));
		
		return profugos;
	}
	
	public IProfugo profugoMasHabil() {
		return this.profugosCapturados().stream()
				.max(Comparator.comparingInt(IProfugo::getHabilidad)).orElseThrow();
	}
	
	public Cazador cazadorConMasCapturas() {
		return cazadores.stream().max(Comparator.comparingInt(Cazador::cantCapturas)).orElseThrow();
	}
}
