package ar.edu.unahur.obj2.zonas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.profugos.IProfugo;

public class Zona {
	private List<IProfugo> profugos;
	private String nombre;
	
	public Zona(String nombre, List<IProfugo> profugos) {
		this.nombre = nombre;
		this.profugos = new ArrayList<IProfugo>(profugos);
	}
	
	public List<IProfugo> getProfugos(){
		return profugos;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void eliminarProfugos(List<IProfugo> profugos) {
		this.profugos.removeAll(profugos);
	}

	public Integer getMenorHabilidadDeLosProfugos() {
		return profugos.stream().mapToInt(p -> p.getHabilidad()).min().orElseThrow();
	}

	

}
