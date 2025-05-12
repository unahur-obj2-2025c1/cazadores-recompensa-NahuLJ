package ar.edu.unahur.obj2.profugos;

public class EntrenamientoDeElite implements IProfugo{
	private IProfugo decorado;
	
	public EntrenamientoDeElite(IProfugo decorado) {
		this.decorado = decorado;
	}
	
	@Override
	public Integer getInocencia() {
		return decorado.getInocencia();
	}

	@Override
	public Integer getHabilidad() {
		return decorado.getHabilidad();
	}

	@Override
	public Boolean esNervioso() {
		return false;
	}

	@Override
	public void volverseNervioso() {
		decorado.volverseNervioso();
	}

	@Override
	public void dejarDeEstarNervioso() {
		decorado.dejarDeEstarNervioso();
	}

	@Override
	public void reducirHabilidad() {
		decorado.reducirHabilidad();
	}

	@Override
	public void disminuirInocencia() {
		decorado.disminuirInocencia();
	}
}
