package com.enviospet.tiendamascotas.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EnviosTest {

    @Test
    public void testGetAndSetDestinatario() {
        Envios envio = new Envios();
        envio.setDestinatario("John Doe");
        assertEquals("John Doe", envio.getDestinatario());
    }

    @Test
    public void testGetAndSetDireccion() {
        Envios envio = new Envios();
        envio.setDireccion("123 Main St");
        assertEquals("123 Main St", envio.getDireccion());
    }

    @Test
    public void testGetAndSetPeso() {
        Envios envio = new Envios();
        envio.setPeso(5.5);
        assertEquals(5.5, envio.getPeso());
    }

    @Test
    public void testEnviosConstructor() {
        Envios envio = new Envios();
        envio.setDestinatario("Jane Doe");
        envio.setDireccion("456 Elm St");
        envio.setPeso(10.0);

        assertEquals("Jane Doe", envio.getDestinatario());
        assertEquals("456 Elm St", envio.getDireccion());
        assertEquals(10.0, envio.getPeso());
    }

}
