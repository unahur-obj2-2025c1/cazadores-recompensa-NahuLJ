package ar.edu.unahur.obj2.zonas;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ar.edu.unahur.obj2.profugos.IProfugo;

public class Zona {
	private List<IProfugo> profugos;
	private String nombre;
	
	public Zona(String nombre, List<IProfugo> profugos) {
		this.nombre = nombre;
		this.profugos = profugos;
	}
	
	public List<IProfugo> getProfugos(){
		return profugos;
	}

	public void eliminarProfugo(IProfugo profugo) {
		profugos.remove(profugo);
	}

	public Integer getCantidadDeProfugos() {
		return profugos.size();
	}

	public Integer getHabilidadDeProfugoConMenorHabilidad() {
		return profugos.stream().mapToInt(p -> p.getHabilidad()).min().orElseThrow();
	}

}
