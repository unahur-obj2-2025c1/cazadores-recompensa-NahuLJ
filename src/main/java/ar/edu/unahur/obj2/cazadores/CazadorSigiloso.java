package ar.edu.unahur.obj2.cazadores;

import ar.edu.unahur.obj2.profugos.IProfugo;

public class CazadorSigiloso extends Cazador {
	
	public CazadorSigiloso(Integer experiencia) {
		super(experiencia);
	}
	
	@Override
	public Boolean condicionDeCaptura(IProfugo profugo) {
		return profugo.getHabilidad() < 50;
	}
	
	@Override
	public void intimidacionEspecifica(IProfugo profugo) {
		profugo.reducirHabilidad();
	}
}
