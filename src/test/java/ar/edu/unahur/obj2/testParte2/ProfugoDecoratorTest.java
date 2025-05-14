package ar.edu.unahur.obj2.testParte2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import ar.edu.unahur.obj2.profugos.*;


class ProfugoDecoratorTest {

    @Test
    void testArtesMarcialesNoPasaDe100() {
    	IProfugo p = new ProfugoBasico(30, 60, true);
        IProfugo entrenado = new ArtesMarcialesAvanzadas(p);
        assertEquals(100, entrenado.getHabilidad());

        p = new ProfugoBasico(30, 40, true);
        entrenado = new ArtesMarcialesAvanzadas(p);
        assertEquals(80, entrenado.getHabilidad());
    }

    @Test
    void testEntrenamientoEliteNuncaNervioso() {
        IProfugo p = new ProfugoBasico(50, 40, true);
        IProfugo elite = new EntrenamientoDeElite(p);
        assertFalse(elite.esNervioso());

        elite.volverseNervioso(); // no tiene efecto
        assertFalse(elite.esNervioso());
    }

    @Test
    void testProteccionLegalInocenciaMinima() {
        IProfugo p = new ProfugoBasico(35, 60, true);
        IProfugo legal = new ProteccionLegal(p);
        assertEquals(40, legal.getInocencia());

        legal.disminuirInocencia();
        assertEquals(40, legal.getInocencia());
    }
    
    @Test
    void testDecoradoresCombinados() {
        IProfugo base = new ProfugoBasico(30, 30, true);
        IProfugo decorado = new ProteccionLegal(
                                new EntrenamientoDeElite(
                                  new ArtesMarcialesAvanzadas(base)));

        assertEquals(60, decorado.getHabilidad()); // 30 * 2
        assertEquals(40, decorado.getInocencia()); // mínimo 40
        assertFalse(decorado.esNervioso());

        // Intimidaciones
        decorado.reducirHabilidad();
        decorado.disminuirInocencia();
        decorado.volverseNervioso();

        assertEquals(50, decorado.getHabilidad());
        assertEquals(40, decorado.getInocencia());
        assertFalse(decorado.esNervioso());
    }
    
}
