package ar.edu.unahur.obj2.cazadores;

import java.util.ArrayList;

import ar.edu.unahur.obj2.profugos.IProfugo;
import ar.edu.unahur.obj2.zonas.Zona;

public abstract class Cazador {
	private Integer experiencia;
	private ArrayList<IProfugo> profugosCapturados = new ArrayList<>();
	
	public Cazador(Integer experiencia) {
		this.experiencia = experiencia;
	}
	
	public Integer getExperiencia() {
		return experiencia;
	}
	
	public void capturar(IProfugo profugo) {
		if (this.puedeCapturar(profugo)){
			profugosCapturados.add(profugo);
		}
		else {
			this.intimidar(profugo);
		}
	}
	
	public void capturarProfugosDeZona(Zona unaZona) {
		Integer cantProfugosAntesDeCapturar = profugosCapturados.size();
		unaZona.getProfugos().forEach(p -> this.capturar(p));
		unaZona.eliminarProfugos(this.profugosCapturados);
		
		this.experiencia += unaZona.getMenorHabilidadDeLosProfugos() + 
				2 * (profugosCapturados.size() - cantProfugosAntesDeCapturar);
	}
	
	public void intimidar(IProfugo profugo) {
		profugo.disminuirInocencia();
		this.intimidacionEspecifica(profugo);
	}

	public abstract void intimidacionEspecifica(IProfugo profugo);

	public Boolean puedeCapturar(IProfugo profugo) {
		return experiencia > profugo.getInocencia() && this.condicionDeCaptura(profugo);
	}
	
	public abstract Boolean condicionDeCaptura(IProfugo profugo);
	
	
}
