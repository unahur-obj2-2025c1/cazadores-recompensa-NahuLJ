package ar.edu.unahur.obj2.profugos;

public class ArtesMarcialesAvanzadas implements IProfugo {
	private IProfugo decorado;
	
	public ArtesMarcialesAvanzadas(IProfugo decorado) {
		this.decorado = decorado;
	}
	
	@Override
	public Integer getInocencia() {
		return decorado.getInocencia();
	}

	@Override
	public Integer getHabilidad() {
		return Integer.min(100, decorado.getHabilidad() * 2);
	}

	@Override
	public Boolean esNervioso() {
		return decorado.esNervioso();
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
