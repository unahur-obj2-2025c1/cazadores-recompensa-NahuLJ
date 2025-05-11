package ar.edu.unahur.obj2.cazadores;

import java.util.List;

import ar.edu.unahur.obj2.profugos.IProfugo;
import ar.edu.unahur.obj2.zonas.Zona;

public abstract class Cazador {
	private Integer experiencia;
	
	public Cazador(Integer experiencia) {
		this.experiencia = experiencia;
	}
	
	public void capturar(IProfugo profugo,Zona unaZona) {
		if (this.puedeCapturar(profugo)){
			unaZona.eliminarProfugo(profugo);
		}
		else {
			this.intimidar(profugo);
		}
	}
	
	public void capturarProfugosDeZona(Zona unaZona) {
		Integer cantProfugosAntesDeCapturar = unaZona.getCantidadDeProfugos();
		unaZona.getProfugos().forEach(p -> this.capturar(p,unaZona));
		this.experiencia += unaZona.getHabilidadDeProfugoConMenorHabilidad() + 
				2 * (cantProfugosAntesDeCapturar - unaZona.getCantidadDeProfugos());
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
