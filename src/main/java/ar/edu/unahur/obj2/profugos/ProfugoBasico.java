package ar.edu.unahur.obj2.profugos;

public class ProfugoBasico implements IProfugo {
	private Integer inociencia;
	private Integer habilidad;
	private Boolean estaNervioso;
	
	public ProfugoBasico(Integer inociencia, Integer habilidad, Boolean estaNervioso) {
		this.inociencia = inociencia;	
		this.habilidad = habilidad;	
		this.estaNervioso = estaNervioso;	
	}
	
	@Override
	public Integer getInocencia() {
		return inociencia;
	}

	@Override
	public Integer getHabilidad() {
		return habilidad;
	}

	@Override
	public Boolean esNervioso() {
		return estaNervioso;
	}

	@Override
	public void volverseNervioso() {
		this.estaNervioso = true;
	}

	@Override
	public void dejarDeEstarNervioso() {
		this.estaNervioso = false;
	}

	@Override
	public void reducirHabilidad() {
		this.habilidad = Integer.max(0, habilidad - 5);
	}

	@Override
	public void disminuirInocencia() {
		this.inociencia = Integer.max(0, inociencia - 2);
	} 
	 
}
