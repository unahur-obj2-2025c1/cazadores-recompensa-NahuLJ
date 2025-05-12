package ar.edu.unahur.obj2.testParte1;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.cazadores.*;
import ar.edu.unahur.obj2.profugos.*;
import ar.edu.unahur.obj2.zonas.Zona;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;


public class ProcesoCapturaTest {

	@Test
	public void testCapturaCazadorUrbano() {
	    CazadorUrbano cazador = new CazadorUrbano(10); // experiencia 10

	    IProfugo p1 = new ProfugoBasico(5, 60, true);  // No debe ser capturado
	    IProfugo p2 = new ProfugoBasico(8, 40, false); // Debe ser capturado

	    Zona zona = new Zona("Ciudad", List.of(p1, p2));

	    cazador.capturarProfugosDeZona(zona);

	    // p2 fue capturado y eliminado de la zona
	    assertFalse(zona.getProfugos().contains(p2));

	    // p1 no fue capturado, fue intimidado
	    assertTrue(zona.getProfugos().contains(p1));

	    // Verificamos que p1 fue intimidado correctamente
	    assertEquals(3, p1.getInocencia()); // 5 - 2 = 3
	    assertFalse(p1.esNervioso());       // Cazador urbano lo vuelve no nervioso
	    
	    // Experiencia final: 10 (inicial) + 60 (mínima habilidad intimidado) + 2*1 (capturado) = 72
	    assertEquals(72, cazador.getExperiencia());
	}

    
    
	@Test
	public void testCapturaSigiloso() {
	    CazadorSigiloso cazador = new CazadorSigiloso(15);
	    IProfugo p1 = new ProfugoBasico(10, 40, true); // Capturado
	    IProfugo p2 = new ProfugoBasico(12, 60, false); // Intimidado

	    Zona zona = new Zona("Suburbios", new ArrayList<>(List.of(p1, p2)));
	    cazador.capturarProfugosDeZona(zona);

	    assertEquals(1, zona.getProfugos().size()); // Solo p22 debe quedar
	    assertEquals(p2, zona.getProfugos().get(0));

	    assertEquals(10, p2.getInocencia()); // Inocencia de p22 disminuida
	    assertEquals(55, p2.getHabilidad()); // Habilidad de p22 reducida en 5

	    assertEquals(72, cazador.getExperiencia()); // += 55 + (2 * 1) = 72
	}

    
    
    @Test
    public void testCapturaRural() {
        CazadorRural cazador = new CazadorRural(20);
        IProfugo p1 = new ProfugoBasico(10, 30, true); // Capturable
        IProfugo p2 = new ProfugoBasico(15, 45, false); // Intimidado

        Zona zona = new Zona("Campo", new ArrayList<>(List.of(p1, p2)));
        cazador.capturarProfugosDeZona(zona);

        assertEquals(1, zona.getProfugos().size());
        assertEquals(p2, zona.getProfugos().get(0));
        assertTrue(p2.esNervioso()); // El rural lo pone nervioso
        assertEquals(13, p2.getInocencia());

        assertEquals(20 + 45 + (2 * 1), cazador.getExperiencia());
    }
    
    
    @Test
    public void testInocenciaYNivelNoNegativos() {
        CazadorSigiloso cazador = new CazadorSigiloso(5);
        IProfugo p1 = new ProfugoBasico(10, 3, true); // No capturable

        Zona zona = new Zona("Oculta", List.of(p1));
        cazador.capturarProfugosDeZona(zona);

        assertEquals(0, p1.getHabilidad()); // No puede ser negativa
        assertEquals(8, p1.getInocencia()); // No baja de 0
    }
    
}

