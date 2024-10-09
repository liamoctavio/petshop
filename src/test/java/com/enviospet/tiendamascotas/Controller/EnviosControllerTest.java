package com.enviospet.tiendamascotas.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import com.enviospet.tiendamascotas.Model.Envios;


import com.enviospet.tiendamascotas.Model.Envios;
import com.enviospet.tiendamascotas.Service.EnviosService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class EnviosControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EnviosService enviosService;

    @InjectMocks
    private EnviosController enviosController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(enviosController).build();
    }

    @Test
    public void testListarEnvios() throws Exception {
        Envios envio1 = new Envios();
        envio1.setId(1L);
        envio1.setDestinatario("John Doe");

        Envios envio2 = new Envios();
        envio2.setId(2L);
        envio2.setDestinatario("Jane Doe");

        when(enviosService.listarEnvios()).thenReturn(Arrays.asList(envio1, envio2));

        mockMvc.perform(get("/envios")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].destinatario").value("John Doe"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].destinatario").value("Jane Doe"));

        verify(enviosService, times(1)).listarEnvios();
    }

    @Test
    public void testListarEnviosPorId() throws Exception {
        Envios envio = new Envios();
        envio.setId(1L);
        envio.setDestinatario("John Doe");

        when(enviosService.listarEnviosPorId(1L)).thenReturn(Optional.of(envio));

        mockMvc.perform(get("/envios/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.destinatario").value("John Doe"));

        verify(enviosService, times(1)).listarEnviosPorId(1L);
    }
}


