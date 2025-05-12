package ar.edu.unahur.obj2.profugos;

public class ProteccionLegal implements IProfugo{
	private IProfugo decorado;
	
	public ProteccionLegal(IProfugo decorado) {
		this.decorado = decorado;
	}
	
	@Override
	public Integer getInocencia() {
		return Integer.max(40, decorado.getInocencia());
	}

	@Override
	public Integer getHabilidad() {
		return decorado.getHabilidad();
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
		if (decorado.getInocencia() >= 42) {
			decorado.disminuirInocencia();
		}
	}
}
