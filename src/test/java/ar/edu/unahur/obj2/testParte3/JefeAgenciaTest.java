package ar.edu.unahur.obj2.testParte3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ar.edu.unahur.obj2.jefeAgencia.JefeDeLaAgencia;
import ar.edu.unahur.obj2.profugos.IProfugo;
import ar.edu.unahur.obj2.profugos.*;
import ar.edu.unahur.obj2.cazadores.*;
import ar.edu.unahur.obj2.zonas.Zona;
import java.util.List;



class JefeAgenciaTest {

    CazadorUrbano urbano = new CazadorUrbano(50);
    CazadorRural rural = new CazadorRural(50);
    CazadorSigiloso sigiloso = new CazadorSigiloso(50);

    JefeDeLaAgencia jefe = new JefeDeLaAgencia(List.of(urbano, rural, sigiloso));;

    IProfugo p1 = new ProfugoBasico(40, 30, false); // capturable por Urbano
    IProfugo p2 = new ProfugoBasico(60, 60, true);  // no capturable
    IProfugo p3 = new ProfugoBasico(45, 40, false); // capturable por Urbano
    IProfugo p4 = new ProfugoBasico(90, 30, true);  // no capturable

    Zona zona = new Zona("Ciudad A", List.of(p1, p2, p3, p4));
    
    @Test
    void testCapturasYReporterias() {
        urbano.capturarProfugosDeZona(zona);
        rural.capturarProfugosDeZona(zona);
        sigiloso.capturarProfugosDeZona(zona);

        List<IProfugo> capturados = jefe.profugosCapturados();
        assertEquals(2, capturados.size()); 

        assertTrue(capturados.contains(p1));
        assertTrue(capturados.contains(p3));
        
        
        assertEquals(2,urbano.cantCapturas());
        assertEquals(0,rural.cantCapturas());
        assertEquals(0,sigiloso.cantCapturas());


        assertFalse(capturados.contains(p2));
        assertFalse(capturados.contains(p4));

        IProfugo masHabil = jefe.profugoMasHabil();
        assertEquals(40, masHabil.getHabilidad()); // p3 (p1 tiene 30)
        
        assertEquals(urbano,jefe.cazadorConMasCapturas());
    }

}



